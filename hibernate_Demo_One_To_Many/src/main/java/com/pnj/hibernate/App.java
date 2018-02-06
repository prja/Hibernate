package com.pnj.hibernate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

		IDProof idp = new IDProof();
		idp.setIdProofType(IDType.AADHAR.name());
		idp.setIdProofValue("493643244489");
		idp.setIssueDate("12-12-2012");
		idp.setExpiryDate("01-01-2018");

		IDProof idp2 = new IDProof();
		idp2.setIdProofType(IDType.PASSPORT.name());
		idp2.setIdProofValue("493643244489");
		idp2.setIssueDate("12-12-2012");
		idp2.setExpiryDate("01-01-2018");

		idp.setPerson(p);
		idp2.setPerson(p);

		List<IDProof> list = new ArrayList<IDProof>();
		list.add(idp);
		list.add(idp2);
		p.setIdProofList(list);

		long id=0;
		// save 
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		id=(Long) session.save(p);

		session.getTransaction().commit();
		session.close();

		
		
		// select
		
		session = HibernateUtil.getSessionFactory().openSession();
		Person p1 = session.load(Person.class, id);
		System.out.println("ID type= " + p1.getIdProofList().get(0).getIdProofType());
		session.close();

		// System.out.println(p.getIdProofList());
		// System.out.println(idp);

		System.out.println("GoodBye World!");
		HibernateUtil.getSessionFactory().close();
	}
}
