package com.vehicalidentificationnumber.decoder.controller;

import com.vehicalidentificationnumber.decoder.model.ResponseVin;
import com.vehicalidentificationnumber.decoder.model.Vin;
import com.vehicalidentificationnumber.decoder.service.VehicleFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class VinController {

    @Autowired
    private VehicleFormatter vehicleFormatter;

    private static Logger logger = LoggerFactory.getLogger(VinController.class);

    private static String hostUrl = "https://vpic.nhtsa.dot.gov/api/vehicles/DecodeVinExtended/";
    private static String outputFormat = "?format=json";

    @GetMapping(value = "/vin")
    private ResponseEntity getVin(@RequestParam(value = "id", required = true) String id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Vin> responseEntity = restTemplate.getForEntity(hostUrl + id + outputFormat, Vin.class);
        Vin vin = responseEntity.getBody();
        ResponseVin responseVin = new ResponseVin(vin, vehicleFormatter.getDetails(vin));
        return  ResponseEntity.status(responseEntity.getStatusCode()).body(responseVin);
    }

}
