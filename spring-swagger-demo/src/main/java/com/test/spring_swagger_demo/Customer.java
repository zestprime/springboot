package com.test.spring_swagger_demo;

public class Customer {

	private String custId;
    private String name;
    private String phoneNumber;
    
    
	public Customer(String custId, String name, String phoneNumber) {
		super();
		this.custId = custId;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
    
}
