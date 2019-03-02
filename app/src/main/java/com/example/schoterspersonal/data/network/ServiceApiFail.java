package com.example.schoterspersonal.data.network;

public class ServiceApiFail extends Throwable {

    private String mErrorCode;

    private String mErrorMessage;

    public ServiceApiFail(String errorCode, String errorMessage) {
        super(errorMessage);
        mErrorCode = errorCode;
        mErrorMessage = errorMessage;
    }

    public ServiceApiFail(String errorMessage) {
        mErrorMessage = errorMessage;
    }

    public String getErrorCode() {
        return mErrorCode;
    }

    public void setErrorCode(String errorCode) {
        mErrorCode = errorCode;
    }

    public String getErrorMessage() {
        return mErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        mErrorMessage = errorMessage;
    }

}
