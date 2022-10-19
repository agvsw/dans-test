package com.dansmultipro.dansmultiprotest.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PositionNotFoundException extends Exception {
    private int code;
    private String message;

    public PositionNotFoundException(int code, String message){
        super();
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }
}
