package org.jsp.app.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class InvalidEmail extends RuntimeException{
	private String message;
	
	public InvalidEmail() {
		super("Wrong email");
	}
	
	public InvalidEmail(String message) {
		this.message=message;
	}
	
	@Override
	public String toString() {
		return this.message;
	}
}
