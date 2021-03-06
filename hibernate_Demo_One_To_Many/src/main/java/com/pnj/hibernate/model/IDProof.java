package com.pnj.hibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class IDProof {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String idProofType;

	private String idProofValue;

	private String issueDate;

	private String expiryDate;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Person person;
	
	public String getIdProofType() {
		return idProofType;
	}

	public void setIdProofType(String idProofType) {
		this.idProofType = idProofType;
	}

	public String getIdProofValue() {
		return idProofValue;
	}

	public void setIdProofValue(String idProofValue) {
		this.idProofValue = idProofValue;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return "IDProofs [id=" + id + ", idProofType=" + idProofType + ", idProofValue=" + idProofValue + ", issueDate="
				+ issueDate + ", expiryDate=" + expiryDate + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expiryDate == null) ? 0 : expiryDate.hashCode());
		result = prime * result + ((idProofType == null) ? 0 : idProofType.hashCode());
		result = prime * result + ((idProofValue == null) ? 0 : idProofValue.hashCode());
		result = prime * result + ((issueDate == null) ? 0 : issueDate.hashCode());
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
		IDProof other = (IDProof) obj;
		if (expiryDate == null) {
			if (other.expiryDate != null)
				return false;
		} else if (!expiryDate.equals(other.expiryDate))
			return false;
		if (idProofType == null) {
			if (other.idProofType != null)
				return false;
		} else if (!idProofType.equals(other.idProofType))
			return false;
		if (idProofValue == null) {
			if (other.idProofValue != null)
				return false;
		} else if (!idProofValue.equals(other.idProofValue))
			return false;
		if (issueDate == null) {
			if (other.issueDate != null)
				return false;
		} else if (!issueDate.equals(other.issueDate))
			return false;
		return true;
	}

	
	public Person getPerson() {
		return person;
	}

	
	public void setPerson(Person person) {
		this.person = person;
	}

}
