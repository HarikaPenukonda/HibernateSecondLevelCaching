package com.telusko.app;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.telusko.model.Products;

public class ProductsRetrieval_NonSelect_HQL {

	public static void main(String[] args) {
		
		
Configuration configuration = null;
		
		SessionFactory sessionFactory = null;
		
		Session session = null;
		
		Transaction transaction = null;
		
		boolean flag = false;
		int count = 0;
		
		configuration = new Configuration();
		configuration.addAnnotatedClass(Products.class);
		sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
		
		try {
			
			transaction = session.beginTransaction();
			count = session.createMutationQuery("UPDATE Products set price =:price where productName =:productName")
					.setParameter("price", 699.99).setParameter("productName", "Xbox-console").executeUpdate();
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
				System.out.println("No of rows updated - " + count);
			}else {
				transaction.rollback();
				System.out.println("No of rows updated - " + count);
			}
			
			session.close();
			sessionFactory.close();
		}
	}

}
