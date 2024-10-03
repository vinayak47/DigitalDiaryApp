package com.digitaldiary.exception;

import org.springframework.http.HttpStatus;

public class ExceptionMessage {

	@Override
	public String toString() {
		return "ExceptionMessage [message=" + message + ", httpStatus=" + httpStatus + "]";
	}

	private String message;
	private String httpStatus;

	public ExceptionMessage() {

	}

	public ExceptionMessage(String message, String httpStatus) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}

}
