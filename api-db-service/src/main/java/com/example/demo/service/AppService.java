package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.dto.EmployeeRequestCreate;
import com.example.demo.dto.EmployeeResponse;
import com.example.demo.dto.EmployeeResponseCreate;

/**
 * @author Rajkumar Banala 14-Jul-2022
 *
 */

public interface AppService {
	
	public List<Map<String, Object>> fetch();
	
	public EmployeeResponseCreate create(EmployeeRequestCreate employeeRequestCreate);
	
	public EmployeeResponse get(Integer id);

}
