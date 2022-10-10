package Utilities;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.sql.*;
import java.util.ArrayList;

public class DBUtility {

    private static Connection connection;
    protected static Statement statement;

    @BeforeTest
    public static void DBConnectionOpen(){

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
    public static void DBConnectionClose(){

        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<String>> tablo = getListData("select * from actor");
    }

    public static ArrayList<ArrayList<String>> getListData(String query) {
        ArrayList<ArrayList<String>> tablo = new ArrayList<>();
        DBConnectionOpen();

        try {
            ResultSet resultSet = statement.executeQuery("select * from actor");

            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                System.out.printf("%-20s", resultSetMetaData.getColumnName(i));
            }

            System.out.println();

            while (resultSet.next()) {

                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                    System.out.printf("%-20s", resultSet.getString(i));

                }
                System.out.println();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return tablo;
    }

}
