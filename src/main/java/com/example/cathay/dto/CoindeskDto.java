package com.example.cathay.dto;

import java.text.SimpleDateFormat;

import com.example.cathay.entity.BPI;
import com.example.cathay.entity.Currency;
import com.example.cathay.entity.NewBPI;
import com.example.cathay.entity.NewCurrency;
import com.example.cathay.entity.Table;
import com.example.cathay.po.CurrencyChinese;


public class CoindeskDto {

	private String time;
	private NewBPI bpi;
	
	public CoindeskDto(){
		
	}
	public CoindeskDto(Table table) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		this.time = sdf.format(table.getTime().getUpdatedISO());
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public NewBPI getBpi() {
		return bpi;
	}
	public void setBpi(NewBPI bpi) {
		this.bpi = bpi;
	}	
}