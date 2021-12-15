package com.example.microserviceRegistration.advice;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.microserviceRegistration.exception.ExceptionResponse;
import com.example.microserviceRegistration.exception.InvalidUsernamePassword;
import com.example.microserviceRegistration.exception.NoUserFoundException;

@ControllerAdvice
@RestController
public class UserExceptions extends ResponseEntityExceptionHandler {

	@ExceptionHandler(SQLException.class)
	public String handleSQLException(SQLException sqlException) {
		System.out.print("db error");
		return "customError";
	}

	@ExceptionHandler(NoUserFoundException.class)
	public ResponseEntity<String> handleNoUserFoundException(NoUserFoundException noUserFoundException) {

		return new ResponseEntity<String>("User name is not  found", HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse errorDetails = new ExceptionResponse("Validation Failed",
				ex.getBindingResult().getFieldError().getDefaultMessage().toString());
		return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(InvalidUsernamePassword.class)
	public ResponseEntity<String> handleInvalidUsernamePassword(InvalidUsernamePassword invalidUsernamePassword) {

		return new ResponseEntity<String>("Invalid user name and password", HttpStatus.NOT_FOUND);
	}

}
