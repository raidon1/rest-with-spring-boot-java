package br.com.java;

<<<<<<< HEAD:07_InjeçãodeDependênciasnoSpring Framework/rest-with-spring-boot-java/src/main/java/br/com/java/PersonController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
=======
import java.util.concurrent.atomic.AtomicLong;

>>>>>>> b5fb3f962e2f0b5be1c28ffe60ed219e99ae5ba8:05_firstStepsinJavawithSpringboot/rest-with-spring-boot-java/src/main/java/br/com/java/PersonController.java
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD:07_InjeçãodeDependênciasnoSpring Framework/rest-with-spring-boot-java/src/main/java/br/com/java/PersonController.java
import br.com.java.model.Person;
import br.com.java.services.PersonServices;


@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonServices service;
	//private PersonServices service = new PersonServices();
	 
    
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable(value =  "id") String id) throws Exception {
	   
	    return service.findByID(id) ;  
	}

      
=======
import br.com.java.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {
	
	private final AtomicLong counter = new AtomicLong();
    
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, 
	                  @PathVariable("numberTwo") String numberTwo) throws Exception {
	    if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
	        throw new UnsupportedMathOperationException("Please set numeric values!");
	    }
	    return convertToDouble(numberOne) + convertToDouble(numberTwo); 
	}

      

	private Double convertToDouble(String strNumber) {
		if(strNumber == null) return 0D;
		//10,25 BRL 10.25 USD
		String number = strNumber.replaceAll(",", ".");
		if(isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
    
>>>>>>> b5fb3f962e2f0b5be1c28ffe60ed219e99ae5ba8:05_firstStepsinJavawithSpringboot/rest-with-spring-boot-java/src/main/java/br/com/java/PersonController.java
}