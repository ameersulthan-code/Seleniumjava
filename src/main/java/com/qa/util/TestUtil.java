package com.qa.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class TestUtil {

    private static final String EXCEL_PATH =
           
    System.getProperty("user.dir")
    + ("/src/main/java/com/qa/testdata/FreelanceqaTestData.xlsx");
   
    @DataProvider(name = "loginData")
    public static Object[][] getLoginData() {

        try (FileInputStream file = new FileInputStream(EXCEL_PATH);
             Workbook workbook = WorkbookFactory.create(file)) {

            Sheet sheet = workbook.getSheet("contacts");

            int rows = sheet.getLastRowNum();
            int columns =3;

            Object[][] data = new Object[rows][columns];

            DataFormatter formatter = new DataFormatter();

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {

                    data[i][j] = formatter.formatCellValue(
                            sheet.getRow(i + 1).getCell(j)
                    );
                }
            }

            return data;

        } catch (IOException e) {
            throw new RuntimeException("Unable to read Excel file", e);
        }
    }
}