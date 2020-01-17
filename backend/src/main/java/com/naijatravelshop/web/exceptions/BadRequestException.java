package com.naijatravelshop.web.exceptions;

/**
 * Created by jnwanya on
 * Sun, 31 Mar, 2019
 */
public class BadRequestException extends RuntimeException {

    public BadRequestException(String errorMessage) {
        super(errorMessage);
    }
}
