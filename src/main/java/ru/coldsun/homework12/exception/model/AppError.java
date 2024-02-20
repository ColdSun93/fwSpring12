package ru.coldsun.homework12.exception.model;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class AppError {
    private int statusCode;
    private String message;

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AppError() {
    }

    public AppError(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
