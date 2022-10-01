package _JDBC.Gun1;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _05_Trial extends JDBCParent {
    // city tablosundaki tüm kayıtları next ile yazdırınız
    // city tablosundaki tüm kayıtları absolute ile yazdırınız
    // city tablosundaki tüm kayıtları relative ile yazdırınız.

    @Test
    private void test1() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from city");
        ResultSetMetaData rsmd = rs.getMetaData();

        for(int i=1; i<= rsmd.getColumnCount(); i++)
            System.out.printf("%-15s",rsmd.getColumnName(i));
        System.out.println();

        while (rs.next()) {
            for (int i = 1; i <= rsmd.getColumnCount(); i++)
                System.out.printf("%-15s",rs.getString(i));
            System.out.println();
        }
    }

    @Test
    private void test2() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from city");
        ResultSetMetaData rsmd = rs.getMetaData();

        for(int i=1; i<= rsmd.getColumnCount(); i++)
            System.out.printf("%-15s",rsmd.getColumnName(i));
        System.out.println();

        int count = 1;
        while (rs.absolute(count++)) {
            for (int i = 1; i <= rsmd.getColumnCount(); i++)
                System.out.printf("%-15s",rs.getString(i));
            System.out.println();
        }
    }

    @Test
    private void test3() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from city");
        ResultSetMetaData rsmd = rs.getMetaData();

        for(int i=1; i<= rsmd.getColumnCount(); i++)
            System.out.printf("%-15s",rsmd.getColumnName(i));
        System.out.println();

        while (rs.relative(1)) {
            for (int i = 1; i <= rsmd.getColumnCount(); i++)
                System.out.printf("%-15s",rs.getString(i));
            System.out.println();
        }
    }
}
