package model;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MovieDao {
    Logger logger = Logger.getLogger(MovieDao.class);
    String databaseURL = "jdbc:mysql://localhost:3306/cinemadatabase";
    String user = "root";
    String password = "1234";

    public List<Movie> list() throws SQLException {
        List<Movie> listMovies = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(databaseURL, user, password);
            String sql = "SELECT * FROM movie ORDER BY movie_name";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                int id = result.getInt("movie_id");
                String name = result.getString("movie_name");
                String director = result.getString("movie_director");
                String actors = result.getString("movie_actors");
                Date relDate = result.getDate("movie_releaseDate");
                int duration = result.getInt("movie_duration_min");
                String time = result.getString("time");
                Movie movie = new Movie(id, name, director, actors, relDate, duration, time);

                listMovies.add(movie);
            }

        } catch (SQLException ex) {
            logger.error("MovieDao.list(): SQLException ", ex);
            ex.printStackTrace();
            throw ex;
        } catch (ClassNotFoundException e) {
            logger.error("MovieDao.list(): Cannot find jdbc driver " , e);
        }

        return listMovies;
    }
}

