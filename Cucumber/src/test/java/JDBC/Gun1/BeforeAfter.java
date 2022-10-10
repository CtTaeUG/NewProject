package JDBC.Gun1;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;

public class BeforeAfter {

    private static Connection connection;
    public static Statement statement;

    @BeforeTest
    public void DBConnectionOpen(){

        String url="jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila"; //hotstname,port,db adını (user db)
        String username="root"; //username
        String password="'\"-LhCB'.%k[4S]z"; // password

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement(); // sorguları çalıştırmak için page açıldı.
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
        ResultSet resultSet = statement.executeQuery("select * from language");

        resultSet.next();
        String dilAdi = resultSet.getString("name");
        System.out.println("dilAdi = " + dilAdi);

        resultSet.next();
        dilAdi = resultSet.getString("name");
        System.out.println("dilAdi = " + dilAdi);

        resultSet.next();
        dilAdi = resultSet.getString("name");
        System.out.println("dilAdi = " + dilAdi);




    }

    @Test
    public void test2() throws SQLException {

        ResultSet resultSet = statement.executeQuery("select * from language");

        resultSet.next();
        String dilAdi = resultSet.getString(2);
        System.out.println("dilAdi = " + dilAdi);

        resultSet.next();
        dilAdi = resultSet.getString(2);
        System.out.println("dilAdi = " + dilAdi);

        resultSet.next();
        dilAdi = resultSet.getString(2);
        System.out.println("dilAdi = " + dilAdi);

    }

    @Test
    public void test3() throws SQLException {

        ResultSet resultSet = statement.executeQuery("select * from language");

        resultSet.next();
        String dilAdi = resultSet.getString(2);
        System.out.println("dilAdi = " + dilAdi);

        resultSet.next();
        dilAdi = resultSet.getString(2);
        System.out.println("dilAdi = " + dilAdi);

        resultSet.previous();
        dilAdi = resultSet.getString(2);
        System.out.println("dilAdi = " + dilAdi);

    }


}
