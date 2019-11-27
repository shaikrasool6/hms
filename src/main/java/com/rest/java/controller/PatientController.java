package com.rest.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.java.dto.PatientDto;
import com.rest.java.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService service;
	
	@PostMapping("/addPatient")
	public ResponseEntity<PatientDto> addPatient(@RequestBody PatientDto dto){
		PatientDto patient=service.addPatient(dto);
		return new ResponseEntity<PatientDto>(patient, HttpStatus.OK);
	}
	@GetMapping("/allPatients")
	public ResponseEntity<List<PatientDto>> getAllPatients(){
		List<PatientDto> patientDtos=service.getAllPatients();
		return new ResponseEntity<List<PatientDto>>(patientDtos, HttpStatus.OK);
	}
	@GetMapping("/PatientId/{id}")
	public ResponseEntity<PatientDto>getOnePatient(@PathVariable int id){
		PatientDto patient=service.getOnePatient(id);
		return new ResponseEntity<PatientDto>(patient, HttpStatus.OK);
	}
	@PutMapping("/updatePatient")
	public ResponseEntity<PatientDto> updatePatient(@RequestBody PatientDto dto){
		PatientDto patient=service.updatePatient(dto);
		return new ResponseEntity<PatientDto>(patient, HttpStatus.OK);
	}
	@DeleteMapping("/patientId/{id}")
	public ResponseEntity<PatientDto> deletePatient(@PathVariable int id){
		PatientDto patient=service.deletePatient(id);
		return new ResponseEntity<PatientDto>(patient, HttpStatus.OK);
	}
	
}
