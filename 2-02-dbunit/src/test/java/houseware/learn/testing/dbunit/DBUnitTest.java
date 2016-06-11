package houseware.learn.testing.dbunit;


import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;

import org.dbunit.operation.DatabaseOperation;
import org.dbunit.util.fileloader.DataFileLoader;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.*;

import java.io.IOException;
import java.sql.*;

import static org.junit.Assert.assertTrue;


public class DBUnitTest extends AbstractDBUnitTest {

    @Test
    public void loadDB_Insert_xml() throws SQLException, DatabaseUnitException, IOException {

        assertTrue(TableUtils.totalRows(this.jdbcConnection) == 2);


        IDatabaseConnection connection = new DatabaseConnection(this.jdbcConnection);
        DataFileLoader loader = new FlatXmlDataFileLoader();
        IDataSet ds = loader.load("/dbunit/testDB.xml");
        DatabaseOperation.INSERT.execute(connection, ds);

        assertTrue(TableUtils.totalRows(this.jdbcConnection) == 6);

    }

    @Test
    public void loadDB_clean_insert_xml() throws SQLException, DatabaseUnitException, IOException {

        assertTrue(TableUtils.totalRows(this.jdbcConnection) == 2);


        IDatabaseConnection connection = new DatabaseConnection(this.jdbcConnection);
        DataFileLoader loader = new FlatXmlDataFileLoader();
        IDataSet ds = loader.load("/dbunit/testDB.xml");
        DatabaseOperation.CLEAN_INSERT.execute(connection, ds);

        assertTrue(TableUtils.totalRows(this.jdbcConnection) == 4);

    }

    @Test
    public void loadDB_insert_amd_delete_xml() throws SQLException, DatabaseUnitException, IOException {

        assertTrue(TableUtils.totalRows(this.jdbcConnection) == 2);

        IDatabaseConnection connection = new DatabaseConnection(this.jdbcConnection);

        DataFileLoader loader = new FlatXmlDataFileLoader();
        IDataSet ds = loader.load("/dbunit/testDB.xml");
        DatabaseOperation.INSERT.execute(connection, ds);
        assertTrue(TableUtils.totalRows(this.jdbcConnection) == 6);

        DatabaseOperation.DELETE.execute(connection, ds);

        assertTrue(TableUtils.totalRows(this.jdbcConnection) == 2);
    }



}
