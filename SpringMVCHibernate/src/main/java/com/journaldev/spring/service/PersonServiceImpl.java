package com.journaldev.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.PersonDAO;
import com.journaldev.spring.model.Person;

@Service
public class PersonServiceImpl implements PersonService {
	
	private PersonDAO personDAO;

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	@Override
	@Transactional
	public void addPerson(Person p) {
		this.personDAO.addPerson(p);
	}

	@Override
	@Transactional
	public void updatePerson(Person p) {
		this.personDAO.updatePerson(p);
	}

	@Override
	@Transactional
	public List<Person> listPersons() {
		return this.personDAO.listPersons();
	}

	@Override
	@Transactional
	public Person getPersonById(int id) {
		return this.personDAO.getPersonById(id);
	}

	@Override
	@Transactional
	public void removePerson(int id) {
		this.personDAO.removePerson(id);
	}
	
	
	@Override
	@Transactional
	public List<Person> startsWithLetter(String searchLetter) {
		return this.personDAO.startsWithAlphabets(searchLetter);
	}

	@Override
	@Transactional
	public List<Person> sortListByName() {
		return this.personDAO.sortListByName();
	}
	
	@Override
	@Transactional
	public List<Person> sortListByNameASC() {
		return this.personDAO.sortListByNameASC();
	}
	
	@Override
	@Transactional
	public List<Person> sortListByNameDESC() {
		return this.personDAO.sortListByNameDESC();
	}
	
	@Override
	@Transactional
	public List<Person> sortListByCountry() {
		return this.personDAO.sortListByCountry();
	}
	
	@Override
	@Transactional
	public List<Person> sortListByCountryASC() {
		return this.personDAO.sortListByCountryASC();
	}
	
	@Override
	@Transactional
	public List<Person> sortListByCountryDESC() {
		return this.personDAO.sortListByCountryDESC();
	}

	@Override
	@Transactional
	public List<Person> sortListByIdASC() {
		return this.personDAO.sortListByIdASC();
	}

	@Override
	@Transactional
	public List<Person> sortListByIdDESC() {
		return this.personDAO.sortListByIdDESC();
	}

}
