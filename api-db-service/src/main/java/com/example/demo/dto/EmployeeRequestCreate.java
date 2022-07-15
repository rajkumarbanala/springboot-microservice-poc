package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Rajkumar Banala 14-Jul-2022
 *
 */


@ToString
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeRequestCreate {
	
	private Integer id;

	private Integer parentId;

	private String name;

	private String color;

}
