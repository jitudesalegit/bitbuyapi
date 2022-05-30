package com.bitbuy.jwt.controller.globalexceptions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.persistence.RollbackException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import io.jsonwebtoken.MalformedJwtException;

@ControllerAdvice
public class GlobalExceptions  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<String> handleMessageNotRedableEx(HttpMessageNotReadableException messageNotRedable)
	{
		return new ResponseEntity<String>("Input message is not readable",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException recordNOtFound)
	{
		return new ResponseEntity<String>("No data found in the system",HttpStatus.NOT_FOUND);
	}
	

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<String> handleMethodNotSuppoportException(HttpRequestMethodNotSupportedException methodNotsupport)
	{
		return new ResponseEntity<String>("Request method not supported",HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	@ExceptionHandler(IOException.class)
	public ResponseEntity<String> handleIOException(IOException invalidToeken)
	{
		return new ResponseEntity<String>("Invalid input",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MalformedJwtException.class)
	public ResponseEntity<String> handleMethodNotSuppoportException(MalformedJwtException invalidToeken)
	{
		return new ResponseEntity<String>("Invalid Token Received",HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(RollbackException.class)
	public ResponseEntity<String> handleRollbackException(RollbackException rollback)
	 {
		return new ResponseEntity<String>(rollback.getMessage(),HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex
			) {
		//HttpHeaders headers, HttpStatus status, WebRequest request
		Map<String, String> errors = new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach((error) ->{
			
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put(fieldName, message);
		});
		
		return new ResponseEntity<Map<String, String>>(errors, HttpStatus.BAD_REQUEST);
	}

	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGeneralError(HttpServletRequest request,
	        HttpServletResponse response, Exception ex) {
	     
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
