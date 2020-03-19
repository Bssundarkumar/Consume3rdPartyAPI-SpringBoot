package com.vehicalidentificationnumber.decoder.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Vin {
    @JsonProperty(value = "Count")
    private int count;
    @JsonProperty(value = "Message")
    private String message;
    @JsonProperty(value = "SearchCriteria")
    private String searchCriteria;
    @JsonProperty(value = "Results")
    private List<Results> resultsList;

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

    public String getSearchCriteria() {
        return searchCriteria;
    }

    public void setSearchCriteria(String searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    public List<Results> getResultsList() {
        return resultsList;
    }

    public void setResultsList(List<Results> resultsList) {
        this.resultsList = resultsList;
    }

    @Override
    public String toString() {
        return "Vin{" +
                "count=" + count +
                ", message='" + message + '\'' +
                ", searchCriteria='" + searchCriteria + '\'' +
                ", resultsList=" + resultsList +
                '}';
    }
}
