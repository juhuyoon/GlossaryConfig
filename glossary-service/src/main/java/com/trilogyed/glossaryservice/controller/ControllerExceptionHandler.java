package com.trilogyed.glossaryservice.controller;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler({IllegalArgumentException.class})

    //Illegal Argument Exception Handler
    public ResponseEntity<VndErrors> illegalArgumentCensored(IllegalArgumentException e, WebRequest request) {
        VndErrors err = new VndErrors(request.toString(), e.getMessage());
        ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<VndErrors> methodNotValid(MethodArgumentNotValidException e, WebRequest request) {
        BindingResult res = e.getBindingResult();
        List<FieldError> fieldErrors = res.getFieldErrors();
        List<VndErrors.VndError> vndErrorList = new ArrayList<>();

        for(FieldError fieldError : fieldErrors) {
            VndErrors.VndError vndError = new VndErrors.VndError(request.toString(), fieldError.getDefaultMessage());
            vndErrorList.add(vndError);
        }
        VndErrors errors = new VndErrors(vndErrorList);

        return new ResponseEntity<>(errors, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
