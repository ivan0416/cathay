package com.example.cathay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cathay.dao.CurrencyChineseDao;
import com.example.cathay.po.CurrencyChinese;
import com.google.gson.Gson;

@Service
public class CurrencyChineseService {

	@Autowired
	CurrencyChineseDao currencyChineseDao;
	Gson gson = new Gson();
	
	public void addCurrencyChinese(List <CurrencyChinese> currencyChineseList) {
		
		currencyChineseDao.saveAll(currencyChineseList);
	}
	public List<CurrencyChinese> getAllCurrencyChinese(){
		return currencyChineseDao.findAll();
	}
	
	public List<CurrencyChinese> getCurrencyChineseByEnglish(String english){
		return currencyChineseDao.findByCurrency(english);
	}
	public CurrencyChinese updateCurrencyChineseByEnglish(String body) {

		CurrencyChinese currencyChinese = gson.fromJson(body, CurrencyChinese.class);
		List<CurrencyChinese> targets = getCurrencyChineseByEnglish(currencyChinese.getCurrency());
		CurrencyChinese target = targets.get(0);
		target.setChinese(currencyChinese.getChinese());
		currencyChineseDao.save(target);
		return target;
	}
	public void deleteCurrencyChineseByEnglish(String currency) {
		List<CurrencyChinese> targets = getCurrencyChineseByEnglish(currency);
		CurrencyChinese target = targets.get(0);
		currencyChineseDao.delete(target);
	}
}
