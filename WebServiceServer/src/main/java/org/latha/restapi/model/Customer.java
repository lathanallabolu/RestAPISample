package org.latha.restapi.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {

	 private int Id;
	 private String name;
	 private String address;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
