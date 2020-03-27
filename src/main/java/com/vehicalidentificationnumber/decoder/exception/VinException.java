package com.vehicalidentificationnumber.decoder.exception;

public class VinException extends Exception {
    private  static final long serialVersionUID = -73782938L;
    private Status status;

    public VinException() {
    }

    public VinException(String message) {
        super(message);
    }

    public VinException(Throwable cause) {
        super(cause);
    }

    public Status getStatus(){
        return status;
    }

    public VinException(String message, Throwable cause) {
        super(message, cause);
    }

    public VinException(final Status status){
        super();
        this.status = status;
    }

    public VinException(final Status status, String message){
        super(message);
        this.status = status;
    }

    public VinException(final Status status, Throwable cause){
        super(cause);
        this.status = status;
    }

    public VinException(final Status status, String message, Throwable cause){
        super(message, cause);
        this.status = status;
    }

    public String getDetailedErrorMessage(){
        StringBuilder stringBuilder = new StringBuilder();
        if(status != null){
            stringBuilder.append(status.toString(""));
        }
        stringBuilder.append("->"+this.getMessage());
        if(this.getCause() != null){
            stringBuilder.append("## ->" + this.getCause().getMessage());
        }
        return stringBuilder.toString();
    }


}
