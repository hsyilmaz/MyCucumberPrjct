package _JDBC.Gun2;

import Utilities.ExcelUtility;
import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

public class _04_Soru extends JDBCParent {
//Soru : getTable için yaptığının aynısını, bir Excel sorgusunu parametre olarak göndererek bir Test için yapınız.
    @Test
    public void test1() {
        List<List<String>> Table=
                ExcelUtility.getListData("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx", "query", 1);
        for (List<String> Rw : Table)
        {
            getTable(Rw.get(0));
        }
    }

    public void getTable(String query) {
        try {
            ResultSet rs = statement.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();

            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.printf("%-15s", rsmd.getColumnName(i));
            }
            System.out.println();

            while (rs.next()) {
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    System.out.printf("%-15s", rs.getString(i));
                }
                System.out.println();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
