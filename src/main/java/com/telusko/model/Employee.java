package com.telusko.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
	
	 @Id
	 @Column(name = "employee_id")
	 //@GeneratedValue(strategy = GenerationType.AUTO)
	 private int employeeId;

	 @Column(name = "employee_name")
	 private String employeeName;

	 @Column(name = "salary")
	 private double salary;
	 
//	 @Column(name = "department_id")
//	 private Department department;

	public Employee() {
		System.out.println("zero parameterized constructor - employee");
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

//	public Department getDepartment() {
//		return department;
//	}
//
//	public void setDepartment(Department department) {
//		this.department = department;
//	}

	@Override
	public String toString() {
		return "Employee [employeeName=" + employeeName + ", salary=" + salary + "]";
	}
	
	
	 
	 


}
