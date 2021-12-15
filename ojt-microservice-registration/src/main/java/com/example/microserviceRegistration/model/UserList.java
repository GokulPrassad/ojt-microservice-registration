package com.example.microserviceRegistration.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table
public class UserList {

	@NotEmpty(message = "First Name cannot not be empty")
	private String firstName;

	@NotEmpty(message = "Last Name cannot not be empty")
	private String lastName;

	@Id
	@NotEmpty(message = "User Name cannot not be empty")
	public String userName;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@NotEmpty(message = "Password cannot not be empty")
	@Size(min = 6, message = "Password should be greater than 6 characters")
	private String password;

	@NotEmpty(message = "Address cannot not be empty")
	private String address;

	@NotEmpty(message = "Phone number cannot not be empty")
	@Size(min = 10, max = 10, message = "Enter a valid phone number")
	private String phoneNo;

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

}
