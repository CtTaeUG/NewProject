package JDBC.Gun1;


import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AbsoluteRelative extends JDBCParent {

    @Test
    private void test1() throws SQLException {
        //next(): bir sonraki row
        //pevious(): bir önceki row
        //ablosute(4): baştan itibaren 4.ROW a gider, direkt verine ROM a gider
        //relative(4): bulunduğu noktadan 4 sonraki ROW a gider.

        ResultSet resultSet = statement.executeQuery("select * from film");

        resultSet.absolute(10); //10. satira git
        String title = resultSet.getString("title");
        System.out.println("title = " + title);

        resultSet.absolute(15); //15. satira git
        title = resultSet.getString("title");
        System.out.println("title = " + title);

        resultSet.absolute(-15); //sondan 15. satıra gider
        title = resultSet.getString("title");
        System.out.println("title = " + title);

        resultSet.relative(5); // esn son bulundugun yerden 5 satır
        title = resultSet.getString("title");
        System.out.println("title = " + title);

        resultSet.relative(-5); // esn son bulundugun yerden 5 satır
        title = resultSet.getString("title");
        System.out.println("title = " + title);

    }

}
