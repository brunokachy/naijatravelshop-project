package com.naijatravelshop.web.controllers.advice;

import com.naijatravelshop.web.pojo.ApiResponse;
import com.naijatravelshop.web.exceptions.BadRequestException;
import com.naijatravelshop.web.exceptions.BusinessLogicConflictException;
import com.naijatravelshop.web.exceptions.NotFoundException;
import com.naijatravelshop.web.exceptions.UnauthorisedAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jnwanya on
 * Sat, 06 Apr, 2019
 */
@ControllerAdvice(basePackages = {"com.naijatravelshop.web.controllers.api"})
public class RestApiControllerAdvice {

    private static final Logger log = LoggerFactory.getLogger(RestApiControllerAdvice.class);

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity handleException(Exception exception) {
        log.debug("Exception: {}", exception.getMessage());
        exception.printStackTrace();
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setMessage("Sorry, unable to process request at the moment.");
        return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity handleRuntimeException(RuntimeException exception) {
        log.error("RuntimeException: {}", exception.getMessage());
        exception.printStackTrace();
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setMessage("Sorry, an error occurred while processing your request..");
        return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity handleBadRequestException(BadRequestException e) {
        ApiResponse<String> apiResponse = new ApiResponse<>();
        log.debug("error message: {}", e.getMessage());
        apiResponse.setMessage(e.getMessage());
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotFoundException(NotFoundException e) {
        ApiResponse<String> apiResponse = new ApiResponse<>();
        log.debug("error message: {}", e.getMessage());
        apiResponse.setMessage(e.getMessage());
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnauthorisedAccessException.class)
    public ResponseEntity handleUnauthorisedException(UnauthorisedAccessException e) {
        ApiResponse<String> apiResponse = new ApiResponse<>();
        log.debug("error message: {}", e.getMessage());
        apiResponse.setMessage(e.getMessage());
        return new ResponseEntity<>(apiResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(BusinessLogicConflictException.class)
    public ResponseEntity handleBusinessLogicConflictException(BusinessLogicConflictException e) {
        ApiResponse<String> apiResponse = new ApiResponse<>();
        log.debug("error message: {}", e.getMessage());
        apiResponse.setMessage(e.getMessage());
        return new ResponseEntity<>(apiResponse, HttpStatus.CONFLICT);
    }
}
