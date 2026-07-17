package com.telusko.app;

import java.util.Arrays;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.telusko.model.Department;
import com.telusko.model.Employee;

public class OneToManyMapping {

	public static void main(String[] args) {
		
		Configuration configuration = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		
		
		configuration = new Configuration();
		configuration.addAnnotatedClasses(Department.class,Employee.class);
		sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
		
		transaction = session.beginTransaction();
		
		Department d1 = new Department();
		d1.setDepartmentId(103);
		d1.setDepartmentName("supplier relations");
		
		Employee e1 = new Employee();
		e1.setEmployeeId(5);
		e1.setEmployeeName("Meredith Palmer");
		e1.setSalary(50000);
		e1.setDepartment(d1);
		
//		Employee e2 = new Employee();
//		e2.setEmployeeId(4);
//		e2.setEmployeeName("Jim Halpert");
//		e2.setSalary(80000);
		//e2.setDepartment(d1);
		
//		List<Employee> emps = new ArrayList<Employee>();
//		emps.add(e1);
//		emps.add(e2);
		// adding emp objects to department
		d1.setEmployees(Arrays.asList(e1));
		
//		e1.setDepartment(d1);
//		e2.setDepartment(d1);
		
		
		try {	
			transaction = session.beginTransaction();
			session.persist(d1);
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

