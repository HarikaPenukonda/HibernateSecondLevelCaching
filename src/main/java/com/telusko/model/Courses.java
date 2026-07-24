package com.telusko.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Courses {
	
	@Id
	//@GeneratedValue(generator = "c_seq",strategy = GenerationType.AUTO)
	//@SequenceGenerator(name="c_seq", sequenceName = "course_OwnSequence", initialValue = 101, allocationSize = 1)
	@Column(name="course_id")
	private int courseid;
	
	@Column(name="course_name")
	private String courseName;
	
	@Column(name="course_price")
	private double price;
	
	@ManyToMany(mappedBy="courses")
	private List<Students> students;

	public Courses() {
		//System.out.println("zero parameter constructor - courses");
	}

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Students> getStudents() {
		return students;
	}

	public void setStudents(List<Students> students) {
		this.students = students;
	}

//	@Override
//	public String toString() {
//		return "Courses [courseid=" + courseid + ", courseName=" + courseName + ", price=" + price + ", students="
//				+ students + "]";
//	}

	
	
	
	
	
	
	

}
