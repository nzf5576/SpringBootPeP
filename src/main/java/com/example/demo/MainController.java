/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController    // using @RestController and not @Controller so we don't have to use @responsebody in our methods 
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
	@Autowired // This means to get the bean called userRepository Which is auto-generated by Spring, we will use it to handle the data
	private PersonRepository personRepository;
        
    @Autowired
    private PersonService personService;

	//@GetMapping(path="/add") // Map ONLY GET Requests
        @RequestMapping(value = "/add", method= RequestMethod.POST)  //Thsi shoudl be POST, not GET
	public String addNewPerson (@RequestParam String name, @RequestParam String email) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Person n = new Person();
		n.setFirstName(name);
		n.setEmail(email);
		personRepository.save(n);
		return personService.format();
	}
        
        //@GetMapping(path="/all/{token}") // Map ONLY GET Requests
        @RequestMapping(value = "/all/{token}", method= RequestMethod.GET)
	public Person getThisUser(@PathVariable Integer token) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

                System.out.println("Inside getting on person with token: "+token);
               
		return personRepository.findByPersonIndex(token);
                
	}

	//@GetMapping(path="/all")  
        @RequestMapping(value = "/all", method= RequestMethod.GET)
	public Iterable<Person> getAllUsers() {
		// This returns a JSON or XML with the users
		return personRepository.findAll();
	}
        
        @RequestMapping(value = "/hi", method= RequestMethod.GET)
	public String hello(@RequestParam String name) {
		// This returns a JSON or XML with the users
		return "Priviet "+name;
	}
}