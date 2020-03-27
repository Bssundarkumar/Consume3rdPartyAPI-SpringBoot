package com.vehicalidentificationnumber.decoder.model;

import com.vehicalidentificationnumber.decoder.exception.VinException;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class ResponseVin {
    private String vin;
    private int count;
    private String message;
    private Map<String, String> vehicleDetails;
    private VinException vinException;
    private int httpStatus;

    public ResponseVin() {
    }

    public ResponseVin(Vin vin, Map<String, String> vehicleDetails) {
        this.vin = vin.getSearchCriteria().substring(3, vin.getSearchCriteria().length());
        this.count = vin.getCount();
        this.message = vin.getMessage();
        this.vehicleDetails = vehicleDetails;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Map<String, String> getVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(Map<String, String> vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }

    public VinException getVinException() {
        return vinException;
    }

    public void setVinException(VinException vinException) {
        this.vinException = vinException;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }
}
