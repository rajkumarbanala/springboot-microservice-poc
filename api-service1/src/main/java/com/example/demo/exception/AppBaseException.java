package com.example.demo.exception;

/**
 * @author Rajkumar Banala 14-Jul-2022
 *
 */

public class AppBaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AppBaseException() {
		super();
	}

	public AppBaseException(String message) {
		super(message);
	}
}
