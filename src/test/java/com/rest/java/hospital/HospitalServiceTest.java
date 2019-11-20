package com.rest.java.hospital;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rest.java.dao.HospitalDao;
import com.rest.java.dto.HospitalDto;
import com.rest.java.entity.Hospital;
import com.rest.java.service.HospitalService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class HospitalServiceTest {

	@Autowired
	private HospitalService service;

	@MockBean
	private HospitalDao dao;

	@Test
	public void testSaveHospital() {
		Hospital hosp = new Hospital();
		HospitalDto dto = new HospitalDto();
		hosp = mapDtoToEntity(dto);
		hosp.setHospId(1);
		hosp.setName("ap");
		hosp.setEmail("appolo@test.com");
		hosp.setPhone("132456789");
		hosp.setFax("12345678");
		dto = mapEntityToDto(hosp);
		Mockito.when(dao.addHospital(hosp)).thenReturn(hosp);
		assertThat(service.saveHospital(dto)).isEqualTo(dto);
	}

	@Test
	public void testGetOneById() {
		Hospital hosp = new Hospital();
		HospitalDto dto = new HospitalDto();
		hosp = mapDtoToEntity(dto);
		hosp.setHospId(1);
		hosp.setName("appolo");
		hosp.setEmail("appolo@test.com");
		hosp.setPhone("132456789");
		hosp.setFax("12345678");
		dto = mapEntityToDto(hosp);
		Mockito.when(dao.getOneHospital(hosp.getHospId())).thenReturn(hosp);
		assertThat(service.getHospitalById(1)).isEqualTo(dto);
	}

	@Test
	public void testDeleteHospital() {
		Hospital hosp = new Hospital();
		HospitalDto dto = new HospitalDto();
		hosp = mapDtoToEntity(dto);
		hosp.setHospId(1);
		hosp.setName("appolo");
		hosp.setEmail("appolo@test.com");
		hosp.setPhone("132456789");
		hosp.setFax("12345678");
		dto = mapEntityToDto(hosp);
		Mockito.when(dao.deleteHospital(hosp.getHospId())).thenReturn(hosp);
		assertThat(service.deleteHospital(1)).isEqualTo(dto);
	}

	@Test
	public void testUpdateHospital() {
		Hospital hosp = new Hospital();
		HospitalDto dto = new HospitalDto();
		hosp = mapDtoToEntity(dto);
		hosp.setHospId(1);
		hosp.setName("appolo");
		hosp.setEmail("appolo@test.com");
		hosp.setPhone("132456789");
		hosp.setFax("12345678");
		Mockito.when(dao.getOneHospital(1)).thenReturn(hosp);
		hosp.setName("image");
		dto = mapEntityToDto(hosp);
		Mockito.when(dao.updateHospital(hosp)).thenReturn(hosp);
		assertThat(service.updateHospital(dto)).isEqualTo(dto);

	}


	public Hospital mapDtoToEntity(HospitalDto dto) {
		Hospital hosp = new Hospital();
		hosp.setHospId(dto.getHospId());
		hosp.setEmail(dto.getEmail());
		hosp.setName(dto.getName());
		hosp.setFax(dto.getFax());
		hosp.setPhone(dto.getPhone());
		return hosp;
	}

	public HospitalDto mapEntityToDto(Hospital entity) {
		HospitalDto dto = new HospitalDto();
		dto.setHospId(entity.getHospId());
		dto.setEmail(entity.getEmail());
		dto.setName(entity.getName());
		dto.setFax(entity.getFax());
		dto.setPhone(entity.getPhone());
		return dto;
	}
}
