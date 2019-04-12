package com.excel.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excel.entity.ClassA;
import com.excel.entity.ClassB;
import com.excel.entity.ClassC;
import com.excel.entity.List121;
import com.excel.entity.Sample;
import com.excel.entity.StudentInfo;
import com.excel.response.Response;
import com.excel.studentDAO.StudentDAO;

@Service
public class Service1 {
	
	@Autowired
	StudentDAO studentDAO;
	
	
	@Transactional
	public Response createExcel(List<StudentInfo> studentInfo){
		return studentDAO.createExcel(studentInfo);
	}
	@Transactional
	public Response add(StudentInfo studentInfo){
		return studentDAO.add(studentInfo);
	}
	
	
	
	@Transactional
	public String addDataToDB(byte[] bs) throws IOException{
		System.out.println("service class");
		return studentDAO.addDataToDB(bs);
	}
	
	@Transactional
	 public Response updateExcel(StudentInfo studentInfo){
		return studentDAO.updateExcel(studentInfo);
	 }
	
	@Transactional
	public Response dbToExcel(){
		return studentDAO.dbToExcel();
	}
	
	@Transactional
	public Response addToClassA(ClassA classA){
		return studentDAO.addToClassA(classA);
	}
	
	@Transactional
	public Response addToClassB(ClassB classB){
		return studentDAO.addToClassB(classB);
	}
	
	@Transactional
	public Response addToClassC(ClassC classC){
		return studentDAO.addToClassC(classC);
	}
	@Transactional
	public Response addSample(Sample sample){
		return studentDAO.addSample(sample);
	}
	
	@Transactional
	public String addClassData() throws IOException{
		return studentDAO.addClassData();
	}
	
	@Transactional
	public String addDataToExcel(List<ClassA> classA){
		return studentDAO.addDataToExcel(classA);
	}
	
	@Transactional
	public Response generate(List<Object> object) throws IOException{
		System.out.println("Object service");
		return studentDAO.generate(object);
	}
	
	@Transactional
	public String upload(byte[] bs){
		return studentDAO.upload(bs);
	}
	
	@Transactional
	public Response updateSample(Sample sample){
		return studentDAO.updateSample(sample);
	}
	
	@Transactional
	public Response addS1(Sample sample){
		return studentDAO.addS1(sample);
	}
	
	@Transactional
	public Response updateS1(Sample sample){
		return studentDAO.updateS1(sample);
	}
	
	@Transactional
	public Response addObjA(List121 objA){
		return studentDAO.addObjA(objA);
	}
	
	@Transactional
	public Response addObjB(List121 objB){
		return studentDAO.addObjB(objB);
	}
	
	@Transactional
	public Response addObjC(List121 objC){
		return studentDAO.addObjC(objC);
	}
	
	@Transactional
	public  Response generic(List121 list){
		System.out.println("service");
		return studentDAO.generic(list);
	}
	
	@Transactional
	public String addGenericData(List121 list121){
		return studentDAO.addGenericData(list121);
	}
	
	@Transactional
	public String addGenericDataToExcel(List121 list121){
		return studentDAO.addGenericDataToExcel(list121);
	}
}

/*@Transactional
public Response addPurchaseOrder(StudentInfo studentInfo){
	return studentDAO.addPurchaseOrder(studentInfo);
}*/