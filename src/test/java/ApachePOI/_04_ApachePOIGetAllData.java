package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class _04_ApachePOIGetAllData {
    public static void main(String[] args) throws IOException {

        String path="src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";

        FileInputStream inputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheet("Sheet1");

        // calisma sayfasındaki toplam satır sayısını veriyor.
        int rowNumber=sheet.getPhysicalNumberOfRows();

        for (int i = 0; i < rowNumber; i++) {

            Row row= sheet.getRow(i); // i.Satır alındı
            // bu satırdaki toplam hücre sayısı alındı.
            int cellNumber = row.getPhysicalNumberOfCells();

            for (int j = 0; j < cellNumber; j++) { // i.satırdaki hucre sayısı kadar dönecek
                Cell cell = row.getCell(j);    // bu satırdaki sıradaki hücreyi aldım.
                System.out.print(cell+" ");
            }

            System.out.println();
        }




    }
}
