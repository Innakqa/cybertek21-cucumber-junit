package com.cybertek.tests;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWrites {

    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFRow row;
    XSSFCell cell;

    @Test
    public void excel_write() throws IOException {

        String path = "SampleData.xlsx";

        FileInputStream fileInputStream = new FileInputStream(path);

        //workbook > sheet > row > cell

        //Loading excel workbook into class
        workbook = new XSSFWorkbook(fileInputStream);

        //open the sheet using workbook object
        sheet = workbook.getSheet("Employees");

        //kings row
        row = sheet.getRow(1);

        //kings cell
        cell = row.getCell(1);

        //ex: Storing Adams cell if we were to be reusing it
        XSSFCell adamsCell = sheet.getRow(2).getCell(0);

        System.out.println("Before = " + adamsCell);

//to change a value of existing cell
        adamsCell.setCellValue("Madam"); //passed

        System.out.println("After = "+adamsCell);

        //=======================================================================================================

        //TODO: Change Stevens name to Tom

        //static wau of the solution:   (create a cell and pass it into that cell)
//        XSSFCell stevensCell = sheet.getRow(1).getCell(0);
//
//        stevensCell.setCellValue("Tom");
//        System.out.println("stevensCell = " + stevensCell);


        //dynamic way: make rows dynamic but cell will be the same

        for (int rowNum = 0; rowNum < sheet.getPhysicalNumberOfRows(); rowNum++) {

            if (sheet.getRow(rowNum).getCell(0).toString().equals("Steven")){

                sheet.getRow(rowNum).getCell(0).setCellValue("Tom");
            }


        }


//if we wanna write into an empty cell, we`ll need to create a cell first and write later







        //=================================================== stays in the end =========================================
        //Load the file to outputStream
        FileOutputStream fileOutputStream = new FileOutputStream(path); //to conclude this
        //Write to the file using workbook object
        workbook.write(fileOutputStream);

        fileInputStream.close();
        fileOutputStream.close();
        workbook.close(); //if we dont close it, Garbage will close/collect later

    }

}
