package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.dto.EmployeeRequestCreate;
import com.example.demo.dto.EmployeeResponse;
import com.example.demo.dto.EmployeeResponseCreate;
import com.example.demo.entity.Employee;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rajkumar Banala 14-Jul-2022
 *
 */

@Slf4j
@Service
@Transactional(readOnly = true)
public class AppServiceImpl implements AppService {

	@Autowired
	private EmployeeDAO employeeDAO;

	public List<Map<String, Object>> fetch() {
		log.debug("fetch()");

		List<Employee> list = employeeDAO.findAll();
		log.debug("fetch().list:" + list);

		Map<String, Map<String, Object>> map = new HashMap<>();

		for (Employee e : list) {
			Map<String, Object> tmp = new HashMap<>();
			tmp.put("name", e.getName());
			tmp.put("id", e.getId().toString());
			tmp.put("parentId", e.getParentId().toString());
			map.put(e.getId().toString(), tmp);
		}
		log.debug("fetch().map:" + map);

		Map<String, Map<String, Object>> finalMap = new HashMap<>();

		for (Entry<String, Map<String, Object>> entry : map.entrySet()) {

			Map<String, Object> data = entry.getValue();

			String id = entry.getKey();
			String parentId = (String) data.get("parentId");
			String name = (String) data.get("name");
			boolean isParentFound = map.containsKey(parentId);

			if (isParentFound) {

				// link to parent
				Map<String, Object> parent = map.get(parentId);

				// fetch childs
				List<Map<String, Object>> subClasses = (List<Map<String, Object>>) parent.get("subClasses");
				if (subClasses == null) {
					subClasses = new ArrayList<>();
				}

				// add to childs
				subClasses.add(data);

				parent.put("subClasses", subClasses);

				continue;

			} else {

				finalMap.put(id, data);
				continue;

			}
		}
		log.debug("fetch().finalMap:" + finalMap);

		List<Map<String, Object>> response = new ArrayList<>();

		for (Entry<String, Map<String, Object>> entry : finalMap.entrySet()) {

			response.add(prepareData(entry.getValue()));
		}
		log.debug("fetch().response:" + response);

		return response;
	}

	private Map<String, Object> prepareData(Map<String, Object> data) {

		Map<String, Object> mapNew = new HashMap<>();

		List<Map<String, Object>> subClasses = (List<Map<String, Object>>) data.get("subClasses");
		List<Map<String, Object>> subClassesNew = new ArrayList<>();

		if (subClasses != null) {

			for (Map<String, Object> child : subClasses) {
				Map<String, Object> finalChild = prepareData(child);
				subClassesNew.add(finalChild);
			}
			mapNew.put("subClasses", subClassesNew);
		}

		mapNew.put("name", data.get("name"));

		return mapNew;

	}
	
	public EmployeeResponse get(Integer id) {
		log.debug("get()");
		
		Optional<Employee> employeeOptional = employeeDAO.findById(id);
		
		EmployeeResponse employeeResponse = null;
				
		if(employeeOptional.isPresent()) {
			Employee employee = employeeOptional.get();
			employeeResponse = new EmployeeResponse();
			employeeResponse.setId(employee.getId());
			employeeResponse.setParentId(employee.getParentId());
			employeeResponse.setName(employee.getName());
			employeeResponse.setColor(employee.getColor());
		}
		
		return employeeResponse;
	}

	@Transactional(readOnly = false)
	public EmployeeResponseCreate create(EmployeeRequestCreate employeeRequestCreate) {
		log.debug("create()");
		
		log.debug("create().employeeRequestCreate:"+employeeRequestCreate);

		Employee employee = new Employee(employeeRequestCreate.getId(), employeeRequestCreate.getParentId(), employeeRequestCreate.getName(), employeeRequestCreate.getColor());
		log.debug("create().employee:"+employee);

		employee = employeeDAO.save(employee);

		EmployeeResponseCreate employeeResponseCreate = new EmployeeResponseCreate();
		employeeResponseCreate.setId(employee.getId());
		employeeResponseCreate.setParentId(employee.getParentId());
		employeeResponseCreate.setName(employee.getName());
		employeeResponseCreate.setColor(employee.getColor());

		return employeeResponseCreate;
		
	}
}
