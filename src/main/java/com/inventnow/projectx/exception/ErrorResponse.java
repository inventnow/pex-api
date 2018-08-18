package com.inventnow.projectx.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@Getter
@AllArgsConstructor
@Value
public class ErrorResponse {

    private String code;

    private String message;
}
