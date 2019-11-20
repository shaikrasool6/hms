package com.rest.java.service;

import java.util.List;

import com.rest.java.dto.HospitalDto;
import com.rest.java.entity.Hospital;

/**
 * This is the interface and which extends BaseDao<HospitalDto, Hospital>
 * interface, the HospitalService interface contains five abstract methods these
 * are 1)saveHospital, 2)updateHospital, 3)deleteHospital, 4)getHospitalbyId,
 * 5)getAllHospitals. to perform curd operations on Hospital
 * 
 * @author Shaik
 *
 */
public interface HospitalService extends BaseDao<HospitalDto, Hospital> {
	/**
	 * This method takes the HospitalDto parameter and returns the HospitalDto
	 * 
	 * @param dto
	 * @return the return HosptialDto
	 */
	public HospitalDto saveHospital(HospitalDto dto);

	/**
	 * This method takes the HospitalDto parameter and returns the HospitalDto
	 * 
	 * @param dto
	 * @return the return HosptialDto
	 */
	public HospitalDto updateHospital(HospitalDto dto);

	/**
	 * This method takes the int parameter and returns the HospitalDto
	 * 
	 * @param dto the int to convert
	 * @return the return HosptialDto
	 */
	public HospitalDto deleteHospital(Integer id);

	/**
	 * This method takes the int parameter and returns the HospitalDto
	 * 
	 * @param dto the int to convert
	 * @return the return HospitalDto
	 */
	public HospitalDto getHospitalById(Integer id);

	/**
	 * this method will return List of HospitalDtos
	 * 
	 * @return it will return List of HosptialDtos
	 */
	public List<HospitalDto> getAllHospitals();

	
	public HospitalDto searchHositals(String name);
}
