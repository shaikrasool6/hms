package com.rest.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.java.dao.NurseDao;
import com.rest.java.dto.NurseDto;
import com.rest.java.entity.Nurse;
import com.rest.java.service.NurseService;

@Service
public class NurseServiceImpl implements NurseService {

	@Autowired
	private NurseDao dao;

	@Override
	public NurseDto addNurse(NurseDto dto) {
		Nurse nurse = mapDtoToEntity(dto);
		nurse = dao.addNurse(nurse);
		return mapEntityToDto(nurse);
	}

	@Override
	public NurseDto updateNurse(NurseDto dto) {
		return null;
	}

	@Override
	public NurseDto getOneNurseById(Integer id) {
		Nurse nurse = dao.getOneNurseById(id);
		NurseDto dto = mapEntityToDto(nurse);
		return dto;
	}

	@Override
	public NurseDto deleteNurseById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NurseDto> getAllNurses() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Nurse mapDtoToEntity(NurseDto dto) {
		Nurse entity = new Nurse();
		entity.setnId(dto.getnId());
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setPhone(dto.getPhone());
		entity.setAddress(dto.getAddress());
		entity.setProfileImage(dto.getProfileImage());
		return entity;
	}

	@Override
	public NurseDto mapEntityToDto(Nurse entity) {
		NurseDto dto = new NurseDto();
		dto.setnId(entity.getnId());
		dto.setName(entity.getName());
		dto.setEmail(entity.getEmail());
		dto.setPhone(entity.getPhone());
		dto.setAddress(entity.getAddress());
		dto.setProfileImage(entity.getProfileImage());
		return dto;
	}

}
