package com.example.demo.handler;

import java.time.LocalDateTime;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Rajkumar Banala 14-Jul-2022
 *
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
	
	private int errorCode;
	
	private String errorMessage;
	
	private LocalDateTime timeStamp;
	
	private Map<String, String> errors;
}
