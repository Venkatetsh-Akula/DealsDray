package org.jsp.app.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class NoDealFoundException extends RuntimeException{
	private String message;
	public NoDealFoundException() {
		super("No such deal found");
	}
	public NoDealFoundException(String message) {
		this.message=message;
	}
	@Override
	public String toString() {
		return this.message;
	}
}
