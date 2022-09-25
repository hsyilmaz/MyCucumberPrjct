package ApachePOI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;

public class _09_NewExcelWrite {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("sayfa1");

        Row newR = sheet.createRow(0);
        Cell newC = newR.createCell(0);
        newC.setCellValue("Merhaba dunya");

        for (int i = 1; i < 10; i++) {
            newR.createCell(i).setCellValue(i);
        }
        String newExcelPath = "src/test/java/ApachePOI/resource/NewExcel.xlsx";
        FileOutputStream outputStream = new FileOutputStream(newExcelPath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        System.out.println("islem tamam");  // Gun2 soru 3 de buraya gonderildi/yazdirildi.

    }
}
