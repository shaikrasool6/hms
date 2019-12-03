package com.rest.java.service;

import java.util.List;

import com.rest.java.dto.NurseDto;
import com.rest.java.entity.Nurse;

public interface NurseService extends BaseDao<NurseDto, Nurse>{

	public NurseDto addNurse(NurseDto dto);
	
	public NurseDto updateNurse(NurseDto dto);
	
	public NurseDto getOneNurseById(Integer id);
	
	public NurseDto deleteNurseById(Integer id);
	
	public List<NurseDto> getAllNurses();
	

	
}
