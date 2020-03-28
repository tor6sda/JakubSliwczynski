package com.sdacademy.jdbchibernate.przyklady;

import com.sdacademy.jdbchibernate.util.DatabaseConnection;

import java.sql.*;

public class przyklad2 {

    public static void make() {

        String query = "SELECT * FROM address WHERE ADD_CITY LIKE \"%\"?\"%\"";

        System.out.println();

        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(query)) {
            statement.setString(1, "Paris");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ADD_ID");
                String street = resultSet.getString("ADD_STREET");
                String city = resultSet.getString("ADD_CITY");
                System.out.println("Address ID: " + id + " Address Street: " + street + " Address City: " + city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
