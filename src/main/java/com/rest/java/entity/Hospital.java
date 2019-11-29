package com.rest.java.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * 
 * The Hospital Object Contain details of about Hospital
 * 
 * Represents an Hospital
 * 
 * 
 * @author Shaik
 *
 */

@Entity
@Table(name="hospital")
public class Hospital implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Unique Identifier of the Hospital
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="hospId")
	private Integer hospId;

	/**
	 * Name of the Hospital
	 */

	@Column(length = 25, nullable = false, unique = true)
	private String name;

	/**
	 * email of the Hospital
	 */

	@Column(length = 50, nullable = false, unique = true)
	private String email;

	/**
	 * Phone number of the Hospital
	 */
	@Column(length = 12, unique = true , nullable = false)
	private String phone;

	/**
	 * fax number of the Hospital
	 */

	@Column(length = 12, nullable = false, unique = true)
	private String fax;
	

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "hospital", orphanRemoval = true)
	private List<Doctor> doctorsList;
	
	@Fetch(FetchMode.SELECT)
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "hospital", orphanRemoval = true)
	private List<Patient> patientsList;
	
	
	
	public List<Patient> getPatientsList() {
		return patientsList;
	}

	public void setPatientsList(List<Patient> patientsList) {
		this.patientsList = patientsList;
	}

	public List<Doctor> getDoctorsList() {
		return doctorsList;
	}

	public void setDoctorsList(List<Doctor> doctorsList) {
		this.doctorsList = doctorsList;
	}

	/**
	 * 
	 * @return the Hospital's Id
	 */

	public Integer getHospId() {
		return hospId;
	}

	/**
	 * Sets the hospital's id
	 * 
	 * @param hospId A Integer containing the hospital's id
	 */
	public void setHospId(Integer hospId) {

		this.hospId = hospId;
	}

	/**
	 * 
	 * @return the Hospital's name
	 * 
	 *         Gets the hospital's name
	 * @return A String representing the hospital's name
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the hospital's name
	 * 
	 * @param name A String representing the hospital's name
	 */

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return the Hospital's email
	 * 
	 *         Gets the hospital's email
	 * @return A String representing the hospital's email
	 * 
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the hospital's email
	 * 
	 * @param email A String representing the hospital's email
	 */

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 
	 * @return the Hospital's phone
	 * 
	 *         Gets the hospital's phone number
	 * @return A String representing the hospital's phone number
	 * 
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the hospital's phone number
	 * 
	 * @param phone A String representing the hospital's phone number
	 */

	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * 
	 * @return the Hospital's fax
	 * 
	 *         Gets the hospital's fax number
	 * @return A string representing the hospital's fax number
	 * 
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * Sets the hospital's fax number
	 * 
	 * @param fax A String representing the hospital's fax number
	 */

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fax == null) ? 0 : fax.hashCode());
		result = prime * result + hospId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hospital other = (Hospital) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fax == null) {
			if (other.fax != null)
				return false;
		} else if (!fax.equals(other.fax))
			return false;
		if (hospId != other.hospId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}

	

}
