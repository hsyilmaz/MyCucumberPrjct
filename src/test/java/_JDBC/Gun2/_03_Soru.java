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
import java.util.List;

public class _03_Soru extends JDBCParent {
    ////Soru :  Actor tablsosundaki tüm verileri yeni excel e yazdırınız.
    @Test
    public void test1() {
        List<List<String>> rsTable = new ArrayList<>();
        List<String> rsmdList = new ArrayList<>();
        try {
            ResultSet rs = statement.executeQuery("select * from actor");
            ResultSetMetaData rsmd = rs.getMetaData();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                rsmdList.add(rsmd.getColumnName(i));
            }
            while (rs.next()) {
                List<String>rsRow = new ArrayList<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    rsRow.add(rs.getString(i));
                }
                rsTable.add(rsRow);
            }
            rs.last();

        writeExcel(rs.getRow(), rsmd.getColumnCount(), rsTable, rsmdList);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void writeExcel(int rN, int cN, List<List<String>> rsTable, List<String> rsmdList) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet1");

        Row row = sheet.createRow(0);
        int j = 0;
        for (String e : rsmdList)
            row.createCell(j++).setCellValue(e);
        j=1;
            for (int c=0; c<rN; c++){
                row = sheet.createRow(j++);
                for (int i=0; i<cN; i++)
                    row.createCell(i).setCellValue(rsTable.get(c).get(i));
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

