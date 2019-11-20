package com.rest.java.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.java.dao.AdminDao;
import com.rest.java.dto.AdminDto;
import com.rest.java.entity.Admin;
import com.rest.java.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDao dao;


	@Override
	public AdminDto addAdmin(AdminDto adminDto) {
		
		Admin admin=mapDtoToEntity(adminDto);
		
		Admin ad=dao.addAdmin(admin);
		
		return mapEntityToDto(ad);
	}

	@Override
	public AdminDto updateAdmin(AdminDto adminDto) {

		Admin admin=mapDtoToEntity(adminDto);
		admin=dao.updateAdmin(admin);
		
		adminDto=mapEntityToDto(admin);
		return adminDto;
	}

	@Override
	public AdminDto getAdminById(Integer id) {
		Admin admin=dao.getAdminById(id);
		
		AdminDto dto=mapEntityToDto(admin);
		
			
		return dto;
	}

	@Override
	public AdminDto deleteAdmin(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdminDto> getAllAdmins() {
	
		List<AdminDto> dtos=new ArrayList<>();
		List<Admin> admins=dao.getAllAdmins();
		for(int i=0; i< admins.size(); i++) {
			AdminDto dto=new AdminDto();
			BeanUtils.copyProperties(admins.get(i), dto);
			dtos.add(dto);
		}
		return dtos;
	}
	@Override
	public Admin mapDtoToEntity(AdminDto dto) {
			
	Admin entity=new Admin();
	entity.setId(dto.getId());
	entity.setAdminName(dto.getAdminName());
	entity.setAdminEmail(dto.getAdminEmail());
	entity.setAdminPassword(dto.getAdminPassword());
	return entity;
	}

	@Override
	public AdminDto mapEntityToDto(Admin entity) {
		AdminDto dto=new AdminDto();
		dto.setId(entity.getId());
		dto.setAdminName(entity.getAdminName());
		dto.setAdminEmail(entity.getAdminEmail());
		dto.setAdminPassword(entity.getAdminPassword());
		return dto;
	}


}
