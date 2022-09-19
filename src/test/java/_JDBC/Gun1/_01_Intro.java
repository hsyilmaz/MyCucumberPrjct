package _JDBC.Gun1;

import org.testng.annotations.Test;

import java.sql.*;

public class _01_Intro {

    @Test
    public void test() throws SQLException {
        String url="jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila"; //hotstname,port,db (user db)
        String username="root"; //username
        String password="'\"-LhCB'.%k[4S]z"; // password

        Connection connection = DriverManager.getConnection(url, username, password); // connection

        Statement statement = connection.createStatement();  // sorgulari calistirmak icin page acildi

        ResultSet Rs = statement.executeQuery("select * from actor"); //query result is ready but waiting in DB

        Rs.next();  // Query Result
        String firstName = Rs.getString("first_name");
        String lastName = Rs.getString("last_name");

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

        //2.row
        Rs.next();
        firstName = Rs.getString("first_name");
        lastName = Rs.getString("last_name");

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

        connection.close();

    }

}
    /**
    JDBC Nedir ?
    veritabanlarını automation yapmama yardımcı oluyor.
    sorgularımı gönderiyorum, gelen sonuçlarla , UI daki
    gözüken sonuçları karşılaştırıyorum.

    JDBC yi nasıl kullanırsın ?
    URL, username ve password vererek bir connection oluştururm.
    Bu connection üzerinde satement oluşturarak, sorgularımı çalıştırırım.
    Sonuçları ResultSet atarak kullanırım.

    1- connection : önce bağlantı ayarlarını yaptık
       username, password, url(port,db,bağlantı yolu)

    2- Sorgu çalıştırma yolu : sorgularımı çalıştırmak için bir sayfa (yol) açtım.

    3- Sonuçların alınması : sorgunun çalışması sonucu veritabanından gelen bilgiler.*/
