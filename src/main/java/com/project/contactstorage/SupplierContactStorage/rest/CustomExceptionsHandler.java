package com.project.contactstorage.SupplierContactStorage.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionsHandler {

    //Обрабатываем исключение ошибки 400
    @ExceptionHandler
    public ResponseEntity<CustomErrorResponse> handleException(SupplierNotFoundException exc) {
        CustomErrorResponse error = new CustomErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exc.getMessage()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Обрабатываем исключение любой возможной ошибки
    @ExceptionHandler
    public ResponseEntity<CustomErrorResponse> handleException(Exception exc) {
        CustomErrorResponse error = new CustomErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("Ошибка, проверьте правильность ввода данных");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
