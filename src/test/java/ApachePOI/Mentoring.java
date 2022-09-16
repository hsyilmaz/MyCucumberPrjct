package ApachePOI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class Mentoring {

    public static void main(String[] args) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("sheet1");

        int rowCount = 0;
        for (int i = 1; i <= 9; i++) {

            for (int j = 1; j <= 9; j++) {

                Row row = sheet.createRow(rowCount++);
                Cell cell1 = row.createCell(0);
                cell1.setCellValue(i);

                Cell cell2 = row.createCell(1);
                cell2.setCellValue(" x ");

                Cell cell3 = row.createCell(2);
                cell3.setCellValue(j);

                Cell cell4 = row.createCell(3);
                cell4.setCellValue(" = ");

                Cell cell5 = row.createCell(4);
                cell5.setCellValue((i) * (j));

            }
        }
        String newExcelPath = "src/test/java/ApachePOI/resource/Mentoring.xlsx";
        FileOutputStream outputStream = new FileOutputStream(newExcelPath);
        workbook.write(outputStream);
        workbook.close();
//        outputStream.close(); no need to write!
    }
}
