package br.com.java;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    
}