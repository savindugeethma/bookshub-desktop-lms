package com.apiNexsuss.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class mysql {

    private static final String DATABASE = "api_nexsuss";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Savindu@2008";
    private static Connection connection;

    public static Connection createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Check if connection is null or closed
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/" + DATABASE,
                        USERNAME,
                        PASSWORD
                );
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static ResultSet executeSearch(String query) throws SQLException {
        Connection conn = createConnection(); // ensures connection is open
        return conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                   .executeQuery(query);
    }

    public static void executeIUD(String query) {
        try {
            Connection conn = createConnection(); // ensures connection is open
            conn.createStatement().executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
