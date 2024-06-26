package com.sunshine.co.BINI.STORE.NotFoundException;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id){
        super("Could not found product with " + id); 

    }
}
