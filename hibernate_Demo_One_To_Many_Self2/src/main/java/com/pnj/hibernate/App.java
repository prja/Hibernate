package com.pnj.hibernate;

import org.hibernate.Session;

import com.pnj.hibernate.model.Employee;
import com.pnj.hibernate.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

	
		
	
		
		

		long id=0;
		// save 
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Employee supermanager = new Employee();
		supermanager.setFirstname("Super Boss");
		supermanager.setLastname("Jai");
		
		Employee manager = new Employee();
		manager.setFirstname("Prabhu");
		manager.setLastname("Jai");
		manager.setManager(supermanager);
        
        Employee employee1 = new Employee();
        employee1.setFirstname("Raj");
        employee1.setLastname("Kumar");
        Employee employee2 = new Employee();
        employee2.setFirstname("Rahul");
        employee2.setLastname("Barma");

        employee1.setManager(manager);
        employee2.setManager(manager);
        
        session.save(supermanager);
        session.save(employee1);
        session.save(employee2);	
        

		id=(long) session.save(manager);
       

        session.getTransaction().commit();
        session.close();
		
		// select
         session = HibernateUtil.getSessionFactory().openSession();
         Employee p = session.load(Employee.class, id);
		System.out.println("Person=== "+p.toString());
		System.out.println("**************************************************************");
		System.out.println("My Team === "+p.getTeamMember());
		
         session.close();
		// System.out.println(p.getIdProofList());
		// System.out.println(idp);

		System.out.println("GoodBye World!");
		HibernateUtil.getSessionFactory().close();
	}
}
