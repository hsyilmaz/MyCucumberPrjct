package Utilities;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelUtilityTrial {
    public static ArrayList<ArrayList<String>>getListData(String path, String sheetName,int columnCount){

        ArrayList<ArrayList<String>> table = new ArrayList<>();

        Workbook workbook;
        try {
            FileInputStream inputStream=new FileInputStream(path);
            workbook= WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Sheet sheet = workbook.getSheet(sheetName);
        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            ArrayList<String>rowData = new ArrayList<>();
            for (int j = 0; j < columnCount; j++) {
                rowData.add(sheet.getRow(i).getCell(j).toString());
            }
            table.add(rowData);
        }
        return table;
    }


}