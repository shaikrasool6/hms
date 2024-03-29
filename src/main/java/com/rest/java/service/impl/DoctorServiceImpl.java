package com.rest.java.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.java.dao.DoctorDao;
import com.rest.java.dao.HospitalDao;
import com.rest.java.dao.PatientDao;
import com.rest.java.dto.DoctorDto;
import com.rest.java.entity.Doctor;
import com.rest.java.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{
	
	
	@Autowired
	private DoctorDao dao;
	
	@Autowired
	private HospitalDao hospitalDao;
	
	@Autowired
	private PatientDao patientDao;

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
		
		List<Doctor> drs=dao.getAllDoctors();

		List<DoctorDto> dtos=mapEntitiesToDto(drs.iterator());
		
		for(int i=0; i<drs.size(); i++) {
			
			DoctorDto dto=new DoctorDto();
			
			BeanUtils.copyProperties(drs.get(i), dto);
			
			//dtos.add(dto);
		}		
		return dtos;
	}
	
	
	


	public List<DoctorDto> mapEntitiesToDto(Iterator<Doctor> doctorsList) {
		List<DoctorDto> doctordtos=null;
		
		if(doctorsList!=null) {
			doctordtos=new ArrayList<DoctorDto>();
			while(doctorsList.hasNext()) {
				doctordtos.add(mapEntityToDto(doctorsList.next()));
			}
		}
		
		return doctordtos;
	}

	@Override
	public Doctor mapDtoToEntity(DoctorDto dto) {

		Doctor entity=new Doctor();
		entity.setDrId(dto.getDrId());
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setPhone(dto.getPhone());
		entity.setDeparment(dto.getDeparment());
		entity.setAddress(dto.getAddress());
		entity.setHospital(hospitalDao.getOneHospital(dto.getHospId()));
		entity.setPatient(patientDao.getOnePatient(dto.getPid()));

		return entity;
	}

	@Override
	public DoctorDto mapEntityToDto(Doctor entity) {
		
		DoctorDto dto=new DoctorDto();
		dto.setDrId(entity.getDrId());
		dto.setName(entity.getName());
		dto.setEmail(entity.getEmail());
		dto.setPhone(entity.getPhone());
		dto.setDeparment(entity.getDeparment());
		dto.setAddress(entity.getAddress());
		dto.setHospId(entity.getHospital().getHospId());
		dto.setPid(entity.getPatient().getPid());
		return dto;
	}


}
