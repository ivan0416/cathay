package com.example.cathay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.cathay.po.CurrencyChinese;
import com.example.cathay.service.CurrencyChineseService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@SpringBootTest
@AutoConfigureMockMvc
public class CurrencyChineseTest {

	Gson gson = new Gson();
	@Autowired
    private MockMvc mockMvc;
	@Autowired
    ObjectMapper objectMapper;
	@MockBean
	CurrencyChineseService currencyChineseService;
	
	@Test
	public void testGetCurrencyChineseList() throws Exception {
		
		CurrencyChinese currencyChinese = new CurrencyChinese();
		currencyChinese.setCurrency("USD");
		currencyChinese.setChinese("test");
		List<CurrencyChinese> answerList = new ArrayList<CurrencyChinese>();
		answerList.add(currencyChinese);
		Mockito.when(currencyChineseService.getCurrencyChineseByEnglish("USD")).thenReturn(answerList);
		String response = mockMvc.perform(MockMvcRequestBuilders.get("/CurrencyChinese/search")
	            .accept(MediaType.APPLICATION_JSON )
	            .content("USD"))
	            .andExpect(status().isOk())
	            .andReturn().getResponse().getContentAsString();
		Iterable<CurrencyChinese> actualList = 
				objectMapper.readValue(response, new TypeReference<Iterable<CurrencyChinese>>() {
	    });
		System.out.println(gson.toJson(actualList));
		assertEquals(gson.toJson(answerList), gson.toJson(actualList));
	}
	@Test
	public void testAddCurrencyChineseList() throws Exception {
		
		CurrencyChinese currencyChinese = new CurrencyChinese();
		currencyChinese.setCurrency("USD");
		currencyChinese.setChinese("test");
		List<CurrencyChinese> requestList = new ArrayList<CurrencyChinese>();
		requestList.add(currencyChinese);
		String response = mockMvc.perform(MockMvcRequestBuilders.post("/CurrencyChinese/")
	            .accept(MediaType.APPLICATION_JSON )
	            .contentType(MediaType.APPLICATION_JSON)
	            .content(gson.toJson(requestList)))
	            .andExpect(status().isOk())
	            .andReturn().getResponse().getContentAsString();
	}
	@Test
	public void testUpdateCurrencyChineseList() throws Exception {
		
		CurrencyChinese currencyChinese = new CurrencyChinese();
		currencyChinese.setId(1);
		currencyChinese.setCurrency("USD");
		currencyChinese.setChinese("change");
		Mockito.when(currencyChineseService.updateCurrencyChineseByEnglish(gson.toJson(currencyChinese))).thenReturn(currencyChinese);
		String response = mockMvc.perform(MockMvcRequestBuilders.put("/CurrencyChinese/update")
	            .accept(MediaType.APPLICATION_JSON )
	            .contentType(MediaType.APPLICATION_JSON)
	            .content(gson.toJson(currencyChinese)))
	            .andExpect(status().isOk())
	            .andReturn().getResponse().getContentAsString();
		CurrencyChinese actual = 
				objectMapper.readValue(response, CurrencyChinese.class);
		System.out.println(gson.toJson(actual));
		assertEquals(gson.toJson(currencyChinese), gson.toJson(actual));
	}
	@Test
	public void testDeleteCurrencyChineseList() throws Exception {

		String response = mockMvc.perform(MockMvcRequestBuilders.delete("/CurrencyChinese/delete")
	            .accept(MediaType.APPLICATION_JSON )
	            .content("USD"))
	            .andExpect(status().isOk())
	            .andReturn().getResponse().getContentAsString();
	}
}
