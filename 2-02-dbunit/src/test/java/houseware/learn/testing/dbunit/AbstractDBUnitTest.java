package houseware.learn.testing.dbunit;

import org.junit.After;
import org.junit.Before;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;

public class AbstractDBUnitTest {

    protected Connection jdbcConnection;

    @Before
    public void createDB(){
        try {
            this.jdbcConnection = DriverManager.getConnection("jdbc:derby:memory:testing;create=true");
            jdbcConnection.createStatement().execute("create table usuario( " +
                    "id_usuario INT PRIMARY KEY, " +
                    "nombre varchar(20), " +
                    "apellidos varchar(20), " +
                    "password varchar(20) )"
            );
            jdbcConnection.createStatement().execute("insert into usuario values " +
                    "(1, 'Pedro', 'Martinez', 'qwerty') ," +
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
