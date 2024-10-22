package me.dio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import me.dio.domain.model.Dividend;
import me.dio.service.DividendService;

@RestController
@RequestMapping("/dividends")
public class DividendController {
	
	@Autowired
	private DividendService dividendService;
	
	@GetMapping
	public ResponseEntity<List<Dividend>> getAll(@RequestParam Long assetId) {
		var dividends = dividendService.findAll(assetId);
		return ResponseEntity.ok(dividends);
	}
	
	@PostMapping
	public ResponseEntity<Dividend> create(@RequestBody Dividend dividend) {
		dividendService.create(dividend);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(dividend.getId())
				.toUri();
		return ResponseEntity.created(uri).body(dividend);
	}
	
	@DeleteMapping("/{id}") 
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		dividendService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

}
