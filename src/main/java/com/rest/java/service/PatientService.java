package com.rest.java.service;

import java.util.List;

import com.rest.java.dto.PatientDto;
import com.rest.java.entity.Patient;

public interface PatientService extends BaseDao<PatientDto, Patient> {

	
	public PatientDto addPatient(PatientDto dto);
	
	public PatientDto updatePatient(PatientDto dto);
	
	public PatientDto getOnePatient(Integer id);
	
	public PatientDto deletePatient(Integer id);
	
	public List<PatientDto> getAllPatients();
	
}
