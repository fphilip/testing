package houseware.learn.testing.dbunit;

import java.sql.*;

public class TableUtils {

    public static int totalRows(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select count(*) as RECORDCOUNT from users");
        if(rs.next()) {
            int rows = rs.getInt("RECORDCOUNT");
            statement.close();
            return rows;
        }
        statement.close();
        return -1;

    }

    public static void deleteById(Connection connection, int id) throws SQLException {
        PreparedStatement delete = connection.prepareStatement("DELETE FROM users WHERE id = ?");
        delete.setInt(1, id);
        delete.execute();

    }

    public static Connection createDB(){
        Connection jdbcConnection = null;
        try {
            jdbcConnection = DriverManager.getConnection("jdbc:derby:memory:testing;create=true");
            jdbcConnection.createStatement().execute("create table users( " +
                    "id INT PRIMARY KEY, " +
                    "first_name varchar(20), " +
                    "last_name varchar(20), " +
                    "password varchar(20) )"
            );
            jdbcConnection.createStatement().execute("insert into users values " +
                    "(1, 'Pedro', 'Martinez', 'qwerty') ," +
                    "(2, 'Paco', 'Soria', '12345')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jdbcConnection;
    }

    public static void closeConnection() throws SQLException {
        try {
            DriverManager.getConnection("jdbc:derby:memory:testing;drop=true");
        } catch (SQLNonTransientConnectionException e) {
            //DROP DONE
        }

    }
}
