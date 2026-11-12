//package com.apiNexsuss.connection;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class text {
//
//    private static final String DATABASE = "api_nexsuss";
//    private static final String USERNAME = "root";
//    private static final String PASSWORD = "Savindu@2008";
//
//    private static final String URL = "jdbc:mysql://localhost:3306/" + DATABASE
//            + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
//
//    // Always returns a fresh, valid connection
//    public static Connection createConnection() {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public static ResultSet executeSearch(String query) throws SQLException {
//        Connection conn = createConnection();
//        return conn.createStatement().executeQuery(query);
//        // Caller should close ResultSet and Connection after use
//    }
//
//    public static void executeIUD(String query) {
//        try (Connection conn = createConnection()) {
//            conn.createStatement().executeUpdate(query);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
