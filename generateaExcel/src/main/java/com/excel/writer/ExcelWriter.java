package com.excel.writer;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ComparisonOperator;
import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PatternFormatting;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.SheetConditionalFormatting;
import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.excel.entity.ClassA;
import com.excel.entity.ClassB;
import com.excel.entity.ClassC;
import com.excel.entity.List121;
import com.excel.entity.StudentInfo;
import com.excel.studentDAO.StudentDAO;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

public class ExcelWriter {

	 StudentDAO dao=new StudentDAO();
	 // create excel 
	 public void createExcel() throws IOException { 
		      
		 String[] columns = {"RollNo", "Name", "English", "Maths", "Science", "Total Marks", "Percentage"};
		  
		        // Creating Workbook instances 
		        Workbook wb = new HSSFWorkbook(); 
		  
		        // An output stream accepts output bytes and sends them to sink. 
		        OutputStream fileOut = new FileOutputStream("StudentInfo.xlsx"); 
		        // Creating Sheets using sheet object 
		        Sheet sheet1 = wb.createSheet("Array"); 
		      
		        
		        Font headerFont = wb.createFont();
		        headerFont.setBold(true);
		        headerFont.setFontHeightInPoints((short) 14);
		        headerFont.setColor(IndexedColors.OLIVE_GREEN.getIndex());

		        // Create a CellStyle with the font
		        CellStyle headerCellStyle = wb.createCellStyle();
		        headerCellStyle.setFont(headerFont);

		        // Create a Row
		        Row headerRow = sheet1.createRow(0);

		        // Creating cells
		        for(int i = 0; i < columns.length; i++) {
		            Cell cell = headerRow.createCell(i);
		            cell.setCellValue(columns[i]);
		            cell.setCellStyle(headerCellStyle);
		        }  
		     // Resize all columns to fit the content size
		        for(int i = 0; i < columns.length; i++) {
		            sheet1.autoSizeColumn(i);
		        }
		  
		System.out.println("Sheets Has been Created successfully"); 
		  
		        wb.write(fileOut);
				 
		    } 
	 
