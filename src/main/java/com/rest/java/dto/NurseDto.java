package com.rest.java.dto;

public class NurseDto {

	private int nId;
	private String name;
	private String email;
	private String address;
	private int phone;
	private String profileImage;

	public int getnId() {
		return nId;
	}

	public void setnId(int nId) {
		this.nId = nId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	
	public NurseDto(int nId, String name, String email, String address, int phone, String profileImage) {
		super();
		this.nId = nId;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.profileImage = profileImage;
	}

	public NurseDto() {
		super();
	}

	@Override
	public String toString() {
		return "NurseDto [nId=" + nId + ", name=" + name + ", email=" + email + ", address=" + address + ", phone="
				+ phone + ", profileImage=" + profileImage + "]";
	}

	

}
