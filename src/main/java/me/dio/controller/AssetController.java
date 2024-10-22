package me.dio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import me.dio.domain.model.Asset;
import me.dio.service.AssetService;

@RestController
@RequestMapping("/assets")
public final class AssetController {

	@Autowired
	private AssetService assetService;
	
	@GetMapping
	public ResponseEntity<List<Asset>> getAll() {
		var assets = this.assetService.findAll();
		return ResponseEntity.ok(assets);
	}
	
	@PostMapping
	public ResponseEntity<Asset> create(@RequestBody Asset asset) {
		this.assetService.save(asset);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(asset.getId())
				.toUri();
		return ResponseEntity.created(uri).body(asset);
	}
	
	@PutMapping
	public ResponseEntity<Asset> update(@RequestBody Asset asset) {
		assetService.save(asset);
		return ResponseEntity.ok(asset);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		assetService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
}
