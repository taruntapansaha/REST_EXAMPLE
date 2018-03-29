package com.tarun.rest.webservices.restfulwebservice.exception;

import java.util.Date;

public class ExceptionResponse {
	
	private Date creationTime;
	private String messsage;
	private String description;
		
	public ExceptionResponse(Date creationTime, String messsage, String description) {
		super();
		this.creationTime = creationTime;
		this.messsage = messsage;
		this.description = description;
	}
	
	public Date getCreationTime() {
		return creationTime;
	}
	public String getMesssage() {
		return messsage;
	}
	public String getDescription() {
		return description;
	}

}
