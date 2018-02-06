package com.pnj.hibernate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pnj.hibernate.model.Skill;
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
		p.setFirstName("Prabhu");
		p.setLastName("abc");
		p.setBithDate("12-12-2012");
		
		
		
		Person p2 = new Person();
		p2.setAge(33);
		p2.setFirstName("Narayan");
		p2.setLastName("abc");
		p2.setBithDate("12-12-2012");
		
		

		Skill skill = new Skill();
		skill.setName("Java");
		skill.setExpertiseLevel("Beginer");

		Skill skill2 = new Skill();
		skill2.setName("hibernate");
		skill2.setExpertiseLevel("Medium");

		List<Person> personlist = new ArrayList<Person>();
		personlist.add(p);
		personlist.add(p2);

		List<Skill> skilllist = new ArrayList<Skill>();
		skilllist.add(skill);
		skilllist.add(skill2);
		
		p.setSkillList(skilllist);
		p2.setSkillList(skilllist);
		
		skill.setPersonList(personlist);
		skill2.setPersonList(personlist);
		
		

		long id=0;
		// save 
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		id=(Long) session.save(p);
		 session.save(p2);

		session.getTransaction().commit();
		session.close();

		
		
		// select
		
		session = HibernateUtil.getSessionFactory().openSession();
		Person p1 = session.load(Person.class, id);
		System.out.println("skill type= " + p1.getSkillList().get(0).getName());
		session.close();

		// System.out.println(p.getIdProofList());
		// System.out.println(idp);

		System.out.println("GoodBye World!");
		HibernateUtil.getSessionFactory().close();
	}
}
