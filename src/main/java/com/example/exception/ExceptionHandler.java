package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.response.ErrorResponse;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler{
	
	
	@org.springframework.web.bind.annotation.ExceptionHandler(NoCandidateFound.class)
	public final ResponseEntity<ErrorResponse> handleNoCandidateFound(NoCandidateFound exception)
	{
		ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND, exception.getLocalizedMessage());
		
		return new ResponseEntity<ErrorResponse>(error,HttpStatus.NOT_FOUND);
	}

}
