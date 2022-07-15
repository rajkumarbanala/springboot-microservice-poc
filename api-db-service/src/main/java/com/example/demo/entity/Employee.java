package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Rajkumar Banala 14-Jul-2022
 *
 */


@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@Column(name = "id", unique = true, nullable = false, length = 50)
	private Integer id;

	@Column(name = "parent_id", nullable = false, length = 50)
	private Integer parentId;

	// Hyderabad, Bengulore
	@Column(name = "name", length = 30)
	private String name;

	// HYD, BNG
	@Column(name = "color", nullable = false, length = 20)
	private String color;
}
