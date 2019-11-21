package com.rest.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.java.dto.DoctorDto;
import com.rest.java.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorService service;
	

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/saveDoctor")
	public ResponseEntity<DoctorDto> saveDoctor(@RequestBody DoctorDto dto) {
		
		
		DoctorDto doctor = service.addDoctor(dto);
		
		return new ResponseEntity<DoctorDto>(doctor, HttpStatus.OK);
		
	}
		
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/allDoctors")
	public ResponseEntity<List<DoctorDto>> getAllDoctors(){
		List<DoctorDto> doctors=service.getAllDoctors();
		return new ResponseEntity<List<DoctorDto>>(doctors,HttpStatus.OK);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/updateDoctor")
	public ResponseEntity<DoctorDto> updateDoctor(@RequestBody DoctorDto dto){
		DoctorDto doctor= service.updateDoctor(dto);
		return new ResponseEntity<DoctorDto>(doctor, HttpStatus.OK);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/deleteDoctor/{id}")
	public ResponseEntity<DoctorDto> deleteDoctor(@PathVariable int id){
		DoctorDto doctor=service.deleteDoctor(id);
		return new ResponseEntity<DoctorDto>(doctor, HttpStatus.OK);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/doctorId/{id}")
	public ResponseEntity<DoctorDto> getOneDoctor(@PathVariable int id){
		DoctorDto doctor=service.getOneDoctorById(id);
		return new ResponseEntity<DoctorDto>(doctor,HttpStatus.OK);
	}
	
	
	
}
