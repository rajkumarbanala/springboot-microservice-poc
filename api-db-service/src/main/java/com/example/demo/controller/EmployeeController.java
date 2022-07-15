package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeRequestCreate;
import com.example.demo.dto.EmployeeResponse;
import com.example.demo.dto.EmployeeResponseCreate;
import com.example.demo.mapping.EmployeeControllerMapping;
import com.example.demo.service.AppService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rajkumar Banala 14-Jul-2022
 *
 */

@Slf4j
@RestController
@RequestMapping(EmployeeControllerMapping.API)
public class EmployeeController {

	@Autowired
	private AppService appService;

	@GetMapping
	public List<Map<String, Object>> fetch() {
		log.debug("fetch()");

		return appService.fetch();
	}
	
	@GetMapping("/{id}")
	public EmployeeResponse get(@PathVariable Integer id) {
		log.debug("get()");

		return appService.get(id);
	}

	@PostMapping
	public EmployeeResponseCreate create(@RequestBody EmployeeRequestCreate employeeRequestCreate) {
		log.debug("create()");

		return appService.create(employeeRequestCreate);
	}
}
