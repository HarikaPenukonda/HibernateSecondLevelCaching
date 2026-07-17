package com.telusko.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.telusko.model.Answer;
import com.telusko.model.Question;

public class OneToOneMapping {

	public static void main(String[] args) {
		
		Configuration configuration = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		
		
		configuration = new Configuration();
		configuration.addAnnotatedClasses(Question.class,Answer.class);
		sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
		
		transaction = session.beginTransaction();
		
		Question q1 = new Question();
		q1.setId(102);
		q1.setQuestion("What is Java?");
		
		Answer a1 = new Answer();
		a1.setId(222);
		a1.setAnswer("Java is a pprogramming language");
		q1.setAnswer(a1);
		
		try {	
			transaction = session.beginTransaction();
			session.persist(q1);
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

