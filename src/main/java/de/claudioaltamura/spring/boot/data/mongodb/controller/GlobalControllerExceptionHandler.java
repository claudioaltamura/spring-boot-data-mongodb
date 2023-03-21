package de.claudioaltamura.spring.boot.data.mongodb.controller;

import de.claudioaltamura.spring.boot.data.mongodb.ProductMaterialNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;


@RestControllerAdvice
public class GlobalControllerExceptionHandler {

	@ExceptionHandler(ProductMaterialNotFoundException.class)
	public ResponseEntity<Error> handleNotFound(RuntimeException ex) {
		Error error = new Error(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Error> handleThrowable(RuntimeException ex) {
		Error error = new Error(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}