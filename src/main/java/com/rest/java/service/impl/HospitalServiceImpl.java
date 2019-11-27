package com.rest.java.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.java.dao.HospitalDao;
import com.rest.java.dto.DoctorDto;
import com.rest.java.dto.HospitalDto;
import com.rest.java.dto.PatientDto;
import com.rest.java.entity.Doctor;
import com.rest.java.entity.Hospital;
import com.rest.java.entity.Patient;
import com.rest.java.exception.HospitalCustomException;
import com.rest.java.service.HospitalService;

/**
 * This is the Service class which can implements HospitalService interface and
 * here taking HospitalDao has-a relation.
 * 
 * @author Shaik
 *
 */

@Service
public class HospitalServiceImpl implements HospitalService {

	private final Logger log = LoggerFactory.getLogger(HospitalServiceImpl.class);

	@Autowired
	private HospitalDao dao;

	
	@Override
	public HospitalDto saveHospital(HospitalDto dto) {

		try {
			Hospital hospital = mapDtoToEntity(dto);

			Hospital h = dao.addHospital(hospital);

			if (hospital.getHospId() != null) {

				System.out.println("hosptial added: " + h);

				log.debug("save hospital called");
				return mapEntityToDto(h);

			} else {
				throw new HospitalCustomException();
			}
		} catch (Exception e) {
			log.error("hospial unable to create. A hospital with the name'" + dto.getName() + "' already exists");
			throw new HospitalCustomException(dto.getName());
		}

	}

	@Override
	public HospitalDto updateHospital(HospitalDto dto) {

		Hospital hospital = mapDtoToEntity(dto);

		hospital = dao.updateHospital(hospital);

		if (hospital.getHospId() != null) {

			dto = mapEntityToDto(hospital);

			System.out.println("hospital updated" + hospital);
			log.debug("update hospital called");
			return dto;
		} else {
			log.error("hospital cann't be updated with id= " + hospital.getHospId());
			throw new HospitalCustomException(dto.getHospId());
		}

	}

	@Override

	public HospitalDto deleteHospital(Integer id) {

		Hospital hospital = dao.deleteHospital(id);
		try {

			if (hospital.getHospId() != null) {

				HospitalDto dto = mapEntityToDto(hospital);

				System.out.println("hospital deleted: " + hospital);
				log.debug("delete hospital called");
				return dto;
			} else {
				throw new HospitalCustomException();
			}
		} catch (Exception e) {
			log.error("hospital id not found for delete= " + id);
			throw new HospitalCustomException(id);
		}

	}

	@Override

