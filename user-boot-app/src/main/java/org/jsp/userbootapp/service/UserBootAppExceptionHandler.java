package org.jsp.userbootapp.service;

import org.jsp.userbootapp.dto.ResponseStructure;
import org.jsp.userbootapp.exception.IdNotFoundException;
import org.jsp.userbootapp.exception.InvalidCredentialException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class UserBootAppExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleIdNotFoundException(IdNotFoundException e)
	{
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setBody("User Not Found");
		structure.setMessage(e.getMessage());
		structure.setCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidCredentialException.class)
	public ResponseEntity<ResponseStructure<String>> handleInvalidCredentailsException(InvalidCredentialException e)
	{
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setBody("Invalid phone or email or password");
		structure.setMessage(e.getMessage());
		structure.setCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}

}
