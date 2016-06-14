package houseware.learn.testing.dbunit;

import org.junit.After;
import org.junit.Before;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;

public class AbstractTestDBUnit {

    protected Connection jdbcConnection;

    @Before
    public void createDB(){
        try {
            this.jdbcConnection = DriverManager.getConnection("jdbc:derby:memory:testing;create=true");
            jdbcConnection.createStatement().execute("create table users( " +
                    "id INT PRIMARY KEY, " +
                    "first_name varchar(20), " +
                    "last_name varchar(20), " +
                    "password varchar(20) )"
            );
            jdbcConnection.createStatement().execute("insert into users values " +
                    "(1, 'Peter', 'Martinez', 'qwerty') ," +
                    "(2, 'Paco', 'Soria', '12345')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @After
    public void closeConnection() throws SQLException {
        try {
            DriverManager.getConnection("jdbc:derby:memory:testing;drop=true");
        } catch (SQLNonTransientConnectionException e) {
            //DROP DONE
        }

    }
}
