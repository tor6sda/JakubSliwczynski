package com.sdacademy.jdbchibernate.zadania;

import com.sdacademy.jdbchibernate.util.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class zadanie1 {

    public static void make() {

        StringBuilder stringBuilder = new StringBuilder("?");

        String questionMark = ",?";

        int[] tablica = new int[] {1, 2, 3};

        for (int i=1; i<tablica.length; i++) {
            stringBuilder.append(questionMark);
        }

        String query = "SELECT * FROM category WHERE CAT_ID IN(" + stringBuilder.toString() + ")";

        try (PreparedStatement preparedStatement = DatabaseConnection.getInstance().getConnection().prepareStatement(query)) {
            for (int i=0; i<tablica.length; i++) {
                preparedStatement.setInt(i+1, tablica[i]);
            }

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("CAT_ID");
                String name = resultSet.getString("CAT_NAME");
                System.out.println("Category ID: " + id + " Category Name: " + name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
