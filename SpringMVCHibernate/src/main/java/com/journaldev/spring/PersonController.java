package com.journaldev.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.journaldev.spring.model.Person;
import com.journaldev.spring.service.PersonService;

@Controller
public class PersonController {
	
	private PersonService personService;
	
	@Autowired(required=true)
	@Qualifier(value="personService")
	public void setPersonService(PersonService ps){
		this.personService = ps;
	}
	
	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.listPersons());
		return "person";
	}

		
	@RequestMapping(value = "/persons/sort/by/name", method = RequestMethod.GET)
	public String sortListByName(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.sortListByName());
		return "person";
	}
	
	
	@RequestMapping(value = "/persons/sort/by/name/desc", method = RequestMethod.GET)
	public String sortListByNameASC(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.sortListByNameDESC());
		return "person";
	}
	
	@RequestMapping(value = "/persons/sort/by/country", method = RequestMethod.GET)
	public String sortListByCountry(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.sortListByCountry());
		return "person";
	}
	
	@RequestMapping(value = "/persons/sort/by/country/desc", method = RequestMethod.GET)
	public String sortListByCountryDESC(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.sortListByCountryDESC());
		return "person";
	}
	
	@RequestMapping(value = "/persons/sort/by/id/asc", method = RequestMethod.GET)
	public String sortListByIdASC(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.sortListByIdASC());
		return "person";
	}
	
	
	@RequestMapping(value = "/persons/sort/by/id/desc", method = RequestMethod.GET)
	public String sortListByIdDESC(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.sortListByIdDESC());
		return "person";
	}
	
	//For add and update person both
	@RequestMapping(value= "/person/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") Person p){
		/*
		 * if(p.getName() == "" && p.getCountry() == "") { return "/persons?error";
		 * }else
		 */ 
		if(p.getId() == 0){
			//new person, add it
			this.personService.addPerson(p);
		}else{
			//existing person, call update
			this.personService.updatePerson(p);
		}
		
		return "redirect:/persons";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
		
        this.personService.removePerson(id);
        return "redirect:/persons";
    }
 
    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", this.personService.getPersonById(id));
        model.addAttribute("listPersons", this.personService.listPersons());
        return "person";
    }
	
}
