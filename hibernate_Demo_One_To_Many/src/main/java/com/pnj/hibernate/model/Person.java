package com.pnj.hibernate.model;

import java.util.Collection;
import java.util.List;

import javax.annotation.Generated;
import javax.interceptor.AroundInvoke;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String firstName;
	
	private String lastName;
	
	private int age;
	
	private String bithDate;
	
	/**
	 * mappedBy="person",
	 * 
	 * if you don't specify  this attribute the a separate mapping table will be created. similar like @JoinTable with default names
	 * */
	@OneToMany(mappedBy="person", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	
	/** add if uni-direction*/
	//@JoinTable(name="Person_IDHolding", joinColumns= {@JoinColumn(name="PERSON_ID")},inverseJoinColumns= {@JoinColumn(name="LIST_OD_IDS")})
	private List<IDProof> idProofList;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBithDate() {
		return bithDate;
	}

	public void setBithDate(String bithDate) {
		this.bithDate = bithDate;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", bithDate=" + bithDate + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((bithDate == null) ? 0 : bithDate.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (bithDate == null) {
			if (other.bithDate != null)
				return false;
		} else if (!bithDate.equals(other.bithDate))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	/**
	

	/**
	 * @return the idProofList
	 */
	public List<IDProof> getIdProofList() {
		return idProofList;
	}

	/**
	 * @param idProofList the idProofList to set
	 */
	public void setIdProofList(List<IDProof> idProofList) {
		this.idProofList = idProofList;
	}

}
