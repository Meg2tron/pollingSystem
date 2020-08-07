package com.example.exception;

public class NotAuthorized extends Exception {
	private static final long serialVersionUID = 1L;

	public NotAuthorized(String msg) {
		super(msg);
	}

}
