package com.excel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="ClassC")
public class ClassC {
     @Id
	@Column(name="rollNo")
	private int rollNo;
	     
	@Column(name="name")
	private String name;
	
	@Column(name="english")
	private double english;
	
	@Column(name="maths")
	private double maths;
	
	@Column(name="science")
	private double science;
	
	@Column(name="totalMarks")
	private double totalMarks;
	
	@Column(name="percentage")
	private double percentage;
	
	@Column(name="status")
	private boolean status;
	
	@Lob
	@Column(name="file", columnDefinition="BLOB")
	private byte[] file;
	

	public ClassC() {
		// TODO Auto-generated constructor stub
	}


	public ClassC(int rollNo, String name, double english, double maths, double science, double totalMarks,
			double percentage, boolean status, byte[] file) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.english = english;
		this.maths = maths;
		this.science = science;
		this.totalMarks = totalMarks;
		this.percentage = percentage;
		this.status = status;
		this.file = file;
	}


	public int getRollNo() {
		return rollNo;
	}


	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getEnglish() {
		return english;
	}


	public void setEnglish(double english) {
		this.english = english;
	}


	public double getMaths() {
		return maths;
	}


	public void setMaths(double maths) {
		this.maths = maths;
	}


	public double getScience() {
		return science;
	}


	public void setScience(double science) {
		this.science = science;
	}


	public double getTotalMarks() {
		return totalMarks;
	}


	public void setTotalMarks(double totalMarks) {
		this.totalMarks = totalMarks;
	}


	public double getPercentage() {
		return percentage;
	}


	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public byte[] getFile() {
		return file;
	}


	public void setFile(byte[] file) {
		this.file = file;
	}


	
	
}
