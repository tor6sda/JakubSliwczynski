package com.sdacademy.jdbchibernate.przyklady;

import com.sdacademy.jdbchibernate.util.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class przyklad3 {

    public static void make() {

        String sqlUpdate = "UPDATE address SET ADD_BUILDING_NO = ? WHERE ADD_POSTAL_CODE = ?";

        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement("")) {
            statement.setString(1, "10");
            statement.setString(2, "38600");
            int countUpdatedRecords = statement.executeUpdate();
            System.out.println("Zaktualizowano " + countUpdatedRecords + " wierszy");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
