package com.rest.java.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.java.dao.HospitalDao;
import com.rest.java.dao.PatientDao;
import com.rest.java.dto.PatientDto;
import com.rest.java.entity.Patient;
import com.rest.java.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientDao dao;

	@Autowired
	private HospitalDao hospitalDao;
	
	@Override
	public PatientDto addPatient(PatientDto dto) {
		Patient patient=mapDtoToEntity(dto);
		patient=dao.addPatient(patient);
		return mapEntityToDto(patient);
	}

	@Override
	public PatientDto updatePatient(PatientDto dto) {
		Patient patient=mapDtoToEntity(dto);
		patient=dao.updatePatient(patient);
		dto=mapEntityToDto(patient);
		return dto;
	}

	@Override
	public PatientDto getOnePatient(Integer id) {
		Patient patient=dao.getOnePatient(id);
		PatientDto dto=mapEntityToDto(patient);
		return dto;
	}

	@Override
	public PatientDto deletePatient(Integer id) {
		Patient patient=dao.deletePatient(id);
		PatientDto dto=mapEntityToDto(patient);
		return dto;
	}

	@Override
	public List<PatientDto> getAllPatients() {
		List<Patient> patients=dao.getAllPatients();
		List<PatientDto> patientDtos=mapEntitiesToDtos(patients.iterator());
		for(int i=0; i<patientDtos.size(); i++) {
			PatientDto dto=new PatientDto();
			BeanUtils.copyProperties(patientDtos.get(i), dto);
		}
		return patientDtos;
	}
	
public List<PatientDto> mapEntitiesToDtos(Iterator<Patient> patientList){
	List<PatientDto> dtos=null;
	if(patientList!=null) {
		dtos=new ArrayList<PatientDto>();
		while(patientList.hasNext()) {
			dtos.add(mapEntityToDto(patientList.next()));
		}
	}
	return dtos;
}
	@Override
	public Patient mapDtoToEntity(PatientDto dto) {
		Patient entity = new Patient();
		entity.setPid(dto.getPid());
		entity.setName(dto.getName());
		entity.setGender(dto.getGender());
		entity.setEmail(dto.getEmail());
		entity.setAddress(dto.getAddress());
		entity.setPhone(dto.getPhone());
		entity.setDateOfBirth(dto.getDateOfBirth());
		entity.setAge(dto.getAge());
		entity.setBloodGroup(dto.getBloodGroup());
		entity.setAdmitDate(dto.getAdmitDate());
		entity.setDischargeDate(dto.getDischargeDate());
		entity.setDiseases(dto.getDiseases());
		entity.setHospital(hospitalDao.getOneHospital(dto.getHospId()));
		return entity;
	}

	@Override
	public PatientDto mapEntityToDto(Patient entity) {

		PatientDto dto = new PatientDto();

		dto.setPid(entity.getPid());
		dto.setName(entity.getName());
		dto.setGender(entity.getGender());
		dto.setEmail(entity.getEmail());
		dto.setAddress(entity.getAddress());
		dto.setPhone(entity.getPhone());
		dto.setDateOfBirth(entity.getDateOfBirth());
		dto.setAge(entity.getAge());
		dto.setBloodGroup(entity.getBloodGroup());
		dto.setAdmitDate(entity.getAdmitDate());
		dto.setDischargeDate(entity.getDischargeDate());
		dto.setDiseases(entity.getDiseases());
		dto.setHospId(entity.getHospital().getHospId());
		
		return dto;
	}

}
