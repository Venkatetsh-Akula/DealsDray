package org.jsp.app.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class InvalidPassword extends RuntimeException {
	
	private String message;
	public InvalidPassword() {
		super("Wrong password");
	}
	public InvalidPassword(String message) {
		this.message=message;
	}
	@Override
	public String toString() {
		return this.message;
	}
}
