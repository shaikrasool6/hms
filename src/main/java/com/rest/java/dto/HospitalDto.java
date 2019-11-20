package com.rest.java.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.rest.java.entity.Doctor;
/**
 * This is the class Represents HospitalDto.
 * 
 * @author Shaik
 * 
 */

public class HospitalDto implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID of the Hospital Table.
	 */
	private Integer hospId;

	/**
	 * Name of the Hospital
	 */

	@Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters")
	@Pattern(regexp = "(^$|[a-zA-Z]{3,20})", message = "provide valid name in characters")
	@NotNull(message = "it is already exists...please try to make sure ")
	@NotEmpty(message = "please provide a name")
	private String name;

	/**
	 * Hospital email
	 */

	@NotBlank
	@Email(message = "Please provide a valid email address")
	@Pattern(regexp = ".+@.+\\..+", message = "Please provide a valid email address")
	@NotEmpty(message = "please provide a email")
	private String email;

	/**
	 * Hospital phone number
	 */

	@Column(length = 15, nullable = false, unique = true)
	@Size(min = 10, max = 10, message="enter 10 digit mobile number")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "provide valid phone no and it should be 10 digits")
	private String phone;

	/**
	 * Hospital fax number
	 */

	@Pattern(regexp = "(^$|[0-9]{8})", message = "provide valid fax no and it should be 8 digits")
	@Size(min = 1, max = 8, message = "provide 8 digits fax number")
	@Column(nullable = false, unique = true)
	private String fax;

	
	private List<DoctorDto> drdtos;
	
	
	
	
	
	


	public List<DoctorDto> getDrdtos() {
		return drdtos;
	}

	public void setDrdtos(List<DoctorDto> drdtos) {
		this.drdtos = drdtos;
	}

	/**
	 * Gets the hospital's id
	 * 
	 * @return A Integer representing the hospital's id
	 */
	public Integer getHospId() {
		return hospId;
	}

	/**
	 * Sets the hospital's id
	 * 
	 * @param hospId A Integer representing the hospital's id
	 */

	public void setHospId(Integer hospId) {
		this.hospId = hospId;
	}

	/**
	 * Gets the hospital's name
	 * 
	 * @return A String representing the hospital's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the hospital's name
	 * 
	 * @param newHospital A String representing the hospital's name
	 */

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the Hospital's email
	 */

	/**
	 * Gets the hospital's email
	 * 
	 * @return A String representing the hospital's email
	 */

	public String getEmail() {
		return email;
	}

	/**
	 * @param new Email A variable of type String.
	 */

	/**
	 * Sets the hospital's email
	 * 
	 * @param new Email A String representing the hospital's email
	 */

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the Hospital's phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param new phone A variable of type String.
	 */

	/**
	 * Sets the hospital's phone number
	 * 
	 * @param new phone A String representing the hospital's phone number
	 */

	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the Hospital's fax
	 * 
	 *         /** Gets the hospital's fax number
	 * 
	 * @return A String representing the hospital's fax number
	 * 
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * @param new fax A variable of type String.
	 */

	/**
	 * Sets the hospital's fax number
	 * 
	 * @param new fax A String representing the hosptial's fax number
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
		HospitalDto other = (HospitalDto) obj;
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
