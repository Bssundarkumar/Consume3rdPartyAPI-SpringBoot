package com.vehicalidentificationnumber.decoder.controller;

import com.vehicalidentificationnumber.decoder.exception.ServiceStatus;
import com.vehicalidentificationnumber.decoder.exception.VinException;
import com.vehicalidentificationnumber.decoder.model.ResponseVin;
import com.vehicalidentificationnumber.decoder.model.Vin;
import com.vehicalidentificationnumber.decoder.service.VehicleFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLOutput;

@RestController
public class VinController {

    @Autowired
    private VehicleFormatter vehicleFormatter;


    private static Logger logger = LoggerFactory.getLogger(VinController.class);

    private static String hostUrl = "https://vpic.nhtsa.dot.gov/api/vehicles/DecodeVinExtended/";
    private static String outputFormat = "?format=json";

    @GetMapping(value = "/vin")
    private ResponseEntity getVin(@RequestParam(value = "id", required = true) String id) throws RuntimeException {
        ResponseVin responseVin = new ResponseVin();
        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<Vin> responseEntity = restTemplate.getForEntity(hostUrl + id + outputFormat, Vin.class);
            if(responseEntity.getBody()==null){
                responseVin.setVinException(new VinException(ServiceStatus.SERVICE_ERROR));
                responseVin.setHttpStatus(ServiceStatus.SERVICE_ERROR.getCode());
            }else if(responseEntity.getStatusCode().equals(HttpStatus.INTERNAL_SERVER_ERROR)){
                responseVin.setVinException(new VinException(ServiceStatus.SERVICE_ERROR));
                responseVin.setHttpStatus(ServiceStatus.SERVICE_ERROR.getCode());
            }else{
                Vin vin = responseEntity.getBody();
                responseVin = new ResponseVin(vin, vehicleFormatter.getDetails(vin));
                if(vehicleFormatter.getErrorDetails(vin)){
                    responseVin.setVinException(new VinException(ServiceStatus.SERVICE_REQUEST_PROCESS_ERR));
                    responseVin.setHttpStatus(ServiceStatus.SERVICE_REQUEST_PROCESS_ERR.getCode());
                }else {
                    responseVin.setHttpStatus(responseEntity.getStatusCode().value());
                }
            }
        }catch (Exception e){
            System.out.println("HI DLNG MISSINg U");
        }


        return  ResponseEntity.status(responseVin.getHttpStatus()).body(responseVin);
    }

}
