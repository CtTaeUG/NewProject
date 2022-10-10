package JDBC.Gun1;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlExample extends JDBCParent {
    //last, first, getRow, getInd, getDouble

    @Test
    public void test1() throws SQLException {
        ResultSet resultSet = statement.executeQuery("select city_id, city, country_id from city");

        resultSet.last(); //sonuncu row a gider

        String id = resultSet.getString(1);
        System.out.println("id = " + id);

        int idInt = resultSet.getInt(1);
        System.out.println("idInt = " + idInt);

        // tipleri dönüşüyorsa otomatik donuşturur. tip uygunsa hem string hem int alırsın

        int kacinciSatir = resultSet.getRow();
        //bir sorgunun sonucunda kaç satır geşdiğini
        // rs.last() dan sonra rs.getRow() ile alabilirsin.

        resultSet.first();



    }
}
