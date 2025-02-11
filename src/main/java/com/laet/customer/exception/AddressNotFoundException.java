package com.laet.customer.exception;

import com.laet.customer.entity.Address;

public class AddressNotFoundException extends RuntimeException{

    public AddressNotFoundException (Long id) {
        super("O endereço nao conseguiu encontrar o cliente com o ID: " + id);
    }

    public AddressNotFoundException(String message) {
        super(message);
    }
}
