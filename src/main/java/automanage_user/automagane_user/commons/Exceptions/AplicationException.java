package com.ecommerce_rest.ecommerce_rest.commons.Exceptions;

import ch.qos.logback.core.status.ErrorStatus;

public class AplicationException extends RuntimeException{
    protected ErrorStatus errorStatus;

    public AplicationException(String message) {
        super(message);
    }

    public AplicationException(String message, ErrorStatus errorStatus) {
        super(message);
        this.errorStatus = errorStatus;
    }

}
