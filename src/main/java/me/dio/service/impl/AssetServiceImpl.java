package me.dio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.domain.model.Asset;
import me.dio.domain.repository.AssetRepository;
import me.dio.service.AssetService;

@Service
public class AssetServiceImpl implements AssetService{

	@Autowired
	private AssetRepository assetRepository;
	
	@Override
	public Asset save(Asset assetToSave) {
		Asset assetSaved;
		if(assetToSave.getId() == null) {
			if (assetRepository.existsByCode(assetToSave.getCode())) {
	            throw new IllegalArgumentException("This Asset code already exists.");
	        }
			
			assetSaved = assetRepository.save(assetToSave);
		} else {
			if(!assetRepository.existsById(assetToSave.getId())) {
				throw new IllegalArgumentException("Asset not found."); 
			}

			assetSaved = assetRepository.save(assetToSave);
		}
		return assetSaved;
	}

	@Override
	public List<Asset> findAll() {
		return this.assetRepository.findAll();
	}

	@Override
	public Asset findById(Long id) {
		return this.assetRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		if(!assetRepository.existsById(id)) {
			throw new IllegalArgumentException("Asset not found."); 
		}
		assetRepository.deleteById(id);
	}

}
