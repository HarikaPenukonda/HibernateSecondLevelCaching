package com.telusko.app;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.telusko.model.Products;

public class PersistProductsDataApp {

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
		
		
		Products products1 = new Products();
		products1.setProductId(1001);
		products1.setProductName("Apple-Ipad");
		products1.setPrice(1099.99);
		products1.setCategory("Electronics");
		
		Products products2 = new Products();
		products2.setProductId(1002);
		products2.setProductName("Xbox-console");
		products2.setPrice(1099.99);
		products2.setCategory("Electronics");
		
		Products products3 = new Products();
		products3.setProductId(1003);
		products3.setProductName("Fire and Blood");
		products3.setPrice(1099.99);
		products3.setCategory("Book");
		
		Products products4 = new Products();
		products4.setProductId(1004);
		products4.setProductName("Iron-tumbler");
		products4.setPrice(1099.99);
		products4.setCategory("Water bottle");
		
		List<Products> products = List.of(products1,products2,products3,products4);
		
		List<Products> productsList = new ArrayList<>();
		for(Products p : products) {
			productsList.add(p);
		}
		
		try {
			
			transaction = session.beginTransaction();
			for(Products p : productsList) {
				session.persist(p);
			}
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
