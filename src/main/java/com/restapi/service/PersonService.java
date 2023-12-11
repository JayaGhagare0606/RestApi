package com.restapi.service;

import java.util.List;

import com.restapi.model.Person;

public interface PersonService {
	
	public List<Person> personList(int pageNumber, int pageSize);
	
	public Person savePerson(Person person);
	
	public Person findPersonById(int id, int pageNumber, int pageSize);
	
	public String updatePerson(int id,int pageNumber, int pageSize, Person person);
	
	public String deletePerson(int id,int pageNumber, int pageSize);

}
