package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _08_WriteInTheExcel {
    public static void main(String[] args) throws IOException {
        // Var olan bir EXCEL yazma işlemi
        String path = "src/test/java/ApachePOI/resource/WriteInTheExcelFile.xlsx";
        FileInputStream inputStream = new FileInputStream(path); // okuma modunda açıldı
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheet("Sheet1");

        // HAFIZADA oluşturma ve yazma işlemleri yapılıyor
        Row newR = sheet.createRow(0); // satır oluşturuldu 0.yerde
        Cell newC = newR.createCell(0); // yeni satırda ilk hucre oluşturuldu
        newC.setCellValue("Hello my Friends"); // bilgi yazıldı.

        for (int i = 1; i < 10; i++) {
            newR.createCell(i).setCellValue(i);
        }

        // sıra kaydetmeye geldi, bütün bilgiler hafızada buraya kadar, her şey WORKBOOK da
        inputStream.close(); // okuma modunu kapattım, çünkü yazma modunda açmam gerekiyor


        // Yazma işlemini YAZMA modunda açıp öyle yapacağız.
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();  // hafıza boşaltıldı
        outputStream.close();
        System.out.println("işlem tamam");
    }
}