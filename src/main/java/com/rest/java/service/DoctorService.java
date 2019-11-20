package com.rest.java.service;

import java.util.List;

import com.rest.java.dto.DoctorDto;
import com.rest.java.entity.Doctor;

public interface DoctorService extends BaseDao<DoctorDto, Doctor>{

	
	public DoctorDto addDoctor(DoctorDto dto);
	
	public DoctorDto updateDoctor(DoctorDto dto);
	
	public DoctorDto getOneDoctorById(Integer id);

	public DoctorDto deleteDoctor(Integer id);
	
	public List<DoctorDto> getAllDoctors();
}
