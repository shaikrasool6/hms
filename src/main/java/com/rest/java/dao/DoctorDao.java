package com.rest.java.dao;

import java.util.List;

import com.rest.java.entity.Doctor;

public interface DoctorDao {

	
	public Doctor addDoctor(Doctor dr);
	
	public Doctor updateDoctor(Doctor dr);
	
	public Doctor getOneDoctorById(Integer id);
	
	public Doctor deleteDoctorById(Integer id);
	
	public List<Doctor> getAllDoctors();
}
