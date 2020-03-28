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
        String query = "UPDATE product SET PRO_DESCRIPTION = \"Brak\" WHERE PRO_ID IN(1, 3, 5)";

        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(query)) {

            int countRecords = statement.executeUpdate();

            System.out.println("Zaktualizowano " + countRecords + " rekordów!");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
