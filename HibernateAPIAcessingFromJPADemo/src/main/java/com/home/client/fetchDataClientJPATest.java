package com.home.client;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionImplementor;
import com.home.entities.Employee;
import com.home.util.JpaUtil;

public class fetchDataClientJPATest {

	public static void main(String[] args) {
		EntityManager entityManager =null;
		SessionImplementor sessionImplementor=null;
	/*try{
		entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
		sessionImplementor = entityManager.unwrap(SessionImplementor.class);
		Employee employee = sessionImplementor.get(Employee.class, 1);
		if(employee !=null)
			System.out.println(employee);
		else
			System.out.println("Employee doesn't exist!!!");
	}
	catch(Exception e){
        e.printStackTrace();
	}
	finally {
		if(entityManager != null)
			entityManager.close();
	}*/
		
		//Using SessionFactory
		try{
			entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
			SessionFactory sessionFactory= entityManager.getEntityManagerFactory().unwrap(SessionFactory.class);
			Session session = sessionFactory.openSession();
			Employee employee = session.get(Employee.class, 1);
			if(employee !=null)
				System.out.println(employee);
			else
				System.out.println("Employee doesn't exist!!!");
		}
		catch(Exception e){
	        e.printStackTrace();
		}
		finally {
			if(entityManager != null)
				entityManager.close();
		}
}
}
