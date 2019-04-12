package com.excel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Sample")
public class Sample {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	
	@Column(name="password")
	private int password;
 

	
	
	
	public Sample(int id, String name, int password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public Sample() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPassword() {
		return password;
	}


	public void setPassword(int password) {
		this.password = password;
	}
	
	
	

	
	
}
