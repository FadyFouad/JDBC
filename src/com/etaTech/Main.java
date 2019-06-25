package com.etaTech;


import java.sql.*;

/****************************************************
 *** Created by Fady Fouad on 6/23/2019 at 15:11.***
 ***************************************************/
public class Main {
    public static void main(String[] args) {
        System.out.println("----------------------DATABASES-------------------------");
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:Fady_JDBC.db");
             Statement statement = connection.createStatement()) {
//            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\USER\\Fady_JDBC.db");
//            connection.setAutoCommit(false);
//            statement.execute("CREATE TABLE IF NOT EXISTS Fady " +
//                                  "(name TEXT , phone INTEGER,email TEXT )");
//            statement.execute("INSERT INTO Fady " +
//                                  "VALUES ('Fadi',201123815517,'fady.fouad.a@gmail.com')");
//            statement.execute("INSERT INTO Fady " +
//                                  "VALUES ('Fady99',201123815517,'fady.fouad.a@gmail.com')");
//            statement.execute("UPDATE Fady SET email = 'fadyfouad993@gmail' WHERE  name = 'Fadi'" );
//            statement.execute("DELETE FROM Fady WHERE name = 'Fady99'");

            statement.execute("SELECT * FROM Fady ");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()){
                System.out.println(resultSet.getString("name")+" : "+resultSet.getString("phone")+" : "+resultSet.getString("email"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}