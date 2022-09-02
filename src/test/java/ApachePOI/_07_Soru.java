package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class _07_Soru {
    /**
      Bir önceki soruda kullanıcıdan bu sefer sütun numarası
      isteyiniz ve o sütundaki bütün bilgileri yazdırınız
     */
    public static void main(String[] args) {
        System.out.println("istenen sutun=");
        Scanner oku = new Scanner(System.in);
        int column = oku.nextInt();

        System.out.println(bul(column));
    }
    public static String bul(int column){
        String donecek="";
        String path="src/test/java/ApachePOI/resource/LoginData.xlsx";

        Workbook workbook;
        FileInputStream inputStream;

        try {
            inputStream = new FileInputStream(path);
            workbook = WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Sheet sheet = workbook.getSheetAt(0);  // .getSheet("Login");

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            if(sheet.getRow(i).getPhysicalNumberOfCells()>column)
                donecek +=sheet.getRow(i).getCell(column)+"\n";
        }
        return donecek;



    }
}
