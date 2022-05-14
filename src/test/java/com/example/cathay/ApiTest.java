package com.example.cathay;

import com.example.cathay.dto.CoindeskDto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class ApiTest {
	
	@Autowired
    private MockMvc mockMvc;
	@Autowired
    ObjectMapper objectMapper;
	@Test
	public void testRebuild() throws Exception{
		String response = mockMvc.perform(MockMvcRequestBuilders.get("/api/rebuild")
	            .accept(MediaType.APPLICATION_JSON ))
	            .andExpect(status().isOk())
	            .andReturn().getResponse().getContentAsString();
		CoindeskDto coindeskDto = objectMapper.readValue(response, CoindeskDto.class);
	    System.out.println(coindeskDto);
	}
	@Test
	public void testCallCoindesk() throws Exception {

		String response = mockMvc.perform(MockMvcRequestBuilders.get("/api/callCoindesk")
	            .accept(MediaType.APPLICATION_JSON ))
	            .andExpect(status().isOk())
	            .andReturn().getResponse().getContentAsString();
	    System.out.println(response);
	}
}
