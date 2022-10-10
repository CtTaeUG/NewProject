package JDBC.Gun1;

import org.testng.annotations.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.*;

import static JDBC.Gun1.BeforeAfter.statement;

public class Intro {


    @Test
    public void test1() throws SQLException {

        ResultSet resultSet = statement.executeQuery("select * from actor");

        resultSet.next();

        String firstName = resultSet.getString("first_name");
        String lastName = resultSet.getString("last_name");

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

        resultSet.next();

        firstName = resultSet.getString("first_name");
        lastName = resultSet.getString("last_name");

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);



    }

}
