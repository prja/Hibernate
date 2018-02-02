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

		Person p = new Person();
		p.setAge(33);
		p.setFirstName("XYZ");
		p.setLastName("abc");
		p.setBithDate("12-12-2012");
		
		
		
		IDProof idp= new IDProof();
		idp.setIdProofType(IDType.AADHAR.name());
		idp.setIdProofValue("493643244489");
		idp.setIssueDate("12-12-2012");
		idp.setExpiryDate("01-01-2018");
		
		
		p.setIdProof(idp);
		idp.setPerson(p);

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		 session.save(p);

		 session.save(idp);
		 
		session.getTransaction().commit();
		session.close();

		System.out.println(p);
		System.out.println(idp);

		System.out.println("GoodBye World!");
		HibernateUtil.getSessionFactory().close();
	}
}
