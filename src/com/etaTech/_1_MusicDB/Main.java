package com.etaTech._1_MusicDB;

import com.etaTech.Model.Artist;
import com.etaTech.Model.DataSource;

import java.util.List;

/****************************************************
 *** Created by Fady Fouad on 6/25/2019 at 22:10.***
 ***************************************************/
public class Main {
    public static void main(String[] args) {
        System.out.println("------------------------- Music Database------------------------");

        DataSource dataSource = new DataSource();
        if (!dataSource.open()){
            System.out.println("Cant open");
            return;
        }
//        dataSource.close();

        List<Artist>artists = dataSource.getArtists();
        for (Artist artist :
                artists) {
            System.out.println(artist.getName());
        }
        dataSource.close();
    }
}