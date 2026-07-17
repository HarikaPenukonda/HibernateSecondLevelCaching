package com.telusko.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Department {
	
	@Id
	@Column(name="department_id")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int departmentId;
	
	@Column(name = "department_name")
	private String departmentName;
	
	@OneToMany(cascade = CascadeType.ALL)
	//@JoinColumn(name = "department_id")
	private List<Employee> employees;

	public Department() {
		System.out.println("zero parameterized constructor - department");
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", employees="
				+ employees + "]";
	}
	
	
	
	

   
}