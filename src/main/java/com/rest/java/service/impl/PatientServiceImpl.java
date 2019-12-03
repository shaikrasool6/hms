package com.rest.java.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.java.dao.HospitalDao;
import com.rest.java.dao.PatientDao;
import com.rest.java.dto.DoctorDto;
import com.rest.java.dto.PatientDto;
import com.rest.java.entity.Doctor;
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
		Patient patient = mapDtoToEntity(dto);
		patient = dao.addPatient(patient);
		return mapEntityToDto(patient);
	}

	@Override
	public PatientDto updatePatient(PatientDto dto) {
		Patient patient = mapDtoToEntity(dto);
		patient = dao.updatePatient(patient);
		dto = mapEntityToDto(patient);
		return dto;
	}

	@Override
	public PatientDto getOnePatient(Integer id) {
		Patient patient = dao.getOnePatient(id);
		PatientDto dto = mapEntityToDto(patient);
		return dto;
	}

	@Override
	public PatientDto deletePatient(Integer id) {
		Patient patient = dao.deletePatient(id);
		PatientDto dto = mapEntityToDto(patient);
		return dto;
	}

	@Override
	public List<PatientDto> getAllPatients() {
		List<Patient> patients = dao.getAllPatients();
		List<PatientDto> patientDtos = mapEntitiesToDtos(patients.iterator());
		for (int i = 0; i < patientDtos.size(); i++) {
			PatientDto dto = new PatientDto();
			BeanUtils.copyProperties(patientDtos.get(i), dto);
		}
		return patientDtos;
	}

	public List<PatientDto> mapEntitiesToDtos(Iterator<Patient> patientList) {
		List<PatientDto> dtos = null;
		if (patientList != null) {
			dtos = new ArrayList<PatientDto>();
			while (patientList.hasNext()) {
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

		List<DoctorDto> drDto = dto.getDrdtos();

		if (drDto != null && drDto.size() > 0) {
			List<Doctor> dr = new ArrayList<Doctor>();
			for (DoctorDto dd : drDto) {
				dr.add(mapDtoToEntity(dd));
			}
			entity.setDoctorsList(dr);
		}

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

		List<Doctor> dr = entity.getDoctorsList();

		if (dr != null && dr.size() > 0) {
			List<DoctorDto> drDto = new ArrayList<DoctorDto>();
			for (Doctor d : dr) {
				drDto.add(mapEntityToDto(d));
			}
			dto.setDrdtos(drDto);
		}
		return dto;
	}

	private DoctorDto mapEntityToDto(Doctor d) {
		DoctorDto dto = new DoctorDto();
		dto.setDrId(d.getDrId());
		dto.setName(d.getName());
		dto.setEmail(d.getEmail());
		dto.setPhone(d.getEmail());
		dto.setDeparment(d.getDeparment());
		dto.setAddress(d.getAddress());
		dto.setHospId(d.getHospital().getHospId());
		dto.setPid(d.getPatient().getPid());
		return dto;
	}

	private Doctor mapDtoToEntity(DoctorDto dd) {
		Doctor entity = new Doctor();
		entity.setDrId(dd.getDrId());
		entity.setName(dd.getName());
		entity.setEmail(dd.getEmail());
		entity.setPhone(dd.getPhone());
		entity.setDeparment(dd.getDeparment());
		entity.setAddress(dd.getAddress());
		entity.setHospital(hospitalDao.getOneHospital(dd.getHospId()));
		entity.setPatient(dao.getOnePatient(dd.getPid()));
		return entity;
	}

}
