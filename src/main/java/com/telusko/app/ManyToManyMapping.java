package com.telusko.app;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.telusko.model.Courses;
import com.telusko.model.Students;

public class ManyToManyMapping {

	public static void main(String[] args) {
		
		Configuration configuration = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		
		
		configuration = new Configuration();
		configuration.addAnnotatedClasses(Students.class,Courses.class);
		sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
		
		transaction = session.beginTransaction();
		
//		Courses c1 = new Courses();
//		c1.setCourseid(107);
//		c1.setCourseName("Intro to React Library");
//		c1.setPrice(199.99);
//
//		Set<Courses> set1 = new HashSet<Courses>();
//		set1.add(c1);
//
//		Students s1 = new Students();
//		s1.setStudent_id(7);
//		s1.setStudent_name("Rueben");
//		s1.setCourses(set1);
		
		try {	
			transaction = session.beginTransaction();
			//session.persist(s1);
			
			// get a student and their coursework information
			Students student = session.find(Students.class, 1);
			System.out.println((student.getStudent_name()));
			
			for(Courses c : student.getCourses()) {
				System.out.println(c.getCourseName());
			}
			
			// get course info and students who took that course
//			Courses course = session.find(Courses.class, 101);
//			System.out.println(course);
			
			flag = true;
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println(e);
		}finally {
			if(flag == true) {
				transaction.commit();
			}else {
				transaction.rollback();
			}
			session.close();
			sessionFactory.close();
		}
	}

}
