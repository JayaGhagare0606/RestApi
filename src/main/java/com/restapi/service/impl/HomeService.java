package com.restapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.restapi.repository.CityRepository;
import com.restapi.repository.PersonRepository;
import com.restapi.repository.StateRepository;

public class HomeService {
	
	@Autowired
	PersonRepository personRepo;
	
	@Autowired
	CityRepository cityRepo;
	
	@Autowired
	StateRepository stateRepo;

}
