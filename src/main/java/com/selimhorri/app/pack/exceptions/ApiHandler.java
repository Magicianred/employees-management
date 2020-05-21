package com.selimhorri.app.pack.exceptions;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.selimhorri.app.pack.exceptions.payloads.ExceptionMsg;

@ControllerAdvice
public class ApiHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(
		value = {
			NoSuchElementException.class,
			// NoSuchElementApiException.class,
			NumberFormatException.class,
			// NumberFormatApiException.class,
			MethodArgumentTypeMismatchException.class,
			// NullPointerException.class
		}
	)
	public <T extends RuntimeException> ResponseEntity<ExceptionMsg> handleExceptionsMsg(final T exception, final WebRequest webRequest) {
		
		final HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		final ExceptionMsg exceptionMsg = new ExceptionMsg(exception.getMessage(), badRequest, exception, ZonedDateTime.now(ZoneId.systemDefault()));
		
		System.err.println(exceptionMsg);
		System.err.println(webRequest);
		
		return new ResponseEntity<>(exceptionMsg, badRequest);
	}
	
	
	
}









