package com.telusko.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Students {
	
	@Id
	//@GeneratedValue(generator = "my_seq",strategy = GenerationType.AUTO)
	//@SequenceGenerator(name="my_seq", sequenceName = "My_OwnSequence", initialValue = 1, allocationSize = 1)
	@Column(name="student_id")
	private int student_id;
	
	@Column(name="student_name")
	private String student_name;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
		name = "Students_Courses",
		joinColumns = @JoinColumn(name="student_id"),
		inverseJoinColumns = @JoinColumn(name="course_id"))
	private Set<Courses> courses;

	
	public Students() {
		//System.out.println("zero parameterised constructor - student");
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public Set<Courses> getCourses() {
		return courses;
	}

	public void setCourses(Set<Courses> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Students [student_id=" + student_id + ", student_name=" + student_name + ", courses=" + courses + "]";
	}
	
	
	
	
	
	
	
	
	

}
