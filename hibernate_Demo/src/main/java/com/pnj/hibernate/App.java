package com.pnj.hibernate;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pnj.hibernate.model.Person;
import com.pnj.hibernate.util.HibernateUtil;

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

		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		Long id = (Long) session.save(p);

		session.getTransaction().commit();
		session.close();

		System.out.println(p);

		System.out.println("GoodBye World!");
		HibernateUtil.getSessionFactory().close();
	}
}
