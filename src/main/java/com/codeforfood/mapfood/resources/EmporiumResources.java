package com.codeforfood.mapfood.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeforfood.mapfood.domain.Emporium;
import com.codeforfood.mapfood.service.EmporiumService;

@RestController
@RequestMapping(value = "/emporiuns")
public class EmporiumResources {
	
	@Autowired
	EmporiumService service;
	
	@GetMapping()
	public ResponseEntity<List<Emporium>> findAll(){
		List<Emporium> emporiunsts = service.findAll();
		return ResponseEntity.ok().body(emporiunsts);
	}


	@GetMapping("/{id}")
	public Emporium findById(@PathVariable String id) {
		return service.findById(id);
	}
}