	 public  void createExcel121(List<StudentInfo> studentInfo) throws IOException, InvalidFormatException {

/*		 student.add(new StudentInfo(studentInfo.getRollNo(),studentInfo.getName(),studentInfo.getEnglish(),studentInfo.getMaths(),studentInfo.getScience(),studentInfo.getTotalMarks(),studentInfo.getPercentage()));
*/		 String[] columns = {"rollNo", "name", "english", "maths", "science",
				 "totalMarks", "percentage"};

	        // Create a Workbook
	        Workbook workbook = new XSSFWorkbook();     // new HSSFWorkbook() for generating `.xls` file

	        /* CreationHelper helps us create instances for various things like DataFormat,
	           Hyperlink, RichTextString etc in a format (HSSF, XSSF) independent way */
	        CreationHelper createHelper = workbook.getCreationHelper();

	        // Create a Sheet
	        Sheet sheet = workbook.createSheet("Student");

	        // Create a Font for styling header cells
	        Font headerFont = workbook.createFont();
	        headerFont.setBold(true);
	        headerFont.setFontHeightInPoints((short) 14);
	        headerFont.setColor(IndexedColors.RED.getIndex());

	        // Create a CellStyle with the font
	        CellStyle headerCellStyle = workbook.createCellStyle();
	        headerCellStyle.setFont(headerFont);

	        // Create a Row
	        Row headerRow = sheet.createRow(0);

	        // Creating cells
	        for(int i = 0; i < columns.length; i++) {
	            Cell cell = headerRow.createCell(i);
	            cell.setCellValue(columns[i]);
	            cell.setCellStyle(headerCellStyle);
	        }
	        // Create Other rows and cells with student data
	        int rowNum = 1;
	        int a=2;
	        for(StudentInfo info: studentInfo) {
	        	
	            Row row = sheet.createRow(rowNum++);

	            row.createCell(0).setCellValue(info.getRollNo());
	            System.out.println(info.getRollNo());
	            row.createCell(1).setCellValue(info.getName());
	            row.createCell(2).setCellValue(info.getEnglish());
	            row.createCell(3).setCellValue(info.getMaths());
	            row.createCell(4).setCellValue(info.getScience());
	            row.createCell(5).setCellFormula("SUM(C"+a+","+"D"+a+","+"E"+a+")");
	            row.createCell(6).setCellFormula("("+"F"+a+"*"+"100"+")"+"/"+"300");
	         a++;
	           
	        }

	        // Resize all columns to fit the content size
	        for(int i = 0; i < columns.length; i++) {
	            sheet.autoSizeColumn(i);
	        }

	        // Write the output to a file
	        FileOutputStream fileOut = new FileOutputStream("StudentInfo.xlsx");
	        workbook.write(fileOut);
	        fileOut.close();

	        workbook.close();
	    }
	 
	 
	 public  void genericExcel(List<ClassA> classA) throws IOException, InvalidFormatException {
			
System.out.println("entering List");
			 String[] columns = {"rollNo", "name", "english", "maths", "science",
		 				 "totalMarks", "percentage","status"};

		 	        // Create a Workbook
		 	        Workbook workbook = new XSSFWorkbook();     // new HSSFWorkbook() for generating `.xls` file

		 	        /* CreationHelper helps us create instances for various things like DataFormat,
		 	           Hyperlink, RichTextString etc in a format (HSSF, XSSF) independent way */
		 	        CreationHelper createHelper = workbook.getCreationHelper();

		 	        // Create a Sheet
		 	        Sheet sheet = workbook.createSheet("Student");
		 	        // Create a Font for styling header cells
		 	        Font headerFont = workbook.createFont();
		 	        headerFont.setBold(true);
		 	        headerFont.setFontHeightInPoints((short) 14);
		 	        headerFont.setColor(IndexedColors.RED.getIndex());

		 	        // Create a CellStyle with the font
		 	        CellStyle headerCellStyle = workbook.createCellStyle();
		 	        headerCellStyle.setFont(headerFont);

		 	        // Create a Row
		 	        Row headerRow = sheet.createRow(0);

		 	        // Creating cells
		 	        for(int i = 0; i < columns.length; i++) {
		 	            Cell cell = headerRow.createCell(i);
		 	            cell.setCellValue(columns[i]);
		 	            cell.setCellStyle(headerCellStyle);
		 	        }
		 	        // Create Other rows and cells with student data
		 	        int rowNum = 1;
		 	        int a=2;
		 	        for(ClassA info: classA) {
		 	        	
		 	            Row row = sheet.createRow(rowNum++);

		 	            row.createCell(0).setCellValue(info.getRollNo());
		 	            System.out.println(info.getRollNo());
		 	            row.createCell(1).setCellValue(info.getName());
		 	            
		 	         a++;
		 	           
		 	        }

		 	        // Resize all columns to fit the content size
		 	        for(int i = 0; i < columns.length; i++) {
		 	            sheet.autoSizeColumn(i);
		 	        }

		 	        // Write the output to a file
		 	        FileOutputStream fileOut = new FileOutputStream("StudentInfo.xlsx");
		 	        workbook.write(fileOut);
		 	        fileOut.close();

		 	        workbook.close();
		 	    }
		 	 
	 
	


public  String genericExcelAdd(List121 list) throws IOException, InvalidFormatException {
	
System.out.println("entering List");

			 String[] columns = {"rollNo", "name", "english", "maths", "science",
		 				 "totalMarks", "percentage","status"};

		 	        // Create a Workbook
		 	        Workbook workbook = new XSSFWorkbook();     // new HSSFWorkbook() for generating `.xls` file

		 	        /* CreationHelper helps us create instances for various things like DataFormat,
		 	           Hyperlink, RichTextString etc in a format (HSSF, XSSF) independent way */
		 	        CreationHelper createHelper = workbook.getCreationHelper();
		 	       
		 	       if(list.getClassList()!=null){
		 	        // Create a Sheet
		 	        workbook.createSheet("ClassA");}
		 	       else if(list.getClassListB()!=null){
		 	    	workbook.createSheet("ClassB");
		 	       }
		 	      else if(list.getClassListC()!=null){
		 	    	   workbook.createSheet("ClassC");
		 	       }
		 	       Sheet sheet=workbook.getSheetAt(0);
		 	        // Create a Font for styling header cells
		 	        Font headerFont = workbook.createFont();
		 	        headerFont.setBold(true);
		 	        headerFont.setFontHeightInPoints((short) 14);
		 	        headerFont.setColor(IndexedColors.RED.getIndex());

		 	        // Create a CellStyle with the font
		 	        CellStyle headerCellStyle = workbook.createCellStyle();
		 	        headerCellStyle.setFont(headerFont);

		 	        // Create a Row
		 	        Row headerRow = sheet.createRow(0);

		 	        // Creating cells
		 	        for(int i = 0; i < columns.length; i++) {
		 	            Cell cell = headerRow.createCell(i);
		 	            cell.setCellValue(columns[i]);
		 	            cell.setCellStyle(headerCellStyle);
		 	        }
		 	        // Create Other rows and cells with student data
		 	        int rowNum = 1;
		 	        int a=2;
		 	       if(list.getClassList()!=null){
						for(Object classa:list.getClassList()){
							 Row row = sheet.createRow(rowNum++);
							 row.createCell(0).setCellValue(((ClassA) classa).getRollNo());
							 row.createCell(1).setCellValue(((ClassA) classa).getName());
					}
						
						
						 for(int i = 0; i < columns.length; i++) {
				 	            sheet.autoSizeColumn(i);
				 	        }

				 	        // Write the output to a file
				 	        FileOutputStream fileOut = new FileOutputStream("ClassA.xlsx");
				 	      
				 	        workbook.write(fileOut);
				 	        fileOut.close();
				 	        workbook.close();	
				 	       String base64encodedString= dao.fetching("D:/eclipse_neon/StudentInfo.xlsx");
				 	       return base64encodedString;
		 	       }
					else if(list.getClassListB()!=null){
						 for(Object obj1:list.getClassListB()){
							 Row row = sheet.createRow(rowNum++);
							 row.createCell(0).setCellValue(((ClassB) obj1).getRollNo());
							 row.createCell(1).setCellValue(((ClassB) obj1).getName());	
								
						 }
						 for(int i = 0; i < columns.length; i++) {
				 	            sheet.autoSizeColumn(i);
				 	        }
						 
						 FileOutputStream fileOut = new FileOutputStream("ClassB.xlsx");
				 	        workbook.write(fileOut);
				 	        fileOut.close();
				 	        workbook.close();
				 	       String base64encodedString= dao.fetching("D:/eclipse_neon/StudentInfo.xlsx");
				 	       return base64encodedString;
					}
					else if(list.getClassListC()!=null){
						for(Object obj3:list.getClassListC()){ 
							  Row row = sheet.createRow(rowNum++);
							 row.createCell(0).setCellValue(((ClassC) obj3).getRollNo());
							 row.createCell(1).setCellValue(((ClassC) obj3).getName());
						 }
						for(int i = 0; i < columns.length; i++) {
			 	            sheet.autoSizeColumn(i);
			 	        }
						
						FileOutputStream fileOut = new FileOutputStream("ClassC.xlsx");
			 	        workbook.write(fileOut);
			 	        fileOut.close();
			 	        workbook.close();
			 	       String base64encodedString= dao.fetching("D:/eclipse_neon/StudentInfo.xlsx");
			 	       return base64encodedString;
					}
				return "error";
		 	        
		 	        
		 	        
		 	       /* for(ClassA info: classA) {
		 	        	
		 	            Row row = sheet.createRow(rowNum++);

		 	            row.createCell(0).setCellValue(info.getRollNo());
		 	            System.out.println(info.getRollNo());
		 	            row.createCell(1).setCellValue(info.getName());
		 	            
		 	         a++;
		 	           
		 	        }*/

		 	        // Resize all columns to fit the content size
		 	       
		 	    }
		 	 
	 
	}





