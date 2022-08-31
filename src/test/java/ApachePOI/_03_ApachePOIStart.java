package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException; // daha genel oldugu icin yukaridakini kapsadi ve passive yapti.

public class _03_ApachePOIStart {
    public static void main(String[] args) throws IOException {
        
        //Dosyanin yolu alindi.
        String path="src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";
        
        //Java Dosya okuma islemcisine dosyanin yolunu veriyoruz:
        // Boylece program ile dosya arasinda baglanti olustu.
        FileInputStream dosyaOkumaBaglantisi = new FileInputStream(path);
        
        Workbook calismaKitabi = WorkbookFactory.create(dosyaOkumaBaglantisi);
        
        Sheet calismaSyfasi  = calismaKitabi.getSheet("Sheet1");
        
        Row satir = calismaSyfasi.getRow(0);
        
        Cell hucre = satir.getCell(0);

        System.out.println("hucre = " + hucre);
        
        
        
        
    }
}
