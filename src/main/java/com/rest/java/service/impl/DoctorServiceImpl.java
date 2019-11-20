package com.rest.java.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.java.dao.DoctorDao;
import com.rest.java.dto.DoctorDto;
import com.rest.java.entity.Doctor;
import com.rest.java.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{
	
	
	@Autowired
	private DoctorDao dao;

	@Override
	public DoctorDto addDoctor(DoctorDto dto) {
			
		Doctor dr=mapDtoToEntity(dto);
		dr=dao.addDoctor(dr);
		return mapEntityToDto(dr);
	}

	@Override
	public DoctorDto updateDoctor(DoctorDto dto) {
		
		Doctor dr=mapDtoToEntity(dto);
		dr=dao.updateDoctor(dr);
		dto=mapEntityToDto(dr);
		return dto;
	}

	@Override
	public DoctorDto getOneDoctorById(Integer id) {
		
		Doctor dr=dao.getOneDoctorById(id);
		
		DoctorDto dto=mapEntityToDto(dr);
		
		return dto;
	}

	@Override
	public DoctorDto deleteDoctor(Integer id) {
		Doctor dr=dao.deleteDoctorById(id);
		DoctorDto dto=mapEntityToDto(dr);
		return dto;
	}

	@Override
	public List<DoctorDto> getAllDoctors() {
		
		List<DoctorDto> dtos=new ArrayList<DoctorDto>();
		List<Doctor> drs=dao.getAllDoctors();
		for(int i=0; i<drs.size(); i++) {
			DoctorDto dto=new DoctorDto();
			BeanUtils.copyProperties(drs.get(i), dto);
			dtos.add(dto);
		}		
		return dtos;
	}
	
	

	@Override
	public Doctor mapDtoToEntity(DoctorDto dto) {

		Doctor entity=new Doctor();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setPhone(dto.getPhone());
		entity.setDeparment(dto.getDeparment());
		entity.setAddress(dto.getAddress());
		return entity;
	}

	@Override
	public DoctorDto mapEntityToDto(Doctor entity) {
		
		DoctorDto dto=new DoctorDto();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setEmail(entity.getEmail());
		dto.setPhone(entity.getEmail());
		dto.setDeparment(entity.getDeparment());
		dto.setAddress(entity.getAddress());
		return dto;
	}


}
