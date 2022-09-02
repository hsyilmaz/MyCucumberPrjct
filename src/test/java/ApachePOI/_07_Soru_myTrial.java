package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class _07_Soru_myTrial { /**
 Bir önceki soruda kullanıcıdan bu sefer sütun numarası
 isteyiniz ve o sütundaki bütün bilgileri yazdırınız
 */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a column number= ");
        int column = scan.nextInt();

        System.out.println(find(column));
    }
    public static String find(int x){
        String path = "src/test/java/ApachePOI/resource/LoginData.xlsx";
        String columnValue="";

        Workbook workbook=null;
        try {
            FileInputStream inputStream= new FileInputStream(path);
            workbook = WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Sheet sheet = workbook.getSheetAt(0);
        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row = sheet.getRow(i);
            if(row.getPhysicalNumberOfCells()>x)
                columnValue+=row.getCell(x)+"\n";
        }
        return columnValue;
    }

}
