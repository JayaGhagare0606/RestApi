package com.restapi.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.restapi.model.Person;
import com.restapi.service.PersonService;

@Service
public class PersonServiceImpl extends HomeService implements PersonService{

	@Override
	public List<Person> personList(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		
		
		Pageable p = PageRequest.of(pageNumber, pageSize);
		Page<Person> content = personRepo.findAll(p);
		List<Person> content2 = content.getContent();
		
		return content2;
	}

	@Override
	public Person savePerson(Person person) {
		// TODO Auto-generated method stub
		Person save = personRepo.save(person);
		return save;
	}

	@Override
	public Person findPersonById(int id,int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		List<Person> personList = personList(pageNumber,pageSize);
		Person p = null;
		for(Person a : personList) {
			if(a.getId() == id ) {
				p = a;
			}
		}
		
		return p;
	}

	@Override
	public String updatePerson(int id,int pageNumber, int pageSize, Person person) {
		// TODO Auto-generated method stub
		Person oldPerson = findPersonById(id ,pageNumber,pageSize);
		
		if(oldPerson == null) {
			return "Record Not Found";
		}
		
		oldPerson.setName(person.getName());
		oldPerson.setAddress(person.getAddress());
		oldPerson.setPhone(person.getPhone());
		oldPerson.setGender(person.getGender());
		oldPerson.setAge(person.getAge());
		oldPerson.setUsername(person.getUsername());
		oldPerson.setPassword(person.getPassword());
		oldPerson.setStatus(person.getStatus());
		oldPerson.setModified(new Date());
		
		Person save = personRepo.save(oldPerson);
		
		if(save == null) {
			return "Something Went Wrong...";
			
		}
		
		return "Record Updated...";
	}

	@Override
	public String deletePerson(int id, int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		Person person = findPersonById(id, pageNumber,pageSize);
		if(person == null) {
			return "Record Not Found.";
		}
		personRepo.delete(person);
		return "Record Deleted...";
	}

}