	public HospitalDto getHospitalById(Integer id) {

		try {
			Hospital hospital = dao.getOneHospital(id);

			if (hospital.getHospId() != null) {

				HospitalDto dto = mapEntityToDto(hospital);

				System.out.println("hospital by I'd: " + hospital);
				log.debug("getHospitalById called");
				return dto;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("hospital not found: " + id);
			throw new HospitalCustomException(id);
		}
	}

	@Override
	public List<HospitalDto> getAllHospitals() {

		List<Hospital> hList = dao.getAllHospitals();

		List<HospitalDto> dtos = mapEntitysToDto(hList.iterator());

		for (int i = 0; i < hList.size(); i++) {

			HospitalDto dto = new HospitalDto();

			BeanUtils.copyProperties(hList.get(i), dto);

			log.debug("ListofAllHosptials called");

			// dtos.add(dto);
		}

		return dtos;

	}

	private List<HospitalDto> mapEntitysToDto(Iterator<Hospital> hospitalList) {

		List<HospitalDto> hospitalDtos = null;
		if (hospitalList != null) {
			hospitalDtos = new ArrayList<HospitalDto>();
			while (hospitalList.hasNext()) {
				hospitalDtos.add(mapEntityToDto(hospitalList.next()));
			}
		}

		return hospitalDtos;
	}

	@Override
	public Hospital mapDtoToEntity(HospitalDto dto) {
		Hospital hosp = new Hospital();
		hosp.setHospId(dto.getHospId());
		hosp.setEmail(dto.getEmail());
		hosp.setName(dto.getName());
		hosp.setFax(dto.getFax());
		hosp.setPhone(dto.getPhone());

		
		List<DoctorDto> drDto = dto.getDrdtos();

		if (drDto != null && drDto.size() > 0) {
			List<Doctor> dr = new ArrayList<Doctor>();
			for (DoctorDto dd : drDto) {
				dr.add(mapDtoToEntity(dd));
			}
			hosp.setDoctorsList(dr);
		}
		
		
		
		List<PatientDto> patientDtos=dto.getPntDtos();
		
		if(patientDtos!=null && patientDtos.size()>0) {
			List<Patient> patient=new ArrayList<Patient>();
			for(PatientDto patientDto:patientDtos) {
				patient.add(mapDtoToEntity(patientDto));
			}
			hosp.setPatientsList(patient);
		}
		
		
		return hosp;
	}

	private Patient mapDtoToEntity(PatientDto patientDto) {
		Patient entity = new Patient();
		entity.setPid(patientDto.getPid());
		entity.setName(patientDto.getName());
		entity.setGender(patientDto.getGender());
		entity.setEmail(patientDto.getEmail());
		entity.setAddress(patientDto.getAddress());
		entity.setPhone(patientDto.getPhone());
		entity.setDateOfBirth(patientDto.getDateOfBirth());
		entity.setAge(patientDto.getAge());
		entity.setBloodGroup(patientDto.getBloodGroup());
		entity.setAdmitDate(patientDto.getAdmitDate());
		entity.setDischargeDate(patientDto.getDischargeDate());
		entity.setDiseases(patientDto.getDiseases());
		entity.setHospital(dao.getOneHospital(patientDto.getHospId()));
		return entity;
	}

	@Override
	public HospitalDto mapEntityToDto(Hospital entity) {
		HospitalDto dto = new HospitalDto();
		dto.setHospId(entity.getHospId());
		dto.setEmail(entity.getEmail());
		dto.setName(entity.getName());
		dto.setFax(entity.getFax());
		dto.setPhone(entity.getPhone());
		
		List<Doctor> dr = entity.getDoctorsList();

		if (dr != null && dr.size() > 0) {
			List<DoctorDto> drDto = new ArrayList<DoctorDto>();
			for (Doctor d : dr) {
				drDto.add(mapEntityToDto(d));
			}
			dto.setDrdtos(drDto);
		}
		
		
		List<Patient> patient=entity.getPatientsList();
		
		if(patient !=null && patient.size()>0) {
			List<PatientDto> patientDto=new ArrayList<PatientDto>();
			
			for(Patient p:patient) {
				patientDto.add(mapEntityToDto(p));
			}
			dto.setPntDtos(patientDto);
		}
		
		

		
		return dto;
	}

	private PatientDto mapEntityToDto(Patient p) {
		PatientDto dto = new PatientDto();

		dto.setPid(p.getPid());
		dto.setName(p.getName());
		dto.setGender(p.getGender());
		dto.setEmail(p.getEmail());
		dto.setAddress(p.getAddress());
		dto.setPhone(p.getPhone());
		dto.setDateOfBirth(p.getDateOfBirth());
		dto.setAge(p.getAge());
		dto.setBloodGroup(p.getBloodGroup());
		dto.setAdmitDate(p.getAdmitDate());
		dto.setDischargeDate(p.getDischargeDate());
		dto.setDiseases(p.getDiseases());
		dto.setHospId(p.getHospital().getHospId());

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
		entity.setHospital(dao.getOneHospital(dd.getHospId()));
		return entity;
	}

	
	
	
	
	
	@Override
	public HospitalDto searchHositals(String name) {

		Hospital hospital = dao.searchHospital(name);
		HospitalDto dto = mapEntityToDto(hospital);
		System.out.println(dto);
		return dto;

	}
}
