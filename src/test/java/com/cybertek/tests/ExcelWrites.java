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

        //Load the filel to outputStream
        FileOutputStream fileOutputStream = new FileOutputStream(path); //to conclude this
        //Write to the file using workbook object
        workbook.write(fileOutputStream);

        fileInputStream.close();
        fileOutputStream.close();
        workbook.close(); //if we dont close it, Garbage will close/collect later

    }

}
