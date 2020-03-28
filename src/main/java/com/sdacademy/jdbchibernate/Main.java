package com.sdacademy.jdbchibernate;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/shop?serverTimezone=CET";
        String user = "root";
        String password = "test";

        String query = "SELECT USR_FIRSTNAME, USR_LASTNAME FROM user";

        try (Connection connection = DriverManager.getConnection(url, user, password); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println("");
                System.out.println("FirstName: " + resultSet.getString("USR_FIRSTNAME"));
                System.out.println("LastName: " + resultSet.getString("USR_LASTNAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
