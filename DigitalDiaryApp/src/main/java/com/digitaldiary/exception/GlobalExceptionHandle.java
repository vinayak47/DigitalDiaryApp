package com.digitaldiary.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//global exception handling

@RestControllerAdvice
public class GlobalExceptionHandle{
	
	@ExceptionHandler(DataException.class)
	public ResponseEntity<ExceptionMessage>dataException(DataException exception){
		
		ExceptionMessage message=new ExceptionMessage(exception.getMessage(),"404");
		
		
		return new ResponseEntity<ExceptionMessage>(message, HttpStatus.NOT_FOUND);
         
	
	}
	

}
