package com.shakhawat.model;

import java.util.Objects;

public class Customer {

	private Integer id;
	private String firstName;
	private String lastName;
	private String city;
	private String stateRegion;
	private String zipCode;
	private String phoneNumber;
	private String email;
	private String ip;
	
	public Customer(){};
	
	public Customer(Integer id, String firstName, String lastName, String city, String stateRegion, String zipCode,
			String phoneNumber, String email, String ip) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.stateRegion = stateRegion;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.ip = ip;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStateRegion() {
		return stateRegion;
	}
	public void setStateRegion(String stateRegion) {
		this.stateRegion = stateRegion;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, email, firstName, id, ip, lastName, phoneNumber, stateRegion, zipCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(city, other.city) && Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id)
				&& Objects.equals(ip, other.ip) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(phoneNumber, other.phoneNumber) && Objects.equals(stateRegion, other.stateRegion)
				&& Objects.equals(zipCode, other.zipCode);
	}

}
