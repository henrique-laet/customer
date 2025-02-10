package com.laet.customer.exception;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(Long id){
        super("Cliente não encontrado com ID: " + id);
    }
}
