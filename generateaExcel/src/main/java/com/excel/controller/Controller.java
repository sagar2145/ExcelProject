package com.excel.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.excel.entity.ClassA;
import com.excel.entity.ClassB;
import com.excel.entity.ClassC;
import com.excel.entity.List121;
import com.excel.entity.Sample;
import com.excel.entity.StudentInfo;
import com.excel.response.Response;
import com.excel.service.Service1;


@Service
@RestController
@RequestMapping(value="/purchase", produces = "application/json" )
public class Controller {
	
	@Autowired
	Service1 service1;
	
   	// create excel sheet with all specified columns and data
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Response createExcel(@RequestBody List<StudentInfo> studentInfo){
	System.out.println("controller : "+studentInfo.get(1).getRollNo());
		return 	service1.createExcel(studentInfo);
		
	}

	// add data to StudentInfo table
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
	public Response add(@RequestBody StudentInfo studentInfo){
		return 	service1.add(studentInfo);
	}
	
	// add data to sample table
	@RequestMapping(value = "/addSample", method = RequestMethod.POST, consumes = "application/json")
	public Response addSample(@RequestBody Sample sample){
		return 	service1.addSample(sample);	
	}
	
	// add data to sample table with batch processing condition
	@RequestMapping(value = "/addS1", method = RequestMethod.POST, consumes = "application/json")
	public Response addS1(@RequestBody Sample sample){
		return 	service1.addS1(sample);	
	}
	
	// adding data from excel to DB
	@RequestMapping(value = "/addToDb", method = RequestMethod.POST, consumes = "application/json")
	public String addToDb(@RequestBody ClassA path) throws IOException{
	System.out.println("controller");
		return 	service1.addDataToDB(path.getFile());	
	}
	
	// update a specific row in excel sheet
	@RequestMapping(value = "/update121", method = RequestMethod.POST, consumes = "application/json")
	public Response update121(@RequestBody StudentInfo studentInfo){
		return 	service1.updateExcel(studentInfo);
	}
	
	// update sample table with batch processing condition
	@RequestMapping(value = "/updateSample", method = RequestMethod.POST, consumes = "application/json")
	public Response updateSample(@RequestBody Sample sample){
		return 	service1.updateSample(sample);
	}
	
	// update sample table 
	@RequestMapping(value = "/updateS1", method = RequestMethod.POST, consumes = "application/json")
	public Response updateS1(@RequestBody Sample sample){
		return 	service1.updateS1(sample);
	}
	
	// creating excel sheet and adding data from table
	@RequestMapping(value = "/addToExcel", method = RequestMethod.GET)
	public Response dbToExcel(){
		return 	service1.dbToExcel();
	}
	
	//adding data to ClassA table
	@RequestMapping(value = "/addToClassA", method = RequestMethod.POST, consumes = "application/json")
	public Response addClassA(@RequestBody ClassA classA){
		return 	service1.addToClassA(classA);
	}
	
	// adding data to ClassB table
	@RequestMapping(value = "/addToClassB", method = RequestMethod.POST, produces = "application/json")
	public Response addClassB(@RequestBody ClassB classB){
		return 	service1.addToClassB(classB);
	}
	
	//adding data to ClassC table
	@RequestMapping(value = "/addClassC", method = RequestMethod.POST, produces = "application/json")
	public Response addClassC(@RequestBody ClassC classC){
		return 	service1.addToClassC(classC);
		
	}
	
	// generating excel with first two columns  and adding data from table
	@RequestMapping(value = "/addData", method = RequestMethod.GET, consumes = "application/json")
	public String addClassData() throws IOException{
		return 	service1.addClassData();
	}
	
	// adding data to existing excel sheet
	@RequestMapping(value = "/addToExcel", method = RequestMethod.POST, consumes = "application/json")
	public String addToExcel(@RequestBody List<ClassA> classA){
		return 	service1.addDataToExcel(classA);
	}
	
	// generic method to add data to existing excel sheet
	@RequestMapping(value = "/addGenericToExcel", method = RequestMethod.POST, consumes = "application/json")
	public String addGenericToExcel(@RequestBody List121 list121){
		return 	service1.addGenericDataToExcel(list121);
	}
	
	// generic method not working
	@RequestMapping(value = "/addObject", method = RequestMethod.POST, consumes = "application/json")
	public Response generate(@RequestBody List<Object> object) throws IOException{
		System.out.println("Object controller");
		return 	service1.generate(object);
	}
	
	// generic method to add data to table
	@RequestMapping(value = "/addObj", method = RequestMethod.POST, consumes = "application/json")
	public Response generic(@RequestBody List121 list) throws IOException{
		System.out.println("Object controller");
		return 	service1.generic(list);
		}
	
	// generate excel with base64
	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = "application/json")
	public String upload(@RequestBody ClassA base64){	
		return 	service1.upload(base64.getFile());
	}
	
    // adding data to classA table
	@RequestMapping(value = "/addObjA", method = RequestMethod.POST, consumes = "application/json")
	public Response addObjA(@RequestBody List121 objA){	
		return 	service1.addObjA(objA);
	}
	
	// adding data to classB table
	@RequestMapping(value = "/addObjB", method = RequestMethod.POST, consumes = "application/json")
	public Response addObjB(@RequestBody List121 objB){	
		return 	service1.addObjB(objB);
	}
	
	// adding data to classC table
	@RequestMapping(value = "/addObjC", method = RequestMethod.POST, consumes = "application/json")
	public Response addObjC(@RequestBody List121 objC){
		return 	service1.addObjC(objC);
	}
	
	// generic method to create excel sheet with only two columns
	@RequestMapping(value = "/addGeneric", method = RequestMethod.POST, consumes = "application/json")
	public String addGenericData(@RequestBody List121 list121){
		return 	service1.addGenericData(list121);
	}
}

/* // add only purchaseOrderHeader
@RequestMapping(value = "/addOrder", method = RequestMethod.POST, consumes = "application/json")
public Response showOrders(@RequestBody StudentInfo studentInfo){

	return 	service1.addPurchaseOrder(studentInfo);
	
}*/
