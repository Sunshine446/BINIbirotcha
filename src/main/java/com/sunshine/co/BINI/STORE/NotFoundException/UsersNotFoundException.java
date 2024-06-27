package com.sunshine.co.BINI.STORE.NotFoundException;

public class UsersNotFoundException extends RuntimeException {
    public UsersNotFoundException(Long id){
        super("Could not found product with " + id); 

    }
}
