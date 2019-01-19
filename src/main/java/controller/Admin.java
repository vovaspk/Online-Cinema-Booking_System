package controller;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.Date;

public class Admin {
    static final Logger logger = Logger.getLogger(Admin.class);
    private static String user_Name = "root";
    private static String pass_word = "1234";
    private static String connectionURL = "jdbc:mysql://localhost:3306/cinemadatabase?autoReconnect=true&useSSL=false";

    public static boolean addMovie(String movieName, String Director, String actors, String releaseDate, int duration, String time) {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn;
            conn = DriverManager.getConnection(connectionURL, user_Name, pass_word);
            PreparedStatement statement =
            conn.prepareStatement("INSERT INTO movie(movie_name, movie_director, movie_actors, movie_releaseDate, movie_duration_min, time) VALUES (?,?,?,?,?,?)");
            statement.setString(1, movieName);
            statement.setString(2, Director);
            statement.setString(3, actors);
            statement.setString(4, releaseDate);
            statement.setInt(5, duration);
            statement.setString(6, time);



            statement.executeUpdate();

            statement.close();
            conn.close();
            return true;
        } catch (SQLException e) {
            logger.error("not able to perform add movie: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            logger.error("cannot find class: " + e.getMessage());
            e.printStackTrace();
        }

        return false;
    }

    public static boolean deleteMovie(int movie_id){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn;
            conn = DriverManager.getConnection(connectionURL, user_Name, pass_word);
            PreparedStatement statement = conn.prepareStatement("DELETE FROM movie WHERE movie_id=?");
            statement.setInt(1, movie_id);
            statement.executeUpdate();

            statement.close();
            conn.close();
            return true;
        } catch (ClassNotFoundException e) {
            logger.error("deleteMovie(): cannot find class " + e);
            e.printStackTrace();
        } catch (SQLException e) {
            logger.error("deleteMovie(): SQLException " + e);
            e.printStackTrace();
        }
        return false;
    }
}
