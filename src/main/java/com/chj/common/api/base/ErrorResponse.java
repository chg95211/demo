package com.chj.common.api.base;

public class ErrorResponse {

    String errorCode;
    String errorSubCode;
    String errorMsg;
    Object errorDetails;

    public ErrorResponse() {
    }

    public ErrorResponse(Code code) {
        this.errorCode = code.getCode();
        switch (code) {
        case IG_ERROR:
            setErrorMsg(Code.IG_ERROR.getMessage());
            break;
        case SYSTEM_ERROR:
            setErrorMsg(Code.SYSTEM_ERROR.getMessage());
            break;
        default:
            setErrorMsg("unknown");
            break;
        }
    }

    public ErrorResponse(Code codeType, String message) {
        this.errorCode = codeType.getCode();
        this.errorMsg = message;
    }

    public ErrorResponse(Code errorCode, String subCode, String message, Object detail) {
        super();
        this.errorCode = errorCode.getCode();
        this.errorSubCode = subCode;
        this.errorMsg = message;
        this.errorDetails = detail;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorSubCode() {
        return errorSubCode;
    }

    public void setErrorSubCode(String errorSubCode) {
        this.errorSubCode = errorSubCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Object getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(Object errorDetails) {
        this.errorDetails = errorDetails;
    }

}
