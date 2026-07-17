package com.telusko.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.telusko.model.Student;

public class FirstLaunchAppJavaConfig {

	public static void main(String[] args) {
		
		Configuration configuration = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		
		
		configuration = new Configuration();
		configuration.addAnnotatedClass(Student.class);
		sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
		Student student = new Student("Micheal Scott",44, "scottm@gmail.com");
		
		try {	
			transaction = session.beginTransaction();
			session.persist(student);
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
