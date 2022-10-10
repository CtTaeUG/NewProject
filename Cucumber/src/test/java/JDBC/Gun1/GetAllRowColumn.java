package JDBC.Gun1;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class GetAllRowColumn extends JDBCParent {

    @Test
    public void test1() throws SQLException {
        ResultSet resultSet = statement.executeQuery("select * from language");

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        int columnCount = resultSetMetaData.getColumnCount();
        System.out.println("columnCount = " + columnCount);

        for (int i = 1; i <= columnCount; i++) {
            String columnName = resultSetMetaData.getColumnName(i);
            String columnType = resultSetMetaData.getColumnTypeName(i);

            System.out.println("columnName = " + columnName);
            System.out.println("columnType = " + columnType);

        }
    }

    @Test
    public void test2() throws SQLException {
        //language tablosundaki tüm satırları ve tüm sütünları yazdırınız.
        // aynı mysql sonuç akranında olduğu gibi

        ResultSet resultSet = statement.executeQuery("select * from language");

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
            System.out.print(resultSetMetaData.getColumnName(i) + "\t");
        }

        System.out.println();

        while (resultSet.next()) {

            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                System.out.print(resultSet.getString(i) + "\t");

            }
            System.out.println();
        }
    }

    @Test
    public void test3() throws SQLException {
        //language tablosundaki tüm satırları ve tüm sütünları yazdırınız.
        // aynı mysql sonuç akranında olduğu gibi

        ResultSet resultSet = statement.executeQuery("select * from language");

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
    }

    @Test
    public void test4() throws SQLException {
        // actor tablosundaki tüm satırları ve tüm sütünlat yazdırınız.
        // fakat metod kullanınız.

        getTable("select * from actor");
    }

    public void getTable(String query) throws SQLException {

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
    }
}
