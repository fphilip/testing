package houseware.learn.testing.dbunit;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.sql.SQLException;

import static org.junit.Assert.assertTrue;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DBUnitInmutableDBTest extends AbstractDBUnitTest{

    @Test
    public void A_test_delete() throws SQLException {
        assertTrue(TableUtils.totalRows(this.jdbcConnection) == 2);

        TableUtils.deleteById(this.jdbcConnection, 2);

        assertTrue(TableUtils.totalRows(this.jdbcConnection) == 1);
    }

    @Test
    public void B_test_inmutable() throws SQLException {
        assertTrue(TableUtils.totalRows(this.jdbcConnection) == 2);
    }

}
