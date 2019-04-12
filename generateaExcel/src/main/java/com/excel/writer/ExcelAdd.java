package com.excel.writer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.excel.entity.ClassA;
import com.excel.entity.ClassB;
import com.excel.entity.ClassC;
import com.excel.entity.List121;
import com.excel.entity.StudentInfo;
import com.excel.response.Response;
import com.excel.studentDAO.StudentDAO;
 

public class ExcelAdd {

	StudentDAO dao=new StudentDAO();
	Response reponse=new Response();
    public void add(List<ClassA> classA) {
    	System.out.println("entering add");
        String excelFilePath = "D:/eclipse_neon/StudentInfo.xlsx";
         
        try {
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = WorkbookFactory.create(inputStream);
 
            Sheet sheet = workbook.getSheetAt(0);
            int rowNum = 1;
            int a=2;
            for(ClassA info: classA){
            	System.out.println("entering loop");
            	 Row row = sheet.getRow(rowNum++);
            	 row.createCell(2).setCellValue(info.getEnglish());
	 	            row.createCell(3).setCellValue(info.getMaths());
	 	            row.createCell(4).setCellValue(info.getScience());
	 	            row.createCell(5).setCellFormula("SUM(C"+a+","+"D"+a+","+"E"+a+")");
	 	            row.createCell(6).setCellFormula("("+"F"+a+"*"+"100"+")"+"/"+"300");
	 	            row.createCell(7).setCellValue(info.isStatus());
	 	            a++;
            }
 
 System.out.println("after for loop");
            inputStream.close();
 
            FileOutputStream outputStream = new FileOutputStream("D:/eclipse_neon/StudentInfo.xlsx");
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
             
        } catch (IOException | EncryptedDocumentException
                | InvalidFormatException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public String genericAdd(List121 list) {
    	System.out.println("entering add");
        try {
        	if(list.getClassList()!=null){
        	 String excelFilePath = "D:/eclipse_neon/ClassA.xlsx";
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = WorkbookFactory.create(inputStream);
 
            Sheet sheet = workbook.getSheetAt(0);
            int rowNum = 1;
            int a=2;
            
				for(Object classa:list.getClassList()){
					Row row = sheet.getRow(rowNum++);
	            	 row.createCell(2).setCellValue(((ClassA) classa).getEnglish());
		 	            row.createCell(3).setCellValue(((ClassA) classa).getMaths());
		 	            row.createCell(4).setCellValue(((ClassA) classa).getScience());
		 	            row.createCell(5).setCellFormula("SUM(C"+a+","+"D"+a+","+"E"+a+")");
		 	            row.createCell(6).setCellFormula("("+"F"+a+"*"+"100"+")"+"/"+"300");
		 	            row.createCell(7).setCellFormula("IF(F"+a+"< 150,"+"false,"+"true"+")");
		 	            a++;
			}
				System.out.println("after for loop");
	            inputStream.close();
	 
	            FileOutputStream outputStream = new FileOutputStream("D:/eclipse_neon/ClassA.xlsx");
	            workbook.write(outputStream);
	            workbook.close();
	            outputStream.close();
	            String base64encodedString= dao.fetching("D:/eclipse_neon/ClassA.xlsx");
	            return base64encodedString;
        	}
			else if(list.getClassListB()!=null){
				 String excelFilePath = "D:/eclipse_neon/ClassB.xlsx";
		            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
		            Workbook workbook = WorkbookFactory.create(inputStream);
		 
		            Sheet sheet = workbook.getSheetAt(0);
		            int rowNum = 1;
		            int a=2;
				
				 for(Object obj1:list.getClassListB()){
					 Row row = sheet.getRow(rowNum++);
	            	 row.createCell(2).setCellValue(((ClassB) obj1).getEnglish());
		 	            row.createCell(3).setCellValue(((ClassB) obj1).getMaths());
		 	            row.createCell(4).setCellValue(((ClassB) obj1).getScience());
		 	            row.createCell(5).setCellFormula("SUM(C"+a+","+"D"+a+","+"E"+a+")");
		 	            row.createCell(6).setCellFormula("("+"F"+a+"*"+"100"+")"+"/"+"300");
		 	            row.createCell(7).setCellValue(((ClassB) obj1).isStatus());
		 	            a++;
					
				 }
				 System.out.println("after for loop");
		            inputStream.close();
		 
		            FileOutputStream outputStream = new FileOutputStream("D:/eclipse_neon/ClassB.xlsx");
		            workbook.write(outputStream);
		            workbook.close();
		            outputStream.close();	
		            
		            String base64encodedString= dao.fetching("D:/eclipse_neon/ClassB.xlsx");
		            return base64encodedString;
			}
			else if(list.getClassListC()!=null){
				String excelFilePath = "D:/eclipse_neon/ClassC.xlsx";
	            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
	            Workbook workbook = WorkbookFactory.create(inputStream);
	 
	            Sheet sheet = workbook.getSheetAt(0);
	            int rowNum = 1;
	            int a=2;
				for(Object obj3:list.getClassListC()){ 
					 System.out.println("third loop");
					 Row row = sheet.getRow(rowNum++);
	            	 row.createCell(2).setCellValue(((ClassC) obj3).getEnglish());
		 	            row.createCell(3).setCellValue(((ClassC) obj3).getMaths());
		 	            row.createCell(4).setCellValue(((ClassC) obj3).getScience());
		 	            row.createCell(5).setCellFormula("SUM(C"+a+","+"D"+a+","+"E"+a+")");
		 	            row.createCell(6).setCellFormula("("+"F"+a+"*"+"100"+")"+"/"+"300");
		 	            row.createCell(7).setCellValue(((ClassC) obj3).isStatus());
		 	            a++;
					
				 }
				System.out.println("after for loop");
	            inputStream.close();
	 
	            FileOutputStream outputStream = new FileOutputStream("D:/eclipse_neon/ClassC.xlsx");
	            workbook.write(outputStream);
	            workbook.close();
	            outputStream.close();
	            String base64encodedString= dao.fetching("D:/eclipse_neon/ClassC.xlsx");
	            return base64encodedString;
			}
           
 
             
        } catch (IOException | EncryptedDocumentException
                | InvalidFormatException ex) {
            ex.printStackTrace();
        }
		return null;
    }
    public void addToExcel(StudentInfo studentInfo){
    	 String excelFilePath = "D:/eclipse_neon/StudentInfo.xlsx";
         
         try {
             FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
             Workbook workbook = WorkbookFactory.create(inputStream);
  
             Sheet sheet = workbook.getSheetAt(0);
             
             int rownum=sheet.getLastRowNum();
             Row row = sheet.createRow(++rownum);
             Object [][] objArr ={ {studentInfo.getRollNo(),studentInfo.getName(),studentInfo.getEnglish(),studentInfo.getMaths(),studentInfo.getScience(),studentInfo.getTotalMarks(),studentInfo.getPercentage()
     }}
             ;
             int cellnum = 0;
             for(Object obj : objArr)
             {
                 Cell cell = row.createCell(++cellnum);
                 if(obj instanceof String)
                 {
                     cell.setCellValue((String)obj);
                 }
                 else if(obj instanceof Integer)
                 {
                     cell.setCellValue((Integer)obj);
                 }
             }
    		
             inputStream.close();
             
             FileOutputStream outputStream = new FileOutputStream("D:/eclipse_neon/StudentInfo.xlsx");
             workbook.write(outputStream);
             workbook.close();
             outputStream.close();
              
    }catch (IOException | EncryptedDocumentException
            | InvalidFormatException ex) {
        ex.printStackTrace();
    }

    }  

      
    
 
}
