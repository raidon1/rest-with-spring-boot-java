package br.com.java.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.java.model.Person;

@Service
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	

	public List<Person> findAll() {
		logger.info("finding all people!");
		
		List<Person> persons = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
			
		}
			
		
		return persons;
	}


		
	
	public Person findByID(String id) {
		
		logger.info("finding one person!");
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Raidon");
		person.setLastName("Rodrigues");
		person.setAddress("Alto Alegre do Maranhão- Maranhão- Brasil");
		person.setGender("Male");
		
		 
		return person;
		
	} private Person mockPerson(int i) {
	
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person name " + i );
		person.setLastName("Last name "  + i);
		person.setAddress("Some addres in Brasil " + i);
		person.setGender("Male");
		return person;
	}

}
