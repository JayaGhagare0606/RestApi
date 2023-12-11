package com.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.model.City;

public interface CityRepository extends JpaRepository<City, Integer>{

}
