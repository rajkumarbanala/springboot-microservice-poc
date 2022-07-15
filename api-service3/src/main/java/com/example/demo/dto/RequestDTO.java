package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Rajkumar Banala 14-Jul-2022
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestDTO {

	private String Name;

	private String Surname;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSurname() {
		return Surname;
	}

	public void setSurname(String surname) {
		Surname = surname;
	}
	
	

}
