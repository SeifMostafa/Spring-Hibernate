package com.musala.jdbc;

import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Employee {

	@Column(name ="first_name")
	private String firstName;
	@Column(name ="last_name")
	private String lastName;
	
	@Id
	@Column
	private long id;
	
	@Column
	private String company;





	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", id=" + id + ", email=" + company + "]";
	}

	public Employee(String firstName, String lastName, String company) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;

		this.company = company;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}



	public Employee() {
		super();
	}

	
	
	
	
	
	
	
}
