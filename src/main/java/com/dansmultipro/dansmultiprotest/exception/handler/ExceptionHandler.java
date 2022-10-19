package com.dansmultipro.dansmultiprotest.exception.handler;


import com.dansmultipro.dansmultiprotest.dto.CommonResponse;
import com.dansmultipro.dansmultiprotest.exception.PositionNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = PositionNotFoundException.class)
    public ResponseEntity<CommonResponse> resp(PositionNotFoundException e){
        return new ResponseEntity<>(new CommonResponse(e.getCode(), e.getMessage()), HttpStatus.OK);
    }
}
