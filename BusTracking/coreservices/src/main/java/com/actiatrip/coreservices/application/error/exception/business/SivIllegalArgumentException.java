package com.actiatrip.coreservices.application.error.exception.business;

public class SivIllegalArgumentException extends IllegalArgumentException {
    public SivIllegalArgumentException(String message) {
        super(message);
    }

    public SivIllegalArgumentException(String message, Throwable cause) {
        super(message, cause);
    }
}
