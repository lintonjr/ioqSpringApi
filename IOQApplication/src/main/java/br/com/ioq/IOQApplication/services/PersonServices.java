package br.com.ioq.IOQApplication.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ioq.IOQApplication.model.Person;
import br.com.ioq.IOQApplication.repository.PersonRepository;

@Service
public class PersonServices {
	
	@Autowired
	PersonRepository repository;
	
	public List<Person> findAll() {
		return repository.findAll();
	}
	
	public Person findById(Long id) {
		
		return repository.findById(id).orElseThrow();
	}
	
	public Person create(Person person) {
		return repository.save(person);
	}
	
	public Person update(Person person) {
		Person entity = repository.findById(person.getId()).orElseThrow();
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return repository.save(entity);
	}
	
	public void delete(Long id) {
		Person entity = repository.findById(id).orElseThrow();
		repository.delete(entity);
	}
}
