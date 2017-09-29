/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author root
 */
@Component("personService")
public class PersonService {
    

	@Autowired // This means to get the bean called personRepository Which is auto-generated by Spring, we will use it to handle the data
	private PersonRepository personRepository;
    
    public String format(){
        return "You saved it!";
    }
    
    public String OnboardPerson(String name, String email) {
		Person n = new Person();
		n.setFirstName(name);
		n.setEmail(email);
		personRepository.save(n);
		return "Success.";
    }
    
	public Person getThisUser(Integer token) {
               
		return personRepository.findByPersonIndex(token);
                
	}



	public Iterable<Person> getAllUsers() {

		return personRepository.findAll();
	}
    
}
