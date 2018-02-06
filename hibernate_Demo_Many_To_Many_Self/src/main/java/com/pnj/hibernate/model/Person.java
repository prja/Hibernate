package com.pnj.hibernate.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity

public class Person {
	
	@Id
	@Column(name="PERSON_ID")
	@GeneratedValue
	private Long PERSONId;
	
	@Column(name="FIRSTNAME")
	private String firstname;
	
	@Column(name="LASTNAME")
	private String lastname;
	

	@ManyToMany(cascade={CascadeType.ALL})
	@JoinTable(name="PERSON_FREIND",
		joinColumns={@JoinColumn(name="PERSON_ID")},
		inverseJoinColumns={@JoinColumn(name="FREIND_ID")})
	private Set<Person> freinds = new HashSet<Person>();

	@ManyToMany(mappedBy="freinds")
	private Set<Person> freindsOf = new HashSet<Person>();

	public Person() {
	}

	public Person(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Set<Person> getFreinds() {
		return freinds;
	}

	public void setFreinds(Set<Person> freinds) {
		this.freinds = freinds;
	}

	public Set<Person> getFreindsOf() {
		return freindsOf;
	}

	public void setFreindsOf(Set<Person> freindsOf) {
		this.freindsOf = freindsOf;
	}

	@Override
	public String toString() {
		return "Person [PERSONId=" + PERSONId + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
		
}