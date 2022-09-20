package ApachePOI;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class _10_Mentoring2 {
    /**
     * Soru 1:
     * Çarpım tablosunu excele yazdırınız.
     * 1 x 1 = 1 şeklinde işaretleri de yazdırınız.
     * sıfırdan excel oluşturarak.
     * her bir onluktan sonra 1 kolon boşluk bırakarak yan yana
     */
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet2");

        int sayac = 0;
        for (int k = 1; k < 11; k++) {
            Row satir = sheet.createRow(k);
            for (int i = 2; i < 11; i++) {
                satir.createCell(sayac).setCellValue(i);
                satir.createCell(sayac + 1).setCellValue("X");
                satir.createCell(sayac + 2).setCellValue(k);
                satir.createCell(sayac + 3).setCellValue("=");
                satir.createCell(sayac + 4).setCellValue(k * i);
                sayac += 6;
            }
            sayac = 0;

        }
        String newExcelPath = "src/test/java/ApachePOI/resource/Mentoring.xlsx";
        FileOutputStream outputStream = new FileOutputStream(newExcelPath);
        workbook.write(outputStream);
        workbook.close();
//        outputStream.close(); no need to write!??
        System.out.println("işlem tamamlandı");
    }
}
