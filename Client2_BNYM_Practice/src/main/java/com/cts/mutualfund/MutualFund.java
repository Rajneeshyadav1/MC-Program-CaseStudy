package com.cts.mutualfund;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.cts.customer.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class MutualFund {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String typeofmf;
	
	private long fund;
	
	//many to one because Customer can invest his fund in mutual fund alos.
	//fetchType.lazy ...because unless we call it will not fetch detail of customer.
	
	@ManyToOne(fetch=FetchType.LAZY)
	//igoner the Customer object otherwise in object conversion it will execute recursivly.
	@JsonIgnore
	private Customer customer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeofmf() {
		return typeofmf;
	}

	public void setTypeofmf(String typeofmf) {
		this.typeofmf = typeofmf;
	}

	public long getFund() {
		return fund;
	}

	public void setFund(long fund) {
		this.fund = fund;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "MutualFund [id=" + id + ", typeofmf=" + typeofmf + ", fund=" + fund + "]";
	}
	
	

}
