package com.micro2.Cuenta.Exceptions;

import lombok.Data;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@ToString
public class Response {

    private int code;
    private String message;
    private Object data;
    private String timestamp;

    public Response(int code400, String successfulProcess, Object[] objects, HttpStatus ok) {
        super();
        initTimestamp();
    }

    public Response(int code, String message, Object data) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
        initTimestamp();
    }

    public Response(int code, String message) {
        super();
        this.code = code;
        this.message = message;
        initTimestamp();
    }

    private void initTimestamp() {
        this.timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
}
