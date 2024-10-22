package me.dio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.domain.model.Dividend;
import me.dio.domain.repository.AssetRepository;
import me.dio.domain.repository.DividendRepository;
import me.dio.service.DividendService;

@Service
public class DividendServiceImpl implements DividendService{
	
	@Autowired
	private AssetRepository assetRepository;
	
	@Autowired
	private DividendRepository dividendRepository;

	@Override
	public Dividend create(Dividend dividend) {
		if(!assetRepository.existsById(dividend.getAssetId())) {
			throw new IllegalArgumentException("Asset not found."); 
		}

		dividendRepository.save(dividend);
		return dividend;
	}

	@Override
	public List<Dividend> findAll(Long assetId) {
		if(!assetRepository.existsById(assetId)) {
			throw new IllegalArgumentException("Asset not found."); 
		}
		return dividendRepository.findAllByAssetId(assetId);
	}

	@Override
	public void delete(Long id) {
		if(!assetRepository.existsById(id)) {
			throw new IllegalArgumentException("Dividend not found."); 
		}
		dividendRepository.deleteById(id);		
	}

}
