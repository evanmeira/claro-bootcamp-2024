package me.dio.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import me.dio.domain.model.Dividend;

public interface DividendRepository extends JpaRepository<Dividend, Long> {

	List<Dividend> findAllByAssetId(Long assetId);
	
}
