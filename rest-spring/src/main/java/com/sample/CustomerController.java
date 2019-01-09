package com.sample;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.exception.CustomerNotFoundException;

@RestController
public class CustomerController {
	@Value("${spring.application.name}")
	private String name;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@RequestMapping(value = "/")
	   public String hello() {
	      return "Hello World !";
	   }
	
	@RequestMapping(value = "/name")
	   public String name() {
	      return "Application name : "+ name;
	   }
	
	@RequestMapping(value = "/customers")
	public ResponseEntity<Object> getProduct() {
		  Iterable<Customer> customers = customerRepository.findAll();
	      return new ResponseEntity<>(customers, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
	   public ResponseEntity<Object> getCustomer(@PathVariable("id") String id) {
			
		  Optional<Customer> cust = customerRepository.findById(Long.parseLong(id));
		  
		  if(!cust.isPresent()) {
			  throw new CustomerNotFoundException();
		  }
		  
	      return new ResponseEntity<>("Customer Details: ! "+ cust.get(), HttpStatus.OK);
	   }
}
