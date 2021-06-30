package com.tgestiona.apiProductoTgestiona.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SucursalNotFoundException extends  RuntimeException {
    public SucursalNotFoundException(String message) {
        super(message);
    }
}

