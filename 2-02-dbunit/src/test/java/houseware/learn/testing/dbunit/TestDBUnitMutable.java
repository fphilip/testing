package houseware.learn.testing.dbunit;

import org.junit.*;
import org.junit.runners.MethodSorters;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestDBUnitMutable {

    private static Connection jdbcConnection;

    @BeforeClass
    public static void createDB(){
        jdbcConnection = TableUtils.createDB();
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        TableUtils.closeConnection();
    }

    @Test
    public void A_test_delete() throws SQLException {
        assertTrue(TableUtils.totalRows(this.jdbcConnection) == 2);

        TableUtils.deleteById(this.jdbcConnection, 2);

        assertTrue(TableUtils.totalRows(this.jdbcConnection) == 1);
    }

    @Test
    public void B_test_inmutable() throws SQLException {
        assertTrue(TableUtils.totalRows(this.jdbcConnection) == 1);
    }

}
