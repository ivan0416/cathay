package com.example.cathay.po;

import javax.persistence.*;

@Entity
public class CurrencyChinese {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	@Column
	private String currency;
	@Column
	private String chinese;
	
	public CurrencyChinese() {
		
	}
	public CurrencyChinese(String currency, String chinese) {
		this.currency = currency;
		this.chinese = chinese;
	}
	public Integer getId() {
        return id;
    }
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getChinese() {
		return chinese;
	}
	public void setChinese(String chinese) {
		this.chinese = chinese;
	}
	
}
