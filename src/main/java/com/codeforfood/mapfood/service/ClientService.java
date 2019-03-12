package com.codeforfood.mapfood.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeforfood.mapfood.domain.Client;
import com.codeforfood.mapfood.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	ClientRepository repository;
	
	public List<Client> findAll(){
		return repository.findAll();
	}

	public Client findById(String id) {
		return repository.findById(id).get();
	}

}
