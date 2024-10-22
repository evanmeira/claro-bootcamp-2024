package me.dio.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.dio.domain.model.Asset;

public interface AssetRepository extends JpaRepository<Asset, Long> {
	
	boolean existsByCode(String code);

}
