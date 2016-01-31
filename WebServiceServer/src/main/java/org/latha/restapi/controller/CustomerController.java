package org.latha.restapi.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.latha.restapi.model.Customer;
import org.latha.restapi.service.CustomerService;

@Path("/customer")
public class CustomerController {
	
	  CustomerService service;
	
	  public CustomerController(){
		 service =new CustomerService();
		  
	  }

	 @GET
	    
	    @Produces(MediaType.APPLICATION_JSON)
	    public List<Customer> getAllCustomers() {
		 
		    List<Customer> customerList=service.getAllCustomers();
	        return customerList;
	    }
	 @GET
	    @Path("get/{id}")
	    @Produces( MediaType.APPLICATION_JSON)
	    public Customer getCustomer(@PathParam("id") int id) {
		 
		    Customer customer=service.getCustomer(id);
	        return customer;
	    }
	 
	 @POST
	 @Path("/add")
	   
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Produces(MediaType.TEXT_PLAIN)
	    public String AddCustomer(Customer customer) {
		 
		    String status=service.addCustomer(customer);
	        System.out.println(status);
	        return status;
	    }	
	 
	 @PUT
	 @Path("/update/{id}")
	   
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Produces(MediaType.TEXT_PLAIN)
	    public String updateCustomer(@PathParam("id") int id,Customer customer) {
		 
		    String status=service.updateCustomer(id,customer);
	        System.out.println(status);
	        return status;
	    }	
	 @DELETE
	 @Path("/delete/{id}")
	   
	   
	    @Produces(MediaType.TEXT_PLAIN)
	    public String deleteCustomer(@PathParam("id") int id) {
		 
		    String status=service.deleteCustomer(id);
	        System.out.println(status);
	        return status;
	    }	
}
