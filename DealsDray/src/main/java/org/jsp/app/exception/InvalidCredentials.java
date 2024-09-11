package org.jsp.app.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class InvalidCredentials extends RuntimeException {
	private String message;
	public InvalidCredentials() {
		super("Invalid email or password");
	}
	public InvalidCredentials(String message) {
		this.message=message;
	}
	@Override
	public String toString() {
		return this.message;
	}
}
