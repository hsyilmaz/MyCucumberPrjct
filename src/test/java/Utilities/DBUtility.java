package Utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtility {

    private static Connection connection;
    private static Statement statement;

    private static void DBConnectionOpen() {
        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila"; //hotstname,port,db (user db)
        String username = "root"; //username
        String password = "'\"-LhCB'.%k[4S]z"; // password

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private static void DBConnectionClose() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
//        List<List<String>> table =
        getListData("select * from actor");

    }
    public static List<List<String>> getListData(String query){
        List<List<String>>table = new ArrayList<>();
        DBConnectionOpen();

        try {
            ResultSet rs = statement.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();

            while (rs.next())
            {
                List<String> satir=new ArrayList<>();
                for(int i=1; i<= rsmd.getColumnCount() ;i++)
                {
                    satir.add(rs.getString(i));
                }

                table.add(satir);
            }

        } catch (Exception ex) {
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }

        DBConnectionClose();
        return table;
    }
}


