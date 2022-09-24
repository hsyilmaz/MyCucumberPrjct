package _JDBC.Gun2;

import Utilities.ExcelUtility;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class _05_Soru {
    @Test
    public void test() {
        String path = "src/test/java/ApachePOI/resource/WriteInTheExcelFile.xlsx";
        Workbook workbook = null;
        try {
            FileInputStream inputStream = new FileInputStream(path);
            workbook = WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Sheet sheet = workbook.getSheet("Sheet4");
        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row = sheet.getRow(i);
            String a = "INSERT INTO exlFile (id,ad,soyad,phone) " +
            "VALUES ('" + row.getCell(0) + "','" + row.getCell(1).toString() + "','" + row.getCell(2).toString() + "','" + row.getCell(3)+"')";
            writeDataBase("z_yilmaz1", a);
        }
    }

    public void writeDataBase(String dbname, String a) {
        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/"+ dbname + "";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            statement.executeUpdate(a);
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

