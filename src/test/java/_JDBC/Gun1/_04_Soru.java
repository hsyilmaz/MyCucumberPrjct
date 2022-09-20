package _JDBC.Gun1;
import _JDBC.JDBCParent;
import org.testng.annotations.Test;
import java.sql.ResultSet;
import java.sql.SQLException;

public class _04_Soru extends JDBCParent {

    // city tablosundaki tüm kayıtları next ile yazdırınız
    // city tablosundaki tüm kayıtları absolute ile yazdırınız
    // city tablosundaki tüm kayıtları relative ile yazdırınız.

    @Test
    private void test1() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from city");
        for (int i = 1; i < 601; i++) {
            rs.next();
            String city = rs.getString("city");
            System.out.println("city = " + city);
        }
    }

    @Test
    private void test2() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from city");
        for (int i = 1; i < 601; i++) {
            rs.absolute(i);
            String city = rs.getString("city");
            System.out.println("city = " + city);
        }

    }
    @Test
    public void test4() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from city");
        int count=0;
        while(rs.next()){
            System.out.print(rs.getString(1)+" ");
            System.out.print(rs.getString(2)+" ");
            System.out.println(rs.getString(3));
            count++;
        }
        System.out.println("count = " + count);
    }
    @Test
    public void test5() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from city");
        int count=1;
        while(rs.absolute(count)){
            System.out.println(rs.getString(2));
            count++;
        }
        System.out.println("count = " + count);
    }
    @Test
    public void test6() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from city");
        int count=0;
        while(rs.relative(1)){
            System.out.println(rs.getString(2));
            count++;
        }
        System.out.println("count = " + count);
    }


}

