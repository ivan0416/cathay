package com.example.cathay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cathay.po.CurrencyChinese;
import com.example.cathay.service.CurrencyChineseService;

@RestController
@RequestMapping("CurrencyChinese")
public class CurrencyChineseController {

	@Autowired
	CurrencyChineseService currencyChineseService;
	
	@PostMapping("/")
	public void addCurrencyChinese(@RequestBody List<CurrencyChinese> currencyChineseList) {
		
		currencyChineseService.addCurrencyChinese(currencyChineseList);
	}
	
	@GetMapping("/search")
    public Iterable<CurrencyChinese> getCurrencyChineseList(@RequestBody String currency) {
		
		return currency.isEmpty() ?
				currencyChineseService.getAllCurrencyChinese() : 
					currencyChineseService.getCurrencyChineseByEnglish(currency);
    }
	@PostMapping("/update")
	public void updateCurrencyChinese(@RequestBody CurrencyChinese currencyChinese) {
		
		currencyChineseService.updateCurrencyChineseByEnglish(currencyChinese);
    }
	@DeleteMapping("/delete")
	public void deleteCurrencyChinese(@RequestBody String currency) {
		currencyChineseService.deleteCurrencyChineseByEnglish(currency);
	}
}
