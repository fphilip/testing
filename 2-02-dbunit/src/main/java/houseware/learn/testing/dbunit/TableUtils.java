package houseware.learn.testing.dbunit;

import java.sql.*;

public class TableUtils {

    public static int totalRows(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select count(*) as RECORDCOUNT from usuario");
        if(rs.next()) {
            int rows = rs.getInt("RECORDCOUNT");
            statement.close();
            return rows;
        }
        statement.close();
        return -1;

    }

    public static void deleteById(Connection connection, int id) throws SQLException {
        PreparedStatement delete = connection.prepareStatement("DELETE FROM usuario WHERE id_usuario = ?");
        delete.setInt(1, id);
        delete.execute();

    }

    public static Connection createDB(){
        Connection jdbcConnection = null;
        try {
            jdbcConnection = DriverManager.getConnection("jdbc:derby:memory:testing;create=true");
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
