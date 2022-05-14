package com.example.cathay.controller;

import com.google.gson.Gson;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.cathay.dto.CoindeskDto;
import com.example.cathay.entity.Table;
import com.example.cathay.service.ApiService;

@RestController
@RequestMapping("api")
public class ApiController {

	@Autowired
	ApiService apiService;
	
	Gson gson = new Gson();
	@GetMapping("/callCoindesk")
	public Table callCoindesk() {
		return apiService.callCoindesk();
	}
	@GetMapping("/rebuild")
	public CoindeskDto rebuildCoindesk() {
		System.out.println(apiService.rebuildCoindesk());
		return apiService.rebuildCoindesk();
	}
}
