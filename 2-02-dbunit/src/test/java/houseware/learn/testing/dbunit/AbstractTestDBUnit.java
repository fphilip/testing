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
        this.jdbcConnection = TableUtils.createDB();
    }

    @After
    public void closeConnection() throws SQLException {
        TableUtils.closeConnection();
    }
}
