package com.micro2.Cuenta.Exceptions;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class MovimientoException extends Exception  {
    private int httpCode = 500;


    public MovimientoException(String message) {
        super(message);
    }

    public MovimientoException(String message, Throwable cause) {
        super(message, cause);
    }

    public MovimientoException(String message, Throwable cause, int httpCode) {
        super(message, cause);
        this.httpCode = httpCode;
    }

    public MovimientoException(Throwable e) {
        super(e);
    }
}
