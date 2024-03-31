package com.dinogo.vacationscalc.exceptionhandling;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CalcExceptionHandler {

    @ExceptionHandler
    public Error handleException(
            Exception exp) {
        return new Error(exp.getMessage());
    }
}
