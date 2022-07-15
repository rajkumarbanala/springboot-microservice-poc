package com.example.demo.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

	private static final Logger LOG = LoggerFactory.getLogger(Controller.class);

	@Autowired
	private AppService appService;

	@PostMapping
	public String processData(@RequestBody Map<String, Object> payload) {
		LOG.debug("processData()");

		LOG.debug("processData().payload:" + payload);

		return appService.processData(payload);
	}
}
