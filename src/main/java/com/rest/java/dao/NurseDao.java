package com.rest.java.dao;

import java.util.List;

import com.rest.java.entity.Nurse;

public interface NurseDao {

	public Nurse addNurse(Nurse nurse);

	public Nurse updateNurse(Nurse nurse);

	public Nurse getOneNurseById(Integer id);

	public Nurse deleteOneNurseById(Integer id);

	public List<Nurse> getAllNurses();

}
