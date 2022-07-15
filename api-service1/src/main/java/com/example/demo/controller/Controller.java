package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AppService;

/**
 * @author Rajkumar Banala 14-Jul-2022
 *
 */

@RestController
@RequestMapping("/api")
public class Controller {

	@Autowired
	AppService appService;

	@GetMapping
	public String get() {
		return "UP";
	}

	@PostMapping
	public String post(@RequestBody Map<String, Object> payload) {
		return appService.getData(payload);
	}

}
