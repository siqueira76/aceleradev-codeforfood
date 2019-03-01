package com.codeforfood.mapfood.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}
