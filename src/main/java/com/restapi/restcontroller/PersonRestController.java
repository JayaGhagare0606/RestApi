package com.restapi.restcontroller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.model.Person;
import com.restapi.service.impl.PersonServiceImpl;


@RestController
@RequestMapping("/api")
public class PersonRestController {
	@Autowired
	PersonServiceImpl personService;
	
	
	
	@GetMapping("/list")
	public ResponseEntity<List<Person>> getPersonList(
				@RequestParam(value = "pageNumber", defaultValue = "0" ,required = false) int pageNumber,
				@RequestParam(value="pageSize" , defaultValue = "2", required = false) int pageSize
			) {
		
		return new ResponseEntity<>(personService.personList(pageNumber,pageSize), HttpStatus.OK);
	}
	
	@PostMapping("/addPerson")
	public ResponseEntity<Person> addPerson(@RequestBody Person person){
		
		person.setCreated(new Date());
		person.setModified(new Date());
		person.setStatus(1);
		
		Person savePerson = personService.savePerson(person);
		
		
		return new ResponseEntity<>(savePerson,HttpStatus.OK);
	}
	
	@PutMapping("/updatePerson/{id}")
	public ResponseEntity<String> updatePerson(
			@PathVariable("id") String id,
			@RequestBody Person person,
			@RequestParam(value = "pageNumber", defaultValue = "0" ,required = false) int pageNumber,
			@RequestParam(value="pageSize" , defaultValue = "2", required = false) int pageSize)
			
	{
		String updatePerson = personService.updatePerson(Integer.parseInt(id), pageNumber, pageSize, person);
		
		return new ResponseEntity<String>(updatePerson,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deletePerson/{id}")
	public ResponseEntity<String > deletePerson(
				@PathVariable("id") String id,
				@RequestParam(value="pageNumber", defaultValue = "0", required = false) int pageNumber,
				@RequestParam(value="pageSize", defaultValue = "2", required = false) int pageSize
			){
		
			String deletePerson = personService.deletePerson(Integer.parseInt(id), pageNumber, pageSize);
			
		return new ResponseEntity<String>(deletePerson, HttpStatus.OK);
				
	}
}	