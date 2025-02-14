package com.laet.customer.exception;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(){
        super("Cliente não encontrado com ID: " + id);
    }
}
