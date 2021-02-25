package com.cybertek.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test; //!!!

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelRead {

    // In this test we will be reading from excel file

    @Test
    public void excel_read_test() throws IOException {

        String path = "SampleData.xlsx"; //right click, Copy Path from Content Root

        //To be able to read from excel file we need to load the file
        FileInputStream fileInputStream = new FileInputStream(path);

        //workbook > sheet > row > cell

        //We created 'workbook instance and loaded with "SampleData" file
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        //Create the 'sheet and pass the name of the sheet we want to work on
        XSSFSheet sheet = workbook.getSheet("Employees");

        //row > sheet                                                                     //start w/0
        System.out.println(sheet.getRow(1).getCell(0));

        //Print out "Singer" from Excel sheet
        System.out.println(sheet.getRow(3).getCell(2));


        //Returns the count of used cells only
        //If there are cells not used they will not be counted.
        //Starts with 1
        int usedRows = sheet.getPhysicalNumberOfRows();

        //Returns the count from top to bottom
        //Even counts if there are empty cells
        //this starts counting from 0
        int lastUsedRow = sheet.getLastRowNum();


        //TODO: 1-Create a logic to print out NEENA`s name dynamically

        for (int rowNum = 0; rowNum < usedRows; rowNum++) {

//            XSSFCell currentCell = sheet.getRow(rowNum).getCell(0);
//            if (currentCell.toString().equals("Neena")){
//                System.out.println("currentCell = " + currentCell);
//            }

            //or

//            String name = ""+sheet.getRow(rowNum).getCell(0);
//            if(name.equals("Neena")){
//                System.out.println("Current Cell = "+name);
//            }

            //    sheet.getRow(4).getCell(0)
            //               dynamic: rowNum    static: 0
            //           cell                                           String
            if (sheet.getRow(rowNum).getCell(0).toString().equals("Neena")) {
                System.out.println("CurrentCell = " + sheet.getRow(rowNum).getCell(0));
            }
        }

        // TODO: 2- Create a logic to print out Adam Sandler last name dynamically

        for (int rowNum = 0; rowNum < usedRows; rowNum++) {
            if (sheet.getRow(rowNum).getCell(1).toString().equals("Sandler")) {
                System.out.println("Adam`s last name = " + sheet.getRow(rowNum).getCell(1));
            }

        }


        //TODO: 3-Create a logic to print out Steve King`s job id dynamically
        // Check for last name, if it`s King, print out job_to

        for (int rowNum = 0; rowNum < usedRows; rowNum++) {

            if (sheet.getRow(rowNum).getCell(1).toString().equals("King")) {
                System.out.println("Job_ID = " + sheet.getRow(rowNum).getCell(2));
            }
        }


    }
}
