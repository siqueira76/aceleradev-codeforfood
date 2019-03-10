package com.codeforfood.mapfood.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.codeforfood.mapfood.domain.Motoboy;
import com.codeforfood.mapfood.service.MotoboyService;

@RestController
@RequestMapping(value = "/motoboys")
public class MotoboyResources {
	
	@Autowired
	MotoboyService service;
	
	@GetMapping()
	public ResponseEntity<List<Motoboy>> findAll(){
		List<Motoboy> motoboys = service.findAll();
		return ResponseEntity.ok().body(motoboys);
	}

	@GetMapping(value="/{id}")
	public Motoboy findById(@PathVariable(value="id") String id){
		return service.findById(id);
	}

}
