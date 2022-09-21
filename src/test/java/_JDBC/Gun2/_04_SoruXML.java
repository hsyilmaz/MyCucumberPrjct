package _JDBC.Gun2;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _04_SoruXML extends JDBCParent {
    /*Q : getTable için yaptığını örneğin aynısını bir XML filedan sorguyu parametre
    olarak göndererek bir Test için yapınız.*/

    @Test
    public void test1() throws SQLException {
        // language tablosundaki tüm satırları ve tüm sütunları yazdırınız.
        ResultSet rs = statement.executeQuery("select * from language");
        ResultSetMetaData rsmd = rs.getMetaData();

        for (int i = 1; i <= rsmd.getColumnCount() ; i++)
            System.out.printf("%-20s",rsmd.getColumnName(i));
        System.out.println();

        while(rs.next()){
            for (int i = 1; i <= rsmd.getColumnCount(); i++)
                System.out.printf("%-20s",rs.getString(i));
            System.out.println();
        }
    }

}
