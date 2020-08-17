package com.cts.customer;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cts.mutualfund.MutualFund;


@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository repository;
	
	  //------Post method-----
	    public Customer saveCustomer(Customer customer) {
	        return repository.save(customer);
	    }

	    public List<Customer> saveCustomers(List<Customer> customers) {
	        return repository.saveAll(customers);
	    }
  
	  //------Get method----
	    public List<Customer> getCustomers() {
	        return repository.findAll();
	    }

	    public Customer getCustomerById(int id) {
	        return repository.findById(id).orElse(null);
	    }
	    

	    public Customer getCustomerByName(String name) {
	        return repository.findByName(name);
	    }
	    
	  //-----delete method-----

	    public String deleteCustomer(int id) {
	        repository.deleteById(id);
	        return "customer removed ... " + id;
	    }

	  //-----put method--------
	/*
	 * public Customer updateCustomer(Customer customer) { Customer existingCustomer
	 * = repository.findById(customer.getId()).orElse(null);
	 * existingCustomer.setName(customer.getName());
	 * existingCustomer.setAddress(customer.getAdresss()); return
	 * repository.save(existingCustomer); }
	 */

}
