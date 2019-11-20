package com.rest.java.hospital;
/*
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.rest.java.HospitalTestApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HospitalTestApplication.class)
@SpringBootTest
public class HospitalTestApplicationTests {
	
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

	}

	@Test
	public void AddHospitalTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/addHospital/")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\" : \"Appolo\", \"email\" : \"appolo@test.com\" , \"phone\" : \"1234567890\" , \"fax\" : \"12345678\"}")
				.accept(MediaType.APPLICATION_JSON))
		        .andExpect(jsonPath("$.hospId").exists())
				.andExpect(jsonPath("$.name").exists()).andExpect(jsonPath("$.email").exists())
				.andExpect(jsonPath("$.fax").exists()).andExpect(jsonPath("$.name").value("Appolo"))
				.andExpect(jsonPath("$.email").value("appolo@test.com"))
				.andExpect(jsonPath("$.phone").value("1234567890")).andExpect(jsonPath("$.fax").value("12345678"))
				.andDo(print());

	}

}
*/