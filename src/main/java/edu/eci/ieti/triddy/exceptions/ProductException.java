package edu.eci.ieti.triddy.exceptions;

public class ProductException extends Exception {
    public static final String CREATE_PRODUCT_ERROR = "There was an error creating the product";
    public ProductException() {
        super();
    }
    public ProductException(String message) {
        super(message);
    }
}
