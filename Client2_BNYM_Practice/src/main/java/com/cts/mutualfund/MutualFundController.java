package com.cts.mutualfund;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cts.customer.Customer;
import com.cts.customer.CustomerNotFoundException;
import com.cts.customer.CustomerRepository;

@RestController
public class MutualFundController{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private MutualFundRepository mfRepository;

	// get all customers along with their mutual funds
	@GetMapping("/mf/customers")
	public List<Customer> retrieveAllCustomers() {
		return customerRepository.findAll();
	}

   // Delete Service for mutual fund...
	@DeleteMapping("/mf/deletecustomerById/{id}")
	public void deleteCustomer(@PathVariable int id) {
		customerRepository.deleteById(id);
	}

   //	Get Serivce for mutual fund....
	
	@GetMapping("/mf/customer/{id}")
	public List<MutualFund> retrieveAllCustomers(@PathVariable int id) {
		Optional<Customer> customerOptional = customerRepository.findById(id);
		
		if(!customerOptional.isPresent()) {
			throw new CustomerNotFoundException("id--" + id);
		}
		
		return customerOptional.get().getMfs();
	}

    // Post srvice for mutual fund...
	
	@PostMapping("/mf/createmf/{id}")
	public ResponseEntity<Object> createMf(@PathVariable int id, @RequestBody MutualFund mf) {
		
		Optional<Customer> customerOptional = customerRepository.findById(id);
		
		if(!customerOptional.isPresent()) {
			throw new CustomerNotFoundException("id--" + id);
		}

		Customer customer = customerOptional.get();
		
		mf.setCustomer(customer);
		
		mfRepository.save(mf);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(mf.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}

}
