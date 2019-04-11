package com.journaldev.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.Person;

@Repository
public class PersonDAOImpl implements PersonDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addPerson(Person p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Person saved successfully, Person Details="+p);
	}

	@Override
	public void updatePerson(Person p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Person updated successfully, Person Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> listPersons() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Person> personsList = session.createQuery("from Person").list();
		for(Person p : personsList){
			logger.info("Person List::"+p);
		}
		return personsList;
	}

	@Override
	public Person getPersonById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Person p = (Person) session.load(Person.class, new Integer(id));
		logger.info("Person loaded successfully, Person details="+p);
		return p;
	}

	@Override
	public void removePerson(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Person p = (Person) session.load(Person.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Person deleted successfully, person details="+p);
	}
	
	
	@Override
	public List<Person> startsWithAlphabets(String searchLetter) {
		Session session = this.sessionFactory.getCurrentSession();
		String query = "from Person p where p.name like '"+searchLetter+"%'";	
		@SuppressWarnings("unchecked")
		List<Person> personsList = session.createQuery(query).list();
		for(Person p : personsList){
			logger.info("Person List::"+p);
		}
		return personsList;
	}

	@Override
	public List<Person> sortListByName() {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Person> personsList = session.createQuery("from Person p ORDER BY p.name").list();
		for(Person p : personsList){
			logger.info("Person List::"+p);
		}
		return personsList;
	}
	
	@Override
	public List<Person> sortListByNameASC() {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Person> personsList = session.createQuery("from Person p ORDER BY p.name ASC").list();
		for(Person p : personsList){
			logger.info("Person List::"+p);
		}
		return personsList;
	}
	
	
	
	@Override
	public List<Person> sortListByNameDESC() {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Person> personsList = session.createQuery("from Person p ORDER BY p.name DESC").list();
		for(Person p : personsList){
			logger.info("Person List::"+p);
		}
		return personsList;
	}
	
	
	@Override
	public List<Person> sortListByCountry() {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Person> personsList = session.createQuery("from Person p ORDER BY p.country").list();
		for(Person p : personsList){
			logger.info("Person List::"+p);
		}
		return personsList;
	}
	
	@Override
	public List<Person> sortListByCountryASC() {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Person> personsList = session.createQuery("from Person p ORDER BY p.country ASC").list();
		for(Person p : personsList){
			logger.info("Person List::"+p);
		}
		return personsList;
	}
	
	
	@Override
	public List<Person> sortListByCountryDESC() {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Person> personsList = session.createQuery("from Person p ORDER BY p.country DESC").list();
		for(Person p : personsList){
			logger.info("Person List::"+p);
		}
		return personsList;
	}
	
	@Override
	public List<Person> sortListByIdASC() {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Person> personsList = session.createQuery("from Person p ORDER BY p.id ASC").list();
		for(Person p : personsList){
			logger.info("Person List::"+p);
		}
		return personsList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> sortListByIdDESC() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Person> personsList = session.createQuery("from Person p ORDER BY p.id DESC").list();
		return personsList;
	}

}
