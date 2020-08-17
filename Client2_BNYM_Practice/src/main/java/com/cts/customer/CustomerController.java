package com.cts.customer;

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

import com.cts.mutualfund.MutualFund;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class CustomerController {
	//get service...
	//get allcustomer
	@Autowired//autowiring
	
	 //create instance of customerservice
    private CustomerService service; 

	 @HystrixCommand(fallbackMethod="sendErrorResponse")
    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer) {
        return service.saveCustomer(customer);
    }

    @PostMapping("/addCustomers")
    public List<Customer> addCustomers(@RequestBody List<Customer> customers) {
        return service.saveCustomers(customers);
    }

    
   //-----GetApi
    
   
    @GetMapping("/customers")
    public List<Customer> findAllCustomer() {
    	System.out.print("Server 2--");
        return service.getCustomers();
    }

    @GetMapping("/customerById/{id}")
    public Customer findCustomerById(@PathVariable int id) {
        return service.getCustomerById(id);
    }

    @GetMapping("/customer/{name}")
    public Customer findCustomerByName(@PathVariable String name) {
        return service.getCustomerByName(name);
    }

	/*
	 * @PutMapping("/update")
	 *  public Customer updateCustomer(@RequestBody Customer customer) {
	 *   return service.updateCustomer(customer);
	 *   }
	 */
    
    //-----DeleteApi-------

    @DeleteMapping("/deleteById/{id}")
    public String deleteCustomer(@PathVariable int id) {
        return service.deleteCustomer(id);
    }
    
    //fall back method
    
    public Customer sendErrorResponse(Customer customer)
    {
		return customer;
    	
    }
    

	
	
	
	
}
