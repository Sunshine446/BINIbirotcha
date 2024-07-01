package com.sunshine.co.BINI.STORE.NotFoundException;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long id){
        super("Could not found order with" + id);
    }

}
