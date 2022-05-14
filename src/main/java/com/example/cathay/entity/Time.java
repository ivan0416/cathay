package com.example.cathay.entity;

import java.util.Date;

public class Time {

	private String updated;
	private Date updatedISO;
	private String updateduk;
	public Time() {
		
	}
	public Time(String updated, Date updatedISO, String updateduk) {
		this.updated = updated;
		this.updatedISO = updatedISO;
		this.updateduk = updateduk;
	}
	public String getUpdated() {
		return updated;
	}
	public void setUpdated(String updated) {
		this.updated = updated;
	}
	public Date getUpdatedISO() {
		return updatedISO;
	}
	public void setUpdatedISO(Date updatedISO) {
		this.updatedISO = updatedISO;
	}
	public String getUpdateduk() {
		return updateduk;
	}
	public void setUpdateduk(String updateduk) {
		this.updateduk = updateduk;
	}
	
}
