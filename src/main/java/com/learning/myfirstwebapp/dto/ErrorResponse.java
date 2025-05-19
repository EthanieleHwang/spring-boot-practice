package com.learning.myfirstwebapp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;
@Data
@Getter
public class ErrorResponse {
    private int status;
    private String message;
    private String details;

    public ErrorResponse(HttpStatus status,String message,String details) {
        this.status = status.value();
        this.message = message;
        this.details = details;
    }
}
