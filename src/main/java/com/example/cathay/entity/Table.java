package com.example.cathay.entity;

public class Table {

	private Time time;
	private String disclaimer;
	private String chartName;
	private BPI bpi;
	public Table(Time time, String disclaimer, String chartName, BPI bpi) {
		this.time = time;
		this.disclaimer = disclaimer;
		this.chartName = chartName;
		this.bpi = bpi;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public String getDisclaimer() {
		return disclaimer;
	}
	public void setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;
	}
	public String getChartName() {
		return chartName;
	}
	public void setChartName(String chartName) {
		this.chartName = chartName;
	}
	public BPI getBpi() {
		return bpi;
	}
	public void setBpi(BPI bpi) {
		this.bpi = bpi;
	}
}
