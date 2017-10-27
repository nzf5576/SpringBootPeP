/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.cache.HazelCast;
import com.app.entity.Person;
import com.app.entity.PersonRepository;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 *
 * @author root
 */
@Component("personService")
public class PersonService {
    

	@Autowired // This means to get the bean called personRepository Which is auto-generated by Spring, we will use it to handle the data
	private PersonRepository personRepository;
	
	@Autowired
    private HazelCast hazelCast;
	
	private String uid;
	private String passwd;
	private String sectoken;
	
    
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
    
	public String getToken(String id, String pass) {
		this.uid=id;
		this.passwd=pass; 
		String temp=id+pass;
		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(temp.getBytes());
			byte[] messageDigestMD5 = messageDigest.digest();
			StringBuffer stringBuffer = new StringBuffer();
			for (byte bytes : messageDigestMD5) {
				stringBuffer.append(String.format("%02x", bytes & 0xff));
			}

			System.out.println("data:" + temp);
			System.out.println("digestedMD5(hex):" + stringBuffer.toString());
			hazelCast.put(this.uid, stringBuffer.toString());
			return stringBuffer.toString();
		} catch (NoSuchAlgorithmException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		}
		return null;

	}
	
	
}