/*student.add(studentInfo);

public void main(StudentInfo studentInfo) throws IOException, InvalidFormatException {

List<StudentInfo> student =  new ArrayList<StudentInfo>();
student.add(studentInfo);
String[] columns = {"rollNo", "name", "english", "maths", "science",
		 "totalMarks", "percentage"};


	        // Create a Workbook
	 Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

      CreationHelper helps us create instances of various things like DataFormat, 
          Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way 
       CreationHelper createHelper = workbook.getCreationHelper();

       // Create a Sheet
       Sheet sheet = workbook.createSheet("student");

       // Create a Font for styling header cells
       Font headerFont = workbook.createFont();
       headerFont.setBold(true);
       headerFont.setFontHeightInPoints((short) 14);
       headerFont.setColor(IndexedColors.RED.getIndex());

       // Create a CellStyle with the font
       CellStyle headerCellStyle = workbook.createCellStyle();
       headerCellStyle.setFont(headerFont);

       // Create a Row
       Row headerRow = sheet.createRow(0);

       // Create cells
       for(int i = 0; i < columns.length; i++) {
           Cell cell = headerRow.createCell(i);
           cell.setCellValue(columns[i]);
           cell.setCellStyle(headerCellStyle);
       }
       int rowNum = 1;
       for(StudentInfo info: student) {
       	 Row row = sheet.createRow(rowNum++);

     row.createCell(0).setCellValue(info.getRollNo());
     System.out.println("rollNo :"+info.getRollNo());
     row.createCell(1).setCellValue(info.getName());
     System.out.println("rollNo :"+info.getName());
     row.createCell(2).setCellValue(info.getEnglish());
     System.out.println("rollNo :"+info.getEnglish());
     row.createCell(3).setCellValue(info.getMaths());
     System.out.println("rollNo :"+info.getMaths());
     row.createCell(4).setCellValue(info.getScience());
     System.out.println("rollNo :"+info.getScience());
     row.createCell(5).setCellValue(info.getTotalMarks());
     System.err.println("rollNo :"+info.getTotalMarks());
     row.createCell(6).setCellValue(info.getPercentage());
     System.err.println("rollNo :"+info.getPercentage());             
       }
    // Resize all columns to fit the content size
       for(int i = 0; i < columns.length; i++) {
           sheet.autoSizeColumn(i);
       }
       // Write the output to a file
       FileOutputStream fileOut = new FileOutputStream("poi-generated-file.xlsx");
       workbook.write(fileOut);
       fileOut.close();

     // Closing the workbook
       workbook.close(); 	
}

*/