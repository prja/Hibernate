package com.pnj.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.pnj.hibernate.model.Person;
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

		Person Person1 = new Person("Prabhu", "Jai");
        Person Person2 = new Person("Raj", "Verma");
        Person Person3 = new Person("Guru", "Dev");
        Person Person4 = new Person("Harry", "Pal");

        Person1.getFreinds().add(Person2);
        
        
        Person2.getFreinds().add(Person1);
        Person2.getFreinds().add(Person4);
        
        Person3.getFreinds().add(Person4);
        Person3.getFreinds().add(Person1);
        
        Person4.getFreinds().add(Person1);
        Person4.getFreinds().add(Person3);
        

		id=(long) session.save(Person1);
        session.save(Person2);
        session.save(Person3);
        session.save(Person4);

        session.getTransaction().commit();
        session.close();
		
		// select
         session = HibernateUtil.getSessionFactory().openSession();
		Person p = session.load(Person.class, id);
		System.out.println("**************************************************************");
		System.out.println("Person=== "+p.toString());
		System.out.println("**************************************************************");
		System.out.println("My Friends === "+p.getFreinds());
		System.out.println("**************************************************************");
		System.out.println("I am  Freind With=== "+p.getFreindsOf());
		System.out.println("**************************************************************");
         session.close();
		// System.out.println(p.getIdProofList());
		// System.out.println(idp);

		System.out.println("GoodBye World!");
		HibernateUtil.getSessionFactory().close();
	}
}
