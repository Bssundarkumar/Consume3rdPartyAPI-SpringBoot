package com.vehicalidentificationnumber.decoder.model;

import java.util.Map;

public class ResponseVin {
    private String vin;
    private int count;
    private String message;
    private Map<String, String> vehicleDetails;

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
}
