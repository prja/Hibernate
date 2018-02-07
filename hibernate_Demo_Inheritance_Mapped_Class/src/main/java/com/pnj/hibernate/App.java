package com.pnj.hibernate;

import org.hibernate.Session;

import com.pnj.hibernate.model.Apple;
import com.pnj.hibernate.model.Orange;
import com.pnj.hibernate.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		Apple aple= new Apple();
		aple.setName("Apple Shimla");
		aple.setColor("RED");
		aple.setTaste("Sweet");
		aple.setLocalName("seb");
		
		Apple aple2= new Apple();
		aple2.setName("Apple royal Gala");
		aple2.setColor("Green");
		aple2.setTaste("Khatta");
		
		
		Orange orange= new Orange();
		orange.setColor("Yellow");
		orange.setName("Nagpurui Santara");
		orange.setTaste("Khatta Meetha");
		
		long id=0;
		Session session2 = HibernateUtil.getSessionFactory().openSession();
		session2.beginTransaction();

		id=(Long) session2.save(aple);
		session2.save(aple2);
		session2.save(orange);

		session2.getTransaction().commit();
		session2.close();
		
		
		session2 = HibernateUtil.getSessionFactory().openSession();
		Apple ap = session2.load(Apple.class, id);
		
		System.out.println(ap.toString());
		session2.close();
		

		System.out.println("GoodBye World!");
		HibernateUtil.getSessionFactory().close();
	}
}
