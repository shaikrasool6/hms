package com.rest.java.dao;

import java.util.List;

import com.rest.java.entity.Patient;

public interface PatientDao {

	
	public Patient addPatient(Patient pnt);
	
	public Patient updatePatient(Patient pnt);
	
	public Patient getOnePatient(Integer id);
	
	public Patient deletePatient(Integer id);
	
	public List<Patient> getAllPatients();
}
