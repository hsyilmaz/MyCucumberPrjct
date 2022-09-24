package _JDBC.Gun2;

import _JDBC.JDBCParent;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class _03_Soru extends JDBCParent {
    ////Soru :  Actor tablsosundaki tüm verileri yeni excel e yazdırınız.
    @Test
    public void test1() {
        ArrayList<String> rsList = new ArrayList<>();
        ArrayList<String> rsmdList = new ArrayList<>();
        try {
            ResultSet rs = statement.executeQuery("select * from actor");
            ResultSetMetaData rsmd = rs.getMetaData();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                rsmdList.add(rsmd.getColumnName(i));
            }
            while (rs.next()) {
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    rsList.add(rs.getString(i));
                }
            }
            rs.last();
            writeExcel(rs.getRow(), rsmd.getColumnCount(), rsList, rsmdList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void writeExcel(int Rn, int Cn, ArrayList<String> rsList, ArrayList<String> rsmdList) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet1");

        Row row = sheet.createRow(0);
        int j = 0;
        for (String e : rsmdList)
            row.createCell(j++).setCellValue(e);

        j = 1;
        int count = 0;
        for (int i = 0; i < Rn; i++) {
            row = sheet.createRow(j++);
            for (int k = 0; k < Cn; k++)
                row.createCell(k).setCellValue(rsList.get(count++));
        }

        try {
            FileOutputStream outputStream = new FileOutputStream("src/test/java/ApachePOI/resource/NewExcel.xlsx");
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
