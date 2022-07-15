package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rajkumar Banala 14-Jul-2022
 *
 */

@RestController
@RequestMapping("/api")
public class Controller {

	@GetMapping
	public String get() {
		return "Hello";
	}


}
