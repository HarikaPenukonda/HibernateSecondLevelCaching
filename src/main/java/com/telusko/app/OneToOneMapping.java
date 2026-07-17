package com.telusko.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneMapping {

	public static void main(String[] args) {
		
		Configuration configuration = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		
		
		configuration = new Configuration();
		//configuration.addAnnotatedClass(Student.class);
		sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();

	}

}
