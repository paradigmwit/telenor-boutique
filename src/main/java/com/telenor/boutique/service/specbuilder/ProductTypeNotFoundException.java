package com.telenor.boutique.service.specbuilder;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason = "The product type does not exist!")
public class ProductTypeNotFoundException extends RuntimeException  {

    public ProductTypeNotFoundException(String message) {
        super(message);
    }

    public ProductTypeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductTypeNotFoundException(Throwable cause) {
        super(cause);
    }
}
