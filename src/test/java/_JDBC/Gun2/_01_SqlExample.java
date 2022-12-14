package _JDBC.Gun2;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _01_SqlExample extends JDBCParent {
    // last, first, getRow, getInd, getDouble

    @Test
    public void test1() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from city");
        rs.last();  // son satir a gider

        String id = rs.getString(1); // city_id
        System.out.println("id = " + id);

        int idInt = rs.getInt(1);
        System.out.println("idInt = " + idInt);

        String name = rs.getString(2);
        System.out.println("name = " + name);

        // int nameInt=rs.getInt(2);
        // System.out.println("nameInt = " + nameInt);
        // tipi uygun olan dönüşümle hepsini String olarak alabiliriz.
        // ancak tipi uygun olmayan isimler , int olarak alınmaz

        int kacinciSatir=rs.getRow();
        System.out.println("kacinciSatir = " + kacinciSatir);
        // dolayısıyla bir sorgunun sonucunda kaç satır geldiğini
        // rs.last() dedikten sonra rs.getRow() ile alabilirim.

        rs.first();  // ilk satira gider.

    }
}
