package com.rest.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.java.dto.AdminDto;
import com.rest.java.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService service;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/saveAdmin")
	public ResponseEntity<AdminDto> saveAdmin(@RequestBody AdminDto dto){
		AdminDto adminDto=service.addAdmin(dto);
		return new ResponseEntity<AdminDto>(adminDto, HttpStatus.OK);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/updateAdmin")
	public ResponseEntity<AdminDto> updateAdmin(@RequestBody AdminDto dto){
		AdminDto admin=service.updateAdmin(dto);
		
			return new ResponseEntity<AdminDto>(admin, HttpStatus.OK);
			
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/allAdmins")
	public ResponseEntity<List<AdminDto>> getAllAdmins(){
		List<AdminDto> dtos=service.getAllAdmins();
		return new ResponseEntity<List<AdminDto>>(dtos, HttpStatus.OK);
	}
	@CrossOrigin(origins= "http://localhost:4200")
	@GetMapping("/adminId/{id}")
	public ResponseEntity<AdminDto> getOneAdmin(@PathVariable int id ){
		AdminDto admin=service.getAdminById(id);
		return new ResponseEntity<AdminDto>(admin, HttpStatus.OK);
	}
}
