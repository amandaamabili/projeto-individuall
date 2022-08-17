package com.desafiofinal.praticafinal.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ElementeAlreadyExistsException extends RuntimeException{
    public ElementeAlreadyExistsException(String message){
        super(message);
    }
}
