package com.imtzp.utils;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class UtilsControllerTest {

	@InjectMocks
	private UtilsController utilsController;

	private MockMvc mockMvc;

	@Before
	public void setup() {

		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(utilsController).build();
	}

	@Test
	public void givenParameter_setRequestParam_andSetSessionAttribute() throws Exception {

		String param = "testparam";

		this.mockMvc
				.perform(MockMvcRequestBuilders.post("/setParam").param("param", param).sessionAttr("parameter", param))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
