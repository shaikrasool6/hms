package com.rest.java.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.rest.java.dto.PatientDto;
import com.rest.java.entity.Patient;
import com.rest.java.service.PatientService;
import com.rest.java.view.PatientPdfView;

@RestController
@RequestMapping("/patient")
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {

	@Autowired
	private PatientService service;

	@PostMapping("/addPatient")
	public ResponseEntity<PatientDto> addPatient(@RequestBody PatientDto dto) {
		PatientDto patient = service.addPatient(dto);
		return new ResponseEntity<PatientDto>(patient, HttpStatus.OK);
	}

	@GetMapping("/allPatients")
	public ResponseEntity<List<PatientDto>> getAllPatients() {
		List<PatientDto> patientDtos = service.getAllPatients();
		return new ResponseEntity<List<PatientDto>>(patientDtos, HttpStatus.OK);
	}

	@GetMapping("/patientId/{id}")
	public ResponseEntity<PatientDto> getOnePatient(@PathVariable int id) {
		PatientDto patient = service.getOnePatient(id);
		return new ResponseEntity<PatientDto>(patient, HttpStatus.OK);
	}

	@PutMapping("/updatePatient")
	public ResponseEntity<PatientDto> updatePatient(@RequestBody PatientDto dto) {
		PatientDto patient = service.updatePatient(dto);
		return new ResponseEntity<PatientDto>(patient, HttpStatus.OK);
	}

	@DeleteMapping("/patientId/{id}")
	public ResponseEntity<PatientDto> deletePatient(@PathVariable int id) {
		PatientDto patient = service.deletePatient(id);
		return new ResponseEntity<PatientDto>(patient, HttpStatus.OK);
	}

	@GetMapping("/pdf/{id}")
	public ResponseEntity<InputStreamResource> pdfView(@PathVariable int id) throws IOException {

		PatientDto patient = service.getOnePatient(id);
		ByteArrayInputStream bis = PatientPdfView.patientPdfReport(patient);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=patient.pdf");
		return ResponseEntity.ok()
				.headers(headers)
				.contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));

	}

}
