package com.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.model.State;

public interface StateRepository extends JpaRepository<State, Integer>{

}
