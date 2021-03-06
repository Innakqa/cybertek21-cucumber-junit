package com.cybertek.tests;

import com.cybertek.pages.GasMileageCalculatorPage;
import com.cybertek.utilities.Driver;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GasMileageTests {

    XSSFWorkbook workbook;
    XSSFSheet sheet;
    //XSSFRow row;
    //XSSFCell cell;
    FileInputStream fileInputStream;
    FileOutputStream fileOutputStream;
    GasMileageCalculatorPage gasMileageCalculatorPage = new GasMileageCalculatorPage();


    @Test
    public void gas_mileage_calculation() throws IOException {

        Driver.getDriver().get("https://www.calculator.net/gas-mileage-calculator.html");

        //Get the path of the file from Content Root
        String path = "src/test/resources/testData/GasMileageTestData.xlsx";

        //loading the file into inputStream object
        fileInputStream = new FileInputStream(path);

        //loading the workbook to the class
        workbook = new XSSFWorkbook(fileInputStream);

        //after everything is set (above)
        //local calculation w our browser

        //opening sheet
        sheet = workbook.getSheet("Sheet1");


        for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {


            XSSFRow currentRow = sheet.getRow(rowNum);

            if (!currentRow.getCell(0).toString().equals("Y")){

                if (currentRow.getCell(6)==null){
                    currentRow.createCell(6);
                }
                currentRow.getCell(6).setCellValue("Skip Requested!");
              continue;
            }

            //=================================================================

            //entering current odometer reading
            //       double current = 123000;

            double current = currentRow.getCell(1).getNumericCellValue();

            //Clearing the input box before entering any data
            gasMileageCalculatorPage.inputCurrentOdometer.clear();


            //we need to pass 'double' into input box
            //  gasMileageCalculatorPage.inputPreviousOdometer.sendKeys(current+""); - not a good practice/cheating
            gasMileageCalculatorPage.inputCurrentOdometer.sendKeys(String.valueOf(current));

            //=================================================================

            //entering previous odometer reading
            //       double previous = 122000;

            double previous = currentRow.getCell(2).getNumericCellValue();

            gasMileageCalculatorPage.inputPreviousOdometer.clear();
            gasMileageCalculatorPage.inputPreviousOdometer.sendKeys(String.valueOf(previous));

            //=================================================================

            //Entering how many gallons of gas used
            //       double gas = 70;

            double gas = currentRow.getCell(3).getNumericCellValue();

            gasMileageCalculatorPage.inputGas.clear();
            gasMileageCalculatorPage.inputGas.sendKeys(String.valueOf(gas));


            //=================================================================

            //click to calculate button
            gasMileageCalculatorPage.calculateButton.click();

            //=================================================================

            //How does a calculation of regular AVG/MPG work
            //(current - previous) / gallons

            double expectedResult = (current - previous) / gas;

            System.out.println("expectedResult = " + expectedResult);


            //actual result --> 14,29 mpg --> split by " " -->{"14.29", "mpg"}
            String[] actualResultArr = gasMileageCalculatorPage.resultInGas.getText().split(" "); // =>  Array of Strings
            System.out.println("actualResultArr = " + actualResultArr[0]);


            //     //Task to round expected result into looking like actual result

            String actual = actualResultArr[0];
            String expected = String.valueOf(expectedResult);

            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
            String formattedExpected = decimalFormat.format(expectedResult);

            System.out.println("formattedExpected = " + formattedExpected);

            //=================================================================
            //PASSING EXPECTED VALUE INTO EXCEL SHEET

            //If the cell is empty, we need to create the cell before being able to pass any data input into it
            if (currentRow.getCell(4) == null) {
                currentRow.createCell(4);
            }

            //Passing the 'formattedExpected' into our Excel sheet "Expected" cell
            currentRow.getCell(4).setCellValue(formattedExpected);

            //=================================================================

            //Passing ACTUAL value into the Excel sheet
            if (currentRow.getCell(5) == null) {
                currentRow.createCell(5);
            }

            currentRow.getCell(5).setCellValue(actual);

            //=================================================================
            //Passing the status into the excel file

            if (currentRow.getCell(6) == null) { //create first before passing the value
                currentRow.createCell(6);
            }

            //=================================================================
            //Comparing actual vs expected & passing the result into the Excel sheet

            if (actual.equals(formattedExpected)) {
                // System.out.println("PASS!");
                currentRow.getCell(6).setCellValue("Pass!");
            } else {
                //System.out.println("FAIL!!!");
                currentRow.getCell(6).setCellValue("FAIL!!");
            }
            //=================================================================
            //Entering the current time test is running that specific line
            if (currentRow.getCell(7) == null) {
                currentRow.createCell(7);
            }

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm:ss a");
            currentRow.getCell(7).setCellValue(LocalDateTime.now().format(dtf));

        }
        //=================================================================

        //We must write into excel file using .write method, otherwise changes will not be applied

        fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

        workbook.close();
        fileInputStream.close();
        fileOutputStream.close();


    }

}
