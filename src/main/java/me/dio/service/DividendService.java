package me.dio.service;

import java.util.List;

import me.dio.domain.model.Dividend;

public interface DividendService {

	Dividend create(Dividend dividend);
	
	List<Dividend> findAll(Long assetId);
	
	void delete(Long id);
	
}
