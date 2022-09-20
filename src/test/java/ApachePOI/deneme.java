package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class deneme {
    public static void main(String[] args) throws IOException {
        String path = "src/test/java/ApachePOI/resource/WriteInTheExcelFile.xlsx";
        FileInputStream inputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheet("Sheet2");

        int rowcount = 1;
        for (int i = 2; i <10; i++) {
            for (int j = 1; j <11; j++) {

                Row R = sheet.createRow(rowcount++);

                Cell c1 = R.createCell(1);
                c1.setCellValue(i);

                Cell c2 = R.createCell(2);
                c2.setCellValue("X");

                Cell c3 = R.createCell(3);
                c3.setCellValue(j);

                Cell c4 = R.createCell(4);
                c4.setCellValue("=");

                Cell c5 = R.createCell(5);
                c5.setCellValue(i*j);
            }
        }
        inputStream.close(); /// okuma kapatilip yazma acilinca bunu yapmak lazim ama etkisi yok gibi!!???
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();  //kapatinca da her sey iyi gozukuyor??!!
    }
}
