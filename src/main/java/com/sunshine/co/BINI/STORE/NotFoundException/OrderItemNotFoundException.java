package com.sunshine.co.BINI.STORE.NotFoundException;

public class OrderItemNotFoundException extends RuntimeException {
    public OrderItemNotFoundException(Long id){
        super("Could not found orderitem with" + id);
    }

}