package com.codeforfood.mapfood.exception;

public class ClientShoppingCartAlreadyExistsException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ClientShoppingCartAlreadyExistsException(String msg) {
        super(msg);
    }
}
