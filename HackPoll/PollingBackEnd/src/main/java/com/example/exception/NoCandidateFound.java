package com.example.exception;

public class NoCandidateFound extends Exception {

	private static final long serialVersionUID = 1L;
	
	public NoCandidateFound(String msg) {
		super(msg);
	}

}
