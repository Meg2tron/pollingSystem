package com.example.response;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class ErrorResponse {
	
	
	public ErrorResponse(HttpStatus status, String errorMsg) {
		super();
		this.status = status;
		this.errorMsg = errorMsg;
	}

	private HttpStatus status;
	
	private String errorMsg;

}
