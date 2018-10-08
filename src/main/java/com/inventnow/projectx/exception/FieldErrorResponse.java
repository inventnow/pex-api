package com.inventnow.projectx.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@Getter
@AllArgsConstructor
@Value
public class FieldErrorResponse {

    private String field;

    private String code;

    private String message;
}
