package com.rest.java.dao;

import java.util.List;

import com.rest.java.entity.Hospital;

/**
 * This interface contains 5 methods which can perform create, update, delete,
 * get by id, getAll Hospitals
 * 
 * 
 * @author Shaik
 *
 */
public interface HospitalDao {

	/**
	 * This method takes the Hospital as a parameter and returns hospital
	 * 
	 * @param hospital
	 * @return the return hospital
	 */
	public Hospital addHospital(Hospital hospital);

	/**
	 * this method takes the hospital as a parameter and returns hospital
	 * 
	 * @param hospital
	 * @return the return hospital
	 */
	public Hospital updateHospital(Hospital hospital);

	/**
	 * this method takes Integer as a parameter and returns the hospital
	 * 
	 * @param id
	 * @return the return hospital
	 */
	public Hospital deleteHospital(Integer id);

	/**
	 * this method takes Integer as a parameter adn returns the hospital
	 * 
	 * @param id
	 * @return the return hospital
	 */
	public Hospital getOneHospital(Integer id);

	/**
	 * this method will return list of hospitals
	 * 
	 * @return the return List of Hospitals
	 */
	public List<Hospital> getAllHospitals();

	
	public Hospital searchHospital(String name);
}