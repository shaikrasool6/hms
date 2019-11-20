package com.rest.java.dao;

import java.util.List;

import com.rest.java.entity.Admin;

public interface AdminDao {

	public Admin addAdmin(Admin admin);
	
	public Admin updateAdmin(Admin admin);
	
	public Admin getAdminById(Integer id);
	
	public Admin deleteAdmin(Integer id);
	
	public List<Admin> getAllAdmins();
}
