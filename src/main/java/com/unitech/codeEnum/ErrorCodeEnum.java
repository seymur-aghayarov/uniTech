package com.unitech.codeEnum;

import org.springframework.boot.context.properties.bind.validation.ValidationErrors;

import javax.validation.Validation;

public enum ErrorCodeEnum {
   WHAT_WRONG("something went wrong"),
    VALIDATION_ERRORS("Validation error");


    private final String message;

    ErrorCodeEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
