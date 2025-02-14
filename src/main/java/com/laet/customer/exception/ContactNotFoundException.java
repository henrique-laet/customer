package com.laet.customer.exception;

public class ContactNotFoundException extends RuntimeException{

    public ContactNotFoundException (Long id) {
        super("O Contato nao conseguiu encontrar o cliente com o ID: " + id);
    }

    public ContactNotFoundException (String message) {
        super(message);
    }
}
