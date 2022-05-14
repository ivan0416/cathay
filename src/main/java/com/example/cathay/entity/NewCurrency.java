package com.example.cathay.entity;

public class NewCurrency {

	private String code;
	private String rate;
	public String chinese;
	public NewCurrency() {
	}
	public NewCurrency(String code, String rate, String chinese) {
		this.code = code;
		this.rate = rate;
		this.chinese = chinese;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getChinese() {
		return chinese;
	}
	public void setChinese(String chinese) {
		this.chinese = chinese;
	}
	
}
