package com.etaTech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/****************************************************
 *** Created by Fady Fouad on 6/23/2019 at 15:11.***
 ***************************************************/
public class Main {
    public static void main(String[] args) {
        System.out.println("----------------------DATABASES-------------------------");
        try {
//            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\USER\\music_JDBC.db");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:music_JDBC.db");
            

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}