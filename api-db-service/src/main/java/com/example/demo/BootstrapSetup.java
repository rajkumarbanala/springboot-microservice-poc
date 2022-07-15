package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.entity.Employee;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rajkumar Banala 14-Jul-2022
 *
 */

@Slf4j
@Service
public class BootstrapSetup {

	@Autowired
	EmployeeDAO stationDAO;

	@Value("${com.example.demo.db.data-setup}")
	private boolean dbDataSetup;

	public void setup() {
		log.debug("setup()");

		if (!dbDataSetup)
			return;

		// stations
		stationDAO.save(new Employee(1, 0, "Warrior", "red"));
		stationDAO.save(new Employee(2, 0, "Wizard", "red"));
		stationDAO.save(new Employee(3, 0, "Priest", "white"));
		stationDAO.save(new Employee(4, 0, "Rogue", "yellow"));
		
		stationDAO.save(new Employee(5, 1, "Fighter", "blue"));
		stationDAO.save(new Employee(6, 1, "Paladin", "lighblue"));
		stationDAO.save(new Employee(7, 1, "Ranger", "lighgreen"));
		
		stationDAO.save(new Employee(8, 2, "Mage", "grey"));
		stationDAO.save(new Employee(9, 2, "Specialist wizard", "lightgrey"));
		
		stationDAO.save(new Employee(10, 3, "Cleric", "red"));
		stationDAO.save(new Employee(11, 3, "Druid", "green"));
		stationDAO.save(new Employee(12, 3, "Priest of specific mythos", "white"));
		
		stationDAO.save(new Employee(13, 4, "Thief", "yellow"));
		stationDAO.save(new Employee(14, 4, "Bard", "blue"));
		
		stationDAO.save(new Employee(15, 13, "Assassin", "lighblue"));

	}

}
