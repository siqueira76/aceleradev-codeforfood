package com.codeforfood.mapfood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeforfood.mapfood.domain.Emporium;
import com.codeforfood.mapfood.repository.EmporiumRepository;

@Service
public class EmporiumService {
	
	@Autowired
	EmporiumRepository repository;
	
	public List<Emporium> findAll(){
		return repository.findAll();
	}


	public Emporium findById(String id) {
		return repository.findById(id).get();
	}

}
