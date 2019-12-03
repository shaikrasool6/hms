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

import com.rest.java.dto.NurseDto;
import com.rest.java.service.NurseService;

@RestController
@RequestMapping("nurse")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class NurseController {

	@Autowired
	private NurseService service;

	@PostMapping("/addNurse")
	public ResponseEntity<NurseDto> addNurse(@RequestBody NurseDto dto) {
		NurseDto nurse = service.addNurse(dto);
		return new ResponseEntity<NurseDto>(nurse, HttpStatus.OK);
	}
	@GetMapping("/nurse/{id}")
	public ResponseEntity<NurseDto> getOneNurse(@PathVariable int id){
		NurseDto nurse=service.getOneNurseById(id);
		return new ResponseEntity<NurseDto>(nurse, HttpStatus.OK);
	}
	@GetMapping("/allNurses")
	public ResponseEntity<List<NurseDto>> getAllNurses(){
		List<NurseDto> nurses=service.getAllNurses();
		return new ResponseEntity<List<NurseDto>>(nurses, HttpStatus.OK);
	}
	@PutMapping("/updateNurse")
	public ResponseEntity<NurseDto> updateNurse(@RequestBody NurseDto dto){
		NurseDto nurse=service.updateNurse(dto);
		return new ResponseEntity<NurseDto>(nurse, HttpStatus.OK);
	}
	@DeleteMapping("/nurse/{id}")
	public ResponseEntity<NurseDto> deleteNurse(@PathVariable int id){
		NurseDto nurse=service.deleteNurseById(id);
		return new ResponseEntity<NurseDto>(nurse, HttpStatus.OK);
	}
	
}
