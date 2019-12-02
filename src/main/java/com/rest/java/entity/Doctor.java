package com.rest.java.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author root
 *
 */
@Entity
public class Doctor implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1135742614337641415L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int drId;
	
	private String name;
	
	private String email;
	
	private String phone;
	
	private String deparment;
	
	private String address;
	
	@ManyToOne
	@JoinColumn(name="hospId")
	private Hospital hospital;



	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public int getDrId() {
		return drId;
	}

	public void setDrId(int drId) {
		this.drId = drId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDeparment() {
		return deparment;
	}

	public void setDeparment(String deparment) {
		this.deparment = deparment;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	

	
}
