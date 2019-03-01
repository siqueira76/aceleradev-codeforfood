package com.codeforfood.mapfood.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeforfood.mapfood.domain.Motoboy;
import com.codeforfood.mapfood.service.MotoboyService;

@RestController
@RequestMapping(value = "/motoboys")
public class MotoboyResouces {
	
	@Autowired
	MotoboyService service;
	
	@GetMapping()
	public ResponseEntity<List<Motoboy>> findAll(){
		List<Motoboy> motoboys = service.findAll();
		return ResponseEntity.ok().body(motoboys);
	}

}
