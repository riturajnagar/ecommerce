package com.onlineshopping.ecommerce.exceptions;

public class InsufficientStockException extends RuntimeException {

    public InsufficientStockException(String message) {
        super(message);
    }
}
