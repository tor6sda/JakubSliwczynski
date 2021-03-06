package com.sdacademy.jdbchibernate.zadania;

/*
 * Napisz program który dopisze do Produktów o id 1,3,5 frazę " - BRAK" -
 * skorzystaj z sparametryzowanego PreparedStatement. Wyświetl ile rekordów zostało zaktualizowanych
 * */

import com.sdacademy.jdbchibernate.util.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class zadanie2 {

    public static void make() {

        int[] tablica = new int[] {1, 3, 5};

        StringBuilder builder = new StringBuilder("?");
        String questionMark = ",?";

        for (int i=1; i<tablica.length; i++) {
            builder.append(questionMark);
        }

        String query = "UPDATE product SET PRO_DESCRIPTION = CONCAT(PRO_DESCRIPTION, ?) WHERE PRO_ID IN(" + builder.toString() +")";

        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(query)) {

            statement.setString(1, " - BRAK");

            for (int i=0; i<tablica.length; i++) {
                statement.setInt(i + 2, tablica[i]);
            }

            int countRecords = statement.executeUpdate();

            System.out.println("Zaktualizowano " + countRecords + " rekordów!");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
