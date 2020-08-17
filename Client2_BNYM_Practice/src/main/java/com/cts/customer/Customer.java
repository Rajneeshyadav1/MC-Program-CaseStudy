package com.cts.customer;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.cts.mutualfund.MutualFund;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="customer_table")
public class Customer {
	
	@Id
	@GeneratedValue
	private int Id;
	@Size(min=2,message="Name should have atleast 2 characters.")
	private String name;
	@Past
	
	private Date dob;
	private String password;
	private String pan;
	
	//create relationship between mutualfund and customer...
	@OneToMany(mappedBy="customer")
	private List<MutualFund> mfs;
	
	
	public Customer() {
		super();
	}
	public Customer(int id, @Size(min = 2) String name, @Past Date dob, String password, String pan) {
		super();
		Id = id;
		this.name = name;
		this.dob = dob;
		this.password = password;
		this.pan = pan;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	
	public List<MutualFund> getMfs() {
		return mfs;
	}
	public void setMfs(List<MutualFund> mfs) {
		this.mfs = mfs;
	}
	@Override
	public String toString() {
		return "Customer [Id=" + Id + ", name=" + name + ", dob=" + dob + ", password=" + password + ", pan=" + pan
				+ "]";
	}
	
	
	
	

	
	
	

}
