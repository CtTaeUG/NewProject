package Utilities;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtility2 {

    private static Connection connection;
    protected static Statement statement;


    protected static void DBConnectionOpen(){

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

    protected static void DBConnectionClose(){

        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        List<List<String>> tablo = getListData("select * from actor");
        for(List<String> satir : tablo){
            System.out.println("satir = " + satir);
        }
    }

    public static List<List<String>> getListData (String sorgu) {
        List<List<String>> tablo = new ArrayList<>();
        // db den bütün satırları ve sütünları okuyup bu liste atacagım

        DBConnectionOpen();

        try {
            //1 - sorguyu çalıştır
            ResultSet resultSet = statement.executeQuery(sorgu);

            //2- bütün satırları ve o satırlardaki sutunları oku tabloya ekle

            int columnSayisi = resultSet.getMetaData().getColumnCount();

            while (resultSet.next()){
                List<String> satir = new ArrayList<>();
                for (int i = 1; i <= columnSayisi ; i++) {
                    satir.add(resultSet.getString(i));
                }
                tablo.add(satir);
            }

        } catch (Exception ex) {
            System.out.println("ex = " + ex.getMessage());
        }



        DBConnectionClose();

        return tablo;
    }

}
