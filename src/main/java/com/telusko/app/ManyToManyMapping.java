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
//		c1.setCourseName("Introduction to computer programming");
//		c1.setPrice(99.99);
//		
//		Courses c2 = new Courses();
//		c2.setCourseName("Algorithm Design");
//		c2.setPrice(199.99);
//		
//		Courses c3 = new Courses();
//		c3.setCourseName("Language Based systems");
//		c3.setPrice(299.99);
//		
//		Set<Courses> set1 = new HashSet<Courses>();
//		set1.add(c1);
//		set1.add(c2);
//		set1.add(c3);
//		
//		
//		Set<Courses> set2 = new HashSet<Courses>();
//		set2.add(c1);
//		set2.add(c3);
//		
//		
//		Students s1 = new Students();
//		s1.setStudent_name("Hayley");
//		s1.setCourses(set2);
//		
//		Students s2 = new Students();
//		s2.setStudent_name("Alex");
//		s2.setCourses(set1);
//		
//		Students s3 = new Students();
//		s3.setStudent_name("Luke");
//		s3.setCourses(set2);
		
		try {	
			transaction = session.beginTransaction();
//			session.persist(s1);
//			session.persist(s2);
//			session.persist(s3);
			
			// get a student and their coursework information
//			Students student = session.find(Students.class, 1);
//			System.out.println((student));
			
//			for(Courses c : student.getCourses()) {
//				System.out.println(c.getCourseName());
//			}
			
			// get course info and students who took that course
			Courses course = session.find(Courses.class, 101);
			System.out.println(course);
			
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
