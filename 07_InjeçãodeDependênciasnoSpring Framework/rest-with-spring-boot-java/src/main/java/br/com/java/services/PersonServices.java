package br.com.java.services;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.java.model.Person;

@Service
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	

	public Person findByID(String id) {
		
		logger.info("finding one person!");
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Raidon");
		person.setLastName("Rodrigues");
		person.setAddress("Alto Alegre do Maranhão- Maranhão- Brasil");
		person.setGender("Male");
		
		 
		return person;
		
	}

}
