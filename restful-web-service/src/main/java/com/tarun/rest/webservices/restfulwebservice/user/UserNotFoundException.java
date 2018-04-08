package com.tarun.rest.webservices.restfulwebservice.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 3507062725155732356L;

	public UserNotFoundException(String message) {
		super(message);
	}

}
