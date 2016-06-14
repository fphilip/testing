package houseware.learn.testing.dbunit;

import java.sql.*;

public class Tables {

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
}
