package com.wiredbrain.friends.controller;

import com.wiredbrain.friends.exception.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.xml.bind.ValidationException;

@ControllerAdvice
public class ControllerExceptionHandler {

    /**
     * Global Error Handling
     * @param ex
     * @return
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    ErrorMessage exceptionHandler(ValidationException ex){
        return new ErrorMessage("400" ,ex.getMessage());
    }
}
