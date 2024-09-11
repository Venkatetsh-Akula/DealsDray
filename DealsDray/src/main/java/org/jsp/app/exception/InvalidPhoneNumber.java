package org.jsp.app.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class InvalidPhoneNumber extends RuntimeException{
	private String message;
	public InvalidPhoneNumber() {
		super("Invalid phone number");
	}
	public InvalidPhoneNumber(String message) {
		this.message=message;
	}
	@Override
	public String toString() {
		return this.message;
	}
}
