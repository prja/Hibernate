package com.pnj.hibernate;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pnj.hibernate.model.IDProof;
import com.pnj.hibernate.model.Person;
import com.pnj.hibernate.util.HibernateUtil;
import com.pnj.hibernate.util.IDType;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		// save person
		Person p = new Person();
		p.setAge(33);
		p.setFirstName("Raj");
		p.setLastName("Kumar");
		p.setBithDate("12-12-2012");

		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		Long id = (Long) session.save(p);

		session.getTransaction().commit();
		session.close();
		
		
		// save id proof
		IDProof idp= new IDProof();
		idp.setIdProofType(IDType.AADHAR.name());
		idp.setIdProofValue("493643244489");
		idp.setIssueDate("12-12-2012");
		idp.setExpiryDate("01-01-2018");
		Session session2 = HibernateUtil.getSessionFactory().openSession();

		session2.beginTransaction();
		 session2.save(idp);

		session2.getTransaction().commit();
		session2.close();
		
		
		System.out.println(idp);
		System.out.println(p);

		System.out.println("GoodBye World!");
		HibernateUtil.getSessionFactory().close();
	}
}
