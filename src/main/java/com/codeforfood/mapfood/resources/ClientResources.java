package com.codeforfood.mapfood.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.codeforfood.mapfood.domain.Client;
import com.codeforfood.mapfood.service.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResources {
	
	@Autowired
	ClientService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Client>> findAll(){
		List<Client> clients = service.findAll();
		return ResponseEntity.ok().body(clients);
	}

	@GetMapping("/{id}")
	public Client findById(@PathVariable String id){
		return service.findById(id);
	}

}
