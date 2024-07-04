package com.scaler.productservice.controlleradvice;

import com.scaler.productservice.dtos.ExceptionDto;
import com.scaler.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> handleArithmeticException(){
        ExceptionDto exceptiondto = new ExceptionDto();
        exceptiondto.setMessage("Something went wrong");
        exceptiondto.setSolution("I dont know why");
        ResponseEntity<ExceptionDto> response=new ResponseEntity<>(
                exceptiondto,
                HttpStatus.NOT_FOUND
        );
        return response;
    }
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(){
        ResponseEntity<String> response=new ResponseEntity<>(
                "something went wrong coming from controller advice",
                HttpStatus.NOT_FOUND
        );
        return response;
    }
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<String> handleArrayIndexOutOfBoundException(){
        ResponseEntity<String> response=new ResponseEntity<>(
                "something went wrong coming from controller advice",
                HttpStatus.NOT_FOUND
        );
        return response;
    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleProductNotFoundException(){
        ExceptionDto exceptiondto = new ExceptionDto();
        exceptiondto.setMessage("Product not found");
        exceptiondto.setSolution("Try with valid Product id");
        ResponseEntity<ExceptionDto> response=new ResponseEntity<>(
                exceptiondto,
                HttpStatus.NOT_FOUND
        );
        return response;
    }

}
