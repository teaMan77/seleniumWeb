package day20;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadingFromExcel {

    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream("D:\\seleniumWeb\\dataset\\AutomationTestSample.xlsx");

        Workbook workbook = new XSSFWorkbook(inputStream);

        //Get the first sheet from the workbook
        Sheet sheet = workbook.getSheetAt(0); //workbook.getSheetName("Sheet1") --> Name is preferred instead of index

        for (Row row:sheet)
        {
            for (Cell cell:row)
            {
                System.out.print(cell.getStringCellValue()+"\t");
            }

            System.out.println();
        }


    }
}
