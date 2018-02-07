package com.pnj.hibernate;

import org.hibernate.Session;

import com.pnj.hibernate.model.Apple;
import com.pnj.hibernate.model.Fruit;
import com.pnj.hibernate.model.Orange;
import com.pnj.hibernate.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		
	

		System.out.println("Hello World!");

		Fruit fruit = new Apple();
		fruit.setName("Apple_Fruit");

		Apple aple2 = new Apple();
		aple2.setName("Apple");
		aple2.setColor("Green");
		aple2.setTaste("Khatta");

		Orange orange = new Orange();
		orange.setColor("Yellow");
		orange.setName("Nagpurui Santara");
		orange.setTaste("Khatta Meetha");

		//save
		long id = 0;
		Session session2 = HibernateUtil.getSessionFactory().openSession();
		session2.beginTransaction();

		session2.save(fruit);
		id = (Long)session2.save(aple2);
		 session2.save(orange);

		session2.getTransaction().commit();
		session2.close();

		//select
		session2 = HibernateUtil.getSessionFactory().openSession();
		Apple ap = session2.load(Apple.class, id);

		System.out.println(ap);
		session2.close();

		System.out.println("GoodBye World!");
		HibernateUtil.getSessionFactory().close();
	
	
	}
}
