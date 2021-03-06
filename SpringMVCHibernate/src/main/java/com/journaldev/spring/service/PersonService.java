package com.journaldev.spring.service;

import java.util.List;

import com.journaldev.spring.model.Person;

public interface PersonService {

	public void addPerson(Person p);
	public void updatePerson(Person p);
	public List<Person> listPersons();
	public List<Person> sortListByName();
	public Person getPersonById(int id);
	public void removePerson(int id);
	List<Person> sortListByCountry();
	List<Person> sortListByIdASC();
	List<Person> sortListByIdDESC();
	List<Person> sortListByNameASC();
	List<Person> sortListByNameDESC();
	List<Person> sortListByCountryASC();
	List<Person> sortListByCountryDESC();
	List<Person> startsWithLetter(String searchLetter);
	
}
