package com.naijatravelshop.web.exceptions;

/**
 * Created by jnwanya on
 * Sat, 06 Apr, 2019
 */
public class BusinessLogicConflictException extends RuntimeException {
    /*
       This is used when there is conflict in the business logic.
       Not that the user request is invalid or incorrect but the business logic
       required to process the request isn't satisfied.
        */
    public BusinessLogicConflictException(String errorMessage) {
        super(errorMessage);
    }
}
