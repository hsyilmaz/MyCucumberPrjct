package _JDBC.Gun1;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;

public class _02_BeforeAfter {
    private static Connection connection;
    private static Statement statement;

    @BeforeTest
    public void DBConnectionOpen(){
        String url="jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila"; //hotstname,port,db (user db)
        String username="root"; //username
        String password="'\"-LhCB'.%k[4S]z"; // password

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @AfterTest
    public void DBConnectionClose(){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test1() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from language");

        rs.next();
        String langName = rs.getString("name");
        System.out.println("langName = " + langName);

        rs.next();
        langName = rs.getString("name");
        System.out.println("langName = " + langName);

        rs.next();
        langName = rs.getString("name");
        System.out.println("langName = " + langName);

    }
    @Test
    public void test2() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from language");

        rs.next();
        String langName = rs.getString(2);
        System.out.println("langName = " + langName);

        rs.next();
        langName = rs.getString(2);
        System.out.println("langName = " + langName);

        rs.next();
        langName = rs.getString(2);
        System.out.println("langName = " + langName);

    }
    @Test
    public void test3() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from language");

        rs.next();
        String langName = rs.getString(2);
        System.out.println("langName = " + langName);

        rs.next();
        langName = rs.getString(2);
        System.out.println("langName = " + langName);

        rs.previous();
        langName = rs.getString(2);
        System.out.println("langName = " + langName);

    }

}
