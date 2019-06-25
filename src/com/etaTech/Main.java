package com.etaTech;

import java.sql.*;

/****************************************************
 *** Created by Fady Fouad on 6/23/2019 at 15:11.***
 ***************************************************/
public class Main {

    private static final String DATABASE_NAME = "Fady_JDBC.db";
    private static final String CONNECTION = "jdbc:sqlite:" + DATABASE_NAME;
    private static final String TABLE_CONTACTS = "contacts";
    private static final String NAME = "name";
    private static final String PHONE = "phone";
    private static final String EMAIL = "email";

    public static void main(String[] args) {
        System.out.println("----------------------DATABASES-------------------------");
        try (Connection connection = DriverManager.getConnection(CONNECTION);
             Statement statement = connection.createStatement()) {
            statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS +
                    "( " + NAME + " TEXT , " +
                    PHONE + " INTEGER ," +
                    EMAIL + " TEXT " + " )");

//            statement.execute("INSERT INTO " + TABLE_CONTACTS +
//                    "(" + NAME + " , "
//                    + PHONE + " , "
//                    + EMAIL +
//                    " )" +
//                    " VALUES( 'Fady' , '01123815517' , 'fady.fouad.a@gmail.com' )");
//
//            statement.execute("INSERT INTO " + TABLE_CONTACTS +
//                    " VALUES( 'Fadi' , '201123815517' , 'fady.fouad.a@gmail.com' )");
//
//            statement.execute("INSERT INTO " + TABLE_CONTACTS +
//                    " VALUES( 'Other' , '201123815517' , 'fady.fouad.a@gmail.com' )");
            insertContact("Fady Fouad",1123815517,"Fady.fouad.a@gmail.com");

            statement.execute(" UPDATE " + TABLE_CONTACTS +
                    " SET " + NAME + " = 'MyName'" +
                    " WHERE " + NAME + "= 'Other'");

            statement.execute(" DELETE FROM " + TABLE_CONTACTS +
                    " WHERE " + NAME + " = 'MyName'");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_CONTACTS);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(NAME) +
                        " : " + resultSet.getString(PHONE) +
                        " : " + resultSet.getString(EMAIL));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertContact( String name, int phone, String email) throws SQLException {
        Connection connection = DriverManager.getConnection(CONNECTION);
        Statement statement = connection.createStatement();
            statement.execute("INSERT INTO " + TABLE_CONTACTS +
                " VALUES('" + name + "', " + phone + ", '" + email + "')");
    }
}
