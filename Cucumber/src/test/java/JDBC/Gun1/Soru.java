package JDBC.Gun1;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Soru extends JDBCParent{

    // city tablosundaki tüm kayıtları yazdırınız
    // city tablosundaki tümkayıtları absolute ile yazdırınız.
    // city tablosundaki tüm kayıtları relative ile yazdırınız.

    @Test
    public void test1() throws SQLException {
        ResultSet resultSet = statement.executeQuery("select * from city");

        int count = 0;
        while (resultSet.next()) {
            System.out.println(resultSet.getString(2));
            count++;
        }
        System.out.println("count = " + count);
    }

    @Test
    public void test2() throws SQLException {
        ResultSet resultSet= statement.executeQuery("select * from city");

        int count = 1;
        while (resultSet.absolute(count)){
            System.out.println(resultSet.getString(2));
            count++;
        }
        System.out.println("count = " + count);
    }

    @Test
    public void test3() throws SQLException {
        ResultSet resultSet= statement.executeQuery("select * from city");

        int count = 0;
        while (resultSet.relative(1)){
            System.out.println(resultSet.getString(2));
            count++;
        }
        System.out.println("count = " + count);
    }
}
