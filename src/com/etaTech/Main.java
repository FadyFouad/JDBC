package com.etaTech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/****************************************************
 *** Created by Fady Fouad on 6/23/2019 at 15:11.***
 ***************************************************/
public class Main {
    public static void main(String[] args) {
        System.out.println("----------------------DATABASES-------------------------");
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:Fady_JDBC.db");
             Statement statement = connection.createStatement()) {
//            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\USER\\Fady_JDBC.db");
            statement.execute("CREATE TABLE IF NOT EXISTS Fady " +
                                  "(name TEXT , phone INTEGER,email TEXT )");
//            statement.close();
//            connection.close();//try with res auto close.
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}