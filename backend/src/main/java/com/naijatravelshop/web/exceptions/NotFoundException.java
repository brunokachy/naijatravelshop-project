package com.naijatravelshop.web.exceptions;

/**
 * Created by jnwanya on
 * Mon, 01 Apr, 2019
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
