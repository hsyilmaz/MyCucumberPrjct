package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Verilen Exceldeki password bilgisini bir metoda aracılığı bularak yazdırınız,
 * yani metoda "password" kelimesi gönderilecek, dönen değer password un kendisi olacak.
 * src/test/java/ApachePOI/resources/LoginData.xlsx
 */

public class _05_GetASpecificData {
    public static void main(String[] args) {
        System.out.print("Enter a caption of the table = ");
        Scanner oku= new Scanner(System.in);
        String caption= oku.next();

        System.out.println(find(caption));
    }

    public static String find(String caption)
    {
        String value = "";

        String path="src/test/java/ApachePOI/resource/LoginData.xlsx";
        Workbook workbook;

        try {
            FileInputStream inputStream = new FileInputStream(path);
            workbook= WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Sheet sheet= workbook.getSheetAt(0); // .getSheet("Login");

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row=sheet.getRow(i);
            Cell cell=row.getCell(0);

            if (cell.toString().equalsIgnoreCase(caption))
                for (int j = 1; j < row.getPhysicalNumberOfCells(); j++)
                    value +=  row.getCell(j);
        }

        return value;
    }

}
