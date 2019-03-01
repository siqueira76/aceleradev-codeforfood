package com.codeforfood.mapfood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeforfood.mapfood.domain.Motoboy;
import com.codeforfood.mapfood.repository.MotoboyRepository;

@Service
public class MotoboyService {
	
	@Autowired
	MotoboyRepository repository;
	
	public List<Motoboy> findAll(){
		return repository.findAll();
	}

}
