package org.latha.restapi.service;

import java.util.ArrayList;
import java.util.List;

import org.latha.restapi.model.Customer;

public class CustomerService {
	
	
	public List<Customer> getAllCustomers(){
		
		Customer customer=new Customer();
		Customer customer2=new Customer();
		List<Customer> customerList=new ArrayList<Customer>();
		customer.setId(1);
		customer.setName("latha");
		customer.setAddress("1204 E Algonquin rd");
		customer2.setId(2);
		customer2.setName("laxman");
		customer2.setAddress("1204 E Algonquin rd");
		customerList.add(customer);
		customerList.add(customer2);
		return customerList;
		
	}
public Customer getCustomer(int id){
		
		Customer customer=new Customer();
		
		customer.setId(1);
		customer.setName("latha");
		customer.setAddress("1204 E Algonquin rd");
		
		
		return customer;
		
	}
public String addCustomer(Customer customer){
	
	
	int id=customer.getId();
	String Name=customer.getName();
	String Address=customer.getAddress();
	
	
	return "success" +id;
	
}
public String updateCustomer(int id,Customer customer){
	
	
	int customerid=id;
	String name=customer.getName();
	String Address=customer.getAddress();
	
	
	return "updated name to " +name;
	
}
public String deleteCustomer(int id){
	
	
	int customerid=id;
	
	
	
	return "deleted customer " +customerid;
	
}
	
	
}
