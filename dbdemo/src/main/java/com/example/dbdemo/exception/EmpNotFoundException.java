package com.example.dbdemo.exception;

public class EmpNotFoundException extends RuntimeException {
    public EmpNotFoundException(String message) {
        super(message);
    }
}
