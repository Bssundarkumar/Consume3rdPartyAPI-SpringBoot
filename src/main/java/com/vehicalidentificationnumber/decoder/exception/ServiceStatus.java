package com.vehicalidentificationnumber.decoder.exception;

import org.springframework.http.HttpStatus;

public enum ServiceStatus implements Status{
    SERVICE_REQUEST_PROCESS_ERR("Bad Request",1001, HttpStatus.BAD_REQUEST),
    SERVICE_ERROR("Input Error", 500, HttpStatus.INTERNAL_SERVER_ERROR);

    private String errorMessage;
    private int statusCode;
    private HttpStatus httpStatus;
    ServiceStatus(String errorMessage, int statusCode, HttpStatus httpStatus) {
        this.errorMessage = errorMessage;
        this.statusCode = statusCode;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getName() {
        return this.name();
    }

    @Override
    public String getMessage() {
        return this.errorMessage;
    }

    @Override
    public int getCode() {
        return this.httpStatus.value();
    }

    @Override
    public int getSubCode() {
        return this.statusCode;
    }

    @Override
    public String toString(String addErrMsg) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("["+getName());
        stringBuilder.append("#"+ getMessage());
        stringBuilder.append("#"+getCode());
        stringBuilder.append("#"+getSubCode());
        if(addErrMsg =="" || addErrMsg == null){
            stringBuilder.append("#-> "+ addErrMsg);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static ServiceStatus getStatus(HttpStatus httpStatus){
        for(ServiceStatus status: values()){
            if(status.httpStatus.equals(httpStatus)){
                return status;
            }
        }
        return SERVICE_REQUEST_PROCESS_ERR;
    }
}
