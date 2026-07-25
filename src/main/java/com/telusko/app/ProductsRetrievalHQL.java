package com.telusko.app;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.telusko.model.Products;

import jakarta.persistence.Query;

public class ProductsRetrievalHQL {

	public static void main(String[] args) {
		
		
Configuration configuration = null;
		
		SessionFactory sessionFactory = null;
		
		Session session = null;
		
		Transaction transaction = null;
		
		boolean flag = false;
		
		configuration = new Configuration();
		configuration.addAnnotatedClass(Products.class);
		sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
		
		try {
			
			transaction = session.beginTransaction();
			 List<Products> resultList = session
										.createQuery("from Products",Products.class)
			 						    .getResultList();
			resultList.forEach((p)->System.out.println(p));
			flag = true;
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
