package com.rest.java.service;

import java.util.List;

import com.rest.java.dto.AdminDto;
import com.rest.java.entity.Admin;

public interface AdminService extends BaseDao<AdminDto, Admin>{
	
	public AdminDto addAdmin(AdminDto adminDto);
	
	public AdminDto updateAdmin(AdminDto adminDto);
	
	public AdminDto getAdminById(Integer id);
	
	public AdminDto deleteAdmin(Integer id);
	
	public List<AdminDto> getAllAdmins();
	

}
