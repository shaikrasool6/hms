package com.rest.java.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.java.dto.DoctorDto;
import com.rest.java.dto.HospitalDto;
import com.rest.java.entity.Hospital;
import com.rest.java.exception.HospitalCustomException;
import com.rest.java.service.DoctorService;
import com.rest.java.service.HospitalService;

/**
 * This is a Rest Endpoint for the Hospital all the HTTP based REST API will be
 * produces here.
 * 
 * @author Shaik
 *
 */
@RestController
@RequestMapping("/hospital")
@Validated
public class HospitalController {

	Logger log = LoggerFactory.getLogger(Hospital.class);

	@Autowired
	private HospitalService service;
	
	
	@Autowired
	private DoctorService doctorService;
	/**
	 * This Rest API will create the hospital
	 * 
	 * @param dto
	 * @return returns the HospitalDto
	 */
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/addHospital")
	public ResponseEntity<HospitalDto> addHospital(@Valid @RequestBody HospitalDto dto) {

		HospitalDto hospital = service.saveHospital(dto);
		if (hospital != null) {
			log.info("Post api is called....");
			return new ResponseEntity<HospitalDto>(hospital, HttpStatus.OK);
		} else {
			return new ResponseEntity<HospitalDto>(HttpStatus.BAD_REQUEST);
		}

	}

	/**
	 * This API for get the information of hospital based on ID
	 * 
	 * @param id
	 * @return Response contains Hospital information.
	 */
	@GetMapping(value = "/hospitalId/{id}")
	public ResponseEntity<HospitalDto> getOneHospital(@PathVariable("id") int id) {

		HospitalDto hospital = service.getHospitalById(id);
		if (hospital.getHospId() != null) {
			List<DoctorDto> dtos=doctorService.getAllDoctors();
			log.info("Get Api is called for id= " + id);
			return new ResponseEntity<HospitalDto>(hospital, HttpStatus.OK);
		} else {
			return new ResponseEntity<HospitalDto>(HttpStatus.NOT_FOUND);
		}

	}

	/**
	 * This API for deleting a hospital based on ID
	 * 
	 * @param id
	 * @return Response will return hospital
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/deleteHospital/{id}")
	public ResponseEntity<HospitalDto> deleteHospitalById(@PathVariable("id") int id) {

		HospitalDto hospital = service.deleteHospital(id);
		if (hospital.getHospId() != null) {
			log.info("Delete Api is called for id= " + id);
			return new ResponseEntity<HospitalDto>(hospital, HttpStatus.OK);
		} else {
			return new ResponseEntity<HospitalDto>(HttpStatus.BAD_REQUEST);
		}

	}

	/**
	 * This REST API will return the list of hospitals
	 * 
	 * @return return the list of hospitals
	 */
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/allHospitals")
	public ResponseEntity<List<HospitalDto>> getAllHospitals() {

		List<HospitalDto> hospitals = service.getAllHospitals();
		try {
			if (hospitals == null || hospitals.isEmpty()) {
				log.warn("no hospital are avilable");
				return new ResponseEntity<List<HospitalDto>>(hospitals, HttpStatus.NO_CONTENT);
			} else {

				log.info("Get api is callled for LoadAll Hospitals");
				return new ResponseEntity<List<HospitalDto>>(hospitals, HttpStatus.OK);
			}
		} catch (Exception e) {
			log.error("hospitals are not found");
			throw new HospitalCustomException();
		}

	}

	/**
	 * This API is used to do update the hospital data. hospital information will be
	 * updated with new info.
	 * 
	 * @param dto
	 * @return returns the updated HospitalDto
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("updateHospital")
	public ResponseEntity<HospitalDto> updateHospital(@Valid @RequestBody HospitalDto dto) {
		HospitalDto hospital = service.updateHospital(dto);
		if (hospital != null) {
			log.info("Update api is called for Update The hospital ");
			return new ResponseEntity<HospitalDto>(hospital, HttpStatus.OK);
		} else {
			return new ResponseEntity<HospitalDto>(HttpStatus.BAD_REQUEST);
		}

	}
	
	
	@GetMapping(value="/serachHospitals")
	public ResponseEntity<HospitalDto>searchHosptalsByName(@RequestParam("name") String name, HttpServletRequest req){
		System.out.println("from search "+name);
		HospitalDto dto=(HospitalDto) service.searchHositals(req.getParameter("name"));
		System.out.println("hospital name= " +dto.getName());
		return new ResponseEntity<HospitalDto>(dto, HttpStatus.OK);
		
		
		
		/*
		 * System.out.println("searching hospital by name"); String
		 * searchVal=req.getParameter("searchValue"); String
		 * searchOption=req.getParameter("name"); if(searchOption!=null) {
		 * System.out.println("from searching");
		 * 
		 * 
		 * HospitalDto dto=(HospitalDto) service.searchHositals(searchVal,
		 * searchOption); System.out.println("from search"); return new
		 * ResponseEntity<HospitalDto>( HttpStatus.OK);
		 * 
		 * }
		 */
		
		
	}

}
