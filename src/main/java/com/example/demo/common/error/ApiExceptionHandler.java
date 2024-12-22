package com.example.demo.common.error;


import com.example.demo.common.exception.ResourceAlreadyExistsException;
import com.example.demo.common.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class ApiExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({
            ResourceNotFoundException.class,
            ResourceAlreadyExistsException.class
    })
    @ResponseBody
    public ErrorMessage notFoundRequest(ResourceNotFoundException ex) {
        return new ErrorMessage(ex, HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
