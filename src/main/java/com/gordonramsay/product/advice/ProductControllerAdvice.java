package com.gordonramsay.product.advice;

import com.gordonramsay.product.exception.ProductNotFound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductControllerAdvice {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductControllerAdvice.class);

    @ExceptionHandler(ProductNotFound.class)
    public ResponseEntity<?> handleRuntimeException(ProductNotFound ex) {
        LOGGER.error("Product not found exception occurred, detailErrMsg= {}", ex.getDetailMessage());

        return ResponseEntity.status(ex.getHttpStatus())
                .body(ex.getDetailMessage());
    }
}
