package com.gordonramsay.product.exception;

public class ProductNotFound extends EntityNotFound {
    public ProductNotFound() {
        super("Product not found!");
    }
}
