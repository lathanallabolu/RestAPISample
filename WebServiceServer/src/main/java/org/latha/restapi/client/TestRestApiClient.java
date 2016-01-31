package org.latha.restapi.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.latha.restapi.model.*;

public class TestRestApiClient {
	
	Client client;
	
   public TestRestApiClient(){
	   
	   client= ClientBuilder.newClient();
   }
   
   public List<Customer> getAllCustomers(){
	   
	   WebTarget target=client.target("http://localhost:8080/WebServiceServer/webapi");
	   List<Customer> customerList=(List<Customer>) target.path("/customer").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Customer>>() {});
	   
	   
       return customerList;
   }
 public Customer getCustomer(int id){
	   
	   WebTarget target=client.target("http://localhost:8080/WebServiceServer/webapi");
	   Customer customer= target.path("/customer/get/"+id).request(MediaType.APPLICATION_JSON).get(Customer.class);
	   
	   
       return customer;
   }
 
 public String addCustomer(Customer customer){
	   
	   WebTarget target=client.target("http://localhost:8080/WebServiceServer/webapi");
	   Response response= target.path("/customer/add").request(MediaType.TEXT_PLAIN).post(Entity.entity(customer, MediaType.APPLICATION_JSON));
	   String status=response.readEntity(String.class);
	   
     return status;
 }
 public String updateCustomer(int id,Customer customer){
	   
	   WebTarget target=client.target("http://localhost:8080/WebServiceServer/webapi");
	   Response response= target.path("/customer/update/"+id).request(MediaType.TEXT_PLAIN).put(Entity.entity(customer, MediaType.APPLICATION_JSON));
	   String status=response.readEntity(String.class); 
	   
   return status;
}
 
 public String deleteCustomer(int id){
	   
	   WebTarget target=client.target("http://localhost:8080/WebServiceServer/webapi");
	   Response response= target.path("/customer/delete/"+id).request(MediaType.TEXT_PLAIN).delete();
	    
	   
	   String status=response.readEntity(String.class); 
	   
	   return status;
}
   
   public static void main(String a[]){
	   
	   TestRestApiClient test= new TestRestApiClient();
	   
	   List<Customer> customerList=test.getAllCustomers();
	   
	   Customer customer2=test.getCustomer(1);
	   String status=test.addCustomer(customer2);
	   System.out.println(status);
	  System.out.println("got customer id= "+customer2.getId());
	   customer2.setName("lathalucky");
	  String updateStatus= test.updateCustomer(1, customer2);
	  System.out.println(updateStatus);
	  String deleteStatus= test.deleteCustomer(1);
	  System.out.println(deleteStatus);
	  
	   for(Customer customer:customerList){
		   
		   System.out.println(customer.getId());
		   System.out.println(customer.getName());
		   System.out.println(customer.getAddress());
	   }
	   
   }
}
