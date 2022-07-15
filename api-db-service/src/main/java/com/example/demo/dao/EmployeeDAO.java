package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;

/**
 * @author Rajkumar Banala 14-Jul-2022
 *
 */

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

}
