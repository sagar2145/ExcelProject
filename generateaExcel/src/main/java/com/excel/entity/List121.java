package com.excel.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;


/*@JsonInclude(JsonInclude.Include.NON_EMPTY)*/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class List121  {

	List<ClassA> classList;
	List<ClassB> classListB;
    List<ClassC> classListC; 
	public List<ClassA> getClassList() {
		return classList;
	}

	public void setClassList(List<ClassA> classList) {
		this.classList = classList;
	}

	public List<ClassB> getClassListB() {
		return classListB;
	}

	public void setClassListB(List<ClassB> classListB) {
		this.classListB = classListB;
	}

	public List<ClassC> getClassListC() {
		return classListC;
	}

	public void setClassListC(List<ClassC> classListC) {
		this.classListC = classListC;
	}

	
	
	

	
	
	
	 
	
}
