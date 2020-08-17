package com.cts.customer;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.mutualfund.MutualFund;


public interface CustomerRepository extends JpaRepository<Customer,Integer>{

	Customer findByName(String name);
	

}
