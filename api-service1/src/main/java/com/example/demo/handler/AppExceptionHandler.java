package com.example.demo.handler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.AppBaseException;

/**
 * @author Rajkumar Banala 14-Jul-2022
 *
 */

@RestControllerAdvice
public class AppExceptionHandler {
	
	private static final Logger LOG = LoggerFactory.getLogger(AppExceptionHandler.class);
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorResponse handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
		LOG.debug("handleMethodArgumentNotValid()");
		
		LOG.error(e.getMessage(), e);
		
		ErrorResponse errorResponse = ErrorResponse.builder()
				.timeStamp(LocalDateTime.now())
				.errorMessage(HttpStatus.BAD_REQUEST.name())
				.errorCode(400)
				.build();

		Map<String, String> errors = new HashMap<>();
		e.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
		errorResponse.setErrors(errors);
		
		return errorResponse;
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(AppBaseException.class)
	protected final ErrorResponse appBaseException(AppBaseException e) {
		LOG.debug("appBaseException()");
		
		LOG.error(e.getMessage(), e);
		
		ErrorResponse errorResponse = ErrorResponse.builder()
				.timeStamp(LocalDateTime.now())
				.errorMessage(e.getMessage())
				.errorCode(400)
				.build();

		return errorResponse;
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	protected final ErrorResponse unhandledException(Exception e) {
		LOG.debug("unhandledException()");
		
		LOG.error(e.getMessage(), e);
		
		ErrorResponse errorResponse = ErrorResponse.builder()
				.timeStamp(LocalDateTime.now())
				.errorMessage(HttpStatus.INTERNAL_SERVER_ERROR.name())
				.errorCode(400)
				.build();

		return errorResponse;
	}
}
