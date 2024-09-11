package org.jsp.app.exceptionhandler;

import org.jsp.app.exception.InvalidCredentials;
import org.jsp.app.exception.InvalidEmail;
import org.jsp.app.exception.InvalidPassword;
import org.jsp.app.exception.InvalidPhoneNumber;
import org.jsp.app.exception.NoDealFoundException;
import org.jsp.app.responsestructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@RestControllerAdvice
public class ExceptionHandlerClass {
	
	@ExceptionHandler(InvalidCredentials.class)
	public ResponseEntity<?> emailOrPasswordExceptionHandler(InvalidCredentials e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().httpcode(HttpStatus.NOT_FOUND.value())
				.message(e.getMessage()).body("Wrong Email or Wrong password").build());
	}
	@ExceptionHandler(InvalidEmail.class)
	public ResponseEntity<?> emailExceptionHandler(InvalidEmail e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().httpcode(HttpStatus.NOT_FOUND.value())
				.message(e.getMessage()).body("Wrong Email").build());
	}
	@ExceptionHandler(InvalidPassword.class)
	public ResponseEntity<?> passwordExceptionHandler(InvalidPassword e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().httpcode(HttpStatus.NOT_FOUND.value())
				.message(e.getMessage()).body("Wrong Password").build());
				
	}
	@ExceptionHandler(InvalidPhoneNumber.class)
	public ResponseEntity<?> phoneNumberExceptionHandler(InvalidPhoneNumber e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().httpcode(HttpStatus.NOT_FOUND.value())
				.message(e.getMessage()).body("Wrong Phone Number").build());
				
	}
	@ExceptionHandler(NoDealFoundException.class)
	public ResponseEntity<?> noDealFoundExceptionMethod(NoDealFoundException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().httpcode(HttpStatus.NOT_FOUND.value())
				.message("No Foud Based on the data").body(e.getMessage()).build());
	}
}
