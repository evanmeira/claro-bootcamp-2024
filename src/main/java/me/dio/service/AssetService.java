package me.dio.service;

import java.util.List;

import me.dio.domain.model.Asset;

public interface AssetService {
	
	Asset save(Asset asset);
	
	List<Asset> findAll();
	
	Asset findById(Long id);
	
	void delete(Long id);

}
