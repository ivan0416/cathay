package com.example.cathay.entity;

public class NewBPI {

	private NewCurrency USD;
	private NewCurrency GBP;
	private NewCurrency EUR;
	
	public NewBPI() {
		
	}
	public NewBPI(NewCurrency uSD, NewCurrency gBP, NewCurrency eUR) {
		USD = uSD;
		GBP = gBP;
		EUR = eUR;
	}
	public NewCurrency getUSD() {
		return USD;
	}
	public void setUSD(NewCurrency uSD) {
		USD = uSD;
	}
	public NewCurrency getGBP() {
		return GBP;
	}
	public void setGBP(NewCurrency gBP) {
		GBP = gBP;
	}
	public NewCurrency getEUR() {
		return EUR;
	}
	public void setEUR(NewCurrency eUR) {
		EUR = eUR;
	} 
}
