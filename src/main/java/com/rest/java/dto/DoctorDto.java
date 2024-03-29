package com.rest.java.dto;

public class DoctorDto {

	
	private int drId;
	
	private String name;
	
	private String email;
	
	private String phone;
	
	private String deparment;
	
	private String address;

	private Integer hospId;
	
	private Integer pid;
	
	
	

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getHospId() {
		return hospId;
	}

	public void setHospId(Integer hospId) {
		this.hospId = hospId;
	}



	public int getDrId() {
		return drId;
	}

	public void setDrId(int drId) {
		this.drId = drId;
	}

	public String getDeparment() {
		return deparment;
	}

	public void setDeparment(String deparment) {
		this.deparment = deparment;
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



	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "DoctorDto [drId=" + drId + ", name=" + name + ", email=" + email + ", phone=" + phone + ", deparment="
				+ deparment + ", address=" + address + ", hospId=" + hospId + ", pid=" + pid + "]";
	}
	
	
	
	
	
}
