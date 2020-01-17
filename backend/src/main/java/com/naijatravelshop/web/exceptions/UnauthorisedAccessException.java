package com.naijatravelshop.web.exceptions;

/**
 * Created by jnwanya on
 * Mon, 01 Apr, 2019
 */
public class UnauthorisedAccessException extends RuntimeException {

    public UnauthorisedAccessException(String message){
        super(message);
    }
}
