package com.nissan.core_java.project;
public class Users 
{
	String name;
	String email;
	String phone_number;
	String city;
	String dateOfBirth;
	public Users(String name, String email, String phone_number, String city, String dateOfBirth) {
		super();
		this.name = name;
		this.email = email;
		this.phone_number = phone_number;
		this.city = city;
		this.dateOfBirth = dateOfBirth;
	}
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
