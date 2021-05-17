package com.h2.api.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandle {
	
	@ExceptionHandler(value = {RequestException.class})
	public ResponseEntity<Object> handleRequestException(RequestException e) {
			
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		
		ApiException apiException = new ApiException(
				e.getMessage(),
				HttpStatus.BAD_REQUEST,
				LocalDateTime.now());
		
		return new ResponseEntity<>(apiException, badRequest);
	}

}
