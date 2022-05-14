package com.example.cathay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.cathay.dao.CurrencyChineseDao;
import com.example.cathay.dto.CoindeskDto;
import com.example.cathay.entity.Currency;
import com.example.cathay.entity.NewBPI;
import com.example.cathay.entity.NewCurrency;
import com.example.cathay.entity.Table;
import com.example.cathay.po.CurrencyChinese;
import com.google.gson.Gson;

@Service
public class ApiService {

	@Autowired
	CurrencyChineseDao currencyChineseDao;
	Gson gson = new Gson();
	public Table callCoindesk() {
		String uri = "https://api.coindesk.com/v1/bpi/currentprice.json";
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForObject(uri, String.class);
		return gson.fromJson(response, Table.class);
	}
	
	public CoindeskDto rebuildCoindesk() {
		Table table = callCoindesk();
		CoindeskDto coindeskDto = new CoindeskDto(table);
		NewBPI newBpi = new NewBPI(search(table.getBpi().getUSD()), search(table.getBpi().getGBP())
				, search(table.getBpi().getEUR()));
		coindeskDto.setBpi(newBpi);
		return coindeskDto;
		
	}
	public NewCurrency search(Currency currency) {
		
		CurrencyChinese currencyChinese = currencyChineseDao.findByCurrency(currency.getCode()).isEmpty()?
				null : currencyChineseDao.findByCurrency(currency.getCode()).get(0);
		NewCurrency result = currencyChinese != null?
				new NewCurrency(currency.getCode(), currency.getRate(), currencyChinese.getChinese())
				: new NewCurrency(currency.getCode(), currency.getRate(), null);
		return result;
	}
}
