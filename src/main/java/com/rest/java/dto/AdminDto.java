package com.rest.java.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class AdminDto {

	private int id;
	
	@Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters")
	@Pattern(regexp = "(^$|[a-zA-Z]{3,20})", message = "provide valid name in characters")
	@NotNull(message = "it is already exists...please try to make sure ")
	@NotEmpty(message = "please provide a name")
	private String adminName;
	
	@NotBlank
	@Email(message = "Please provide a valid email address")
	@Pattern(regexp = ".+@.+\\..+", message = "Please provide a valid email address")
	@NotEmpty(message = "please provide a email")
	private String adminEmail;
	
	@Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
	private String adminPassword;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	

}
