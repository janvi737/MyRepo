package com.cg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFountException extends Exception {

	public ResourceNotFountException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResourceNotFountException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}   
}
