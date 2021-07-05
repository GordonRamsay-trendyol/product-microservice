package com.gordonramsay.product.exception;

import org.springframework.http.HttpStatus;

public abstract class EntityNotFound extends RuntimeException {
    private final HttpStatus httpStatus;
    private final String detailMessage;

    protected EntityNotFound(HttpStatus httpStatus, String detailMessage) {
        this.httpStatus = httpStatus;
        this.detailMessage = detailMessage;
    }

    protected EntityNotFound(String detailMessage) {
        this(HttpStatus.NOT_FOUND, detailMessage);
    }

    public String getDetailMessage() {
        return detailMessage;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
