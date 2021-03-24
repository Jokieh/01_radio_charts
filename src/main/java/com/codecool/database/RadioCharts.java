package com.codecool.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

public class RadioCharts {

    String url="jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    String username="sa";
    String password="";

    public RadioCharts(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }


    Connection conn;
    {
        try {
            conn = DriverManager.getConnection(url,username,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public String getMostPlayedSong () {
        String songName="";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "select song from music_broadcast where max(times_aired)";
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return songName;
    }

    public String getMostActiveArtist() {
        String artistName="";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "select artist from music_broadcast where max(times_aired)";
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return artistName;
    }
}



