package com.example.cathay.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cathay.po.CurrencyChinese;

@Repository
public interface CurrencyChineseDao extends JpaRepository<CurrencyChinese, Integer> {

	public List<CurrencyChinese> findByCurrency(String english);

}
