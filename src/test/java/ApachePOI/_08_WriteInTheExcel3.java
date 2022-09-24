package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _08_WriteInTheExcel3 {
    public static void main(String[] args) throws IOException {
        String path = "src/test/java/ApachePOI/resource/WriteInTheExcelFile.xlsx";
        FileInputStream inputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheet("Sheet3");  // getSheetAt(2);
        int c=1;
        for (int k=1;k<11; k++) {
            Row rw = sheet.createRow(k);
            for (int i = 2; i < 10; i++) {
                rw.createCell(c++).setCellValue(i);
                rw.createCell(c++).setCellValue("X");
                rw.createCell(c++).setCellValue(k);
                rw.createCell(c++).setCellValue("=");
                rw.createCell(c++).setCellValue(i * k);
                c++;
            }
            c=1;
        }

        // sıra kaydetmeye geldi, bütün bilgiler hafızada buraya kadar, her şey WORKBOOK da
        inputStream.close(); // okuma modunu kapattım, çünkü yazma modunda açmam gerekiyor
                            // Yazma işlemini YAZMA modunda açıp öyle yapacağız.
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

    }
}
