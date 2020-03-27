package com.vehicalidentificationnumber.decoder.exception;

public interface Status {

    String getName();
    String getMessage();
    int getCode();
    int getSubCode();
    String toString(String addErrMsg);
}
