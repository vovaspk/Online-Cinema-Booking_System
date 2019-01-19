package model;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;


public class UserDao {
    Logger logger = Logger.getLogger(UserDao.class);
    String databaseURL = "jdbc:mysql://localhost:3306/cinemadatabase";
    String user = "root";
    String password = "1234";

    public  int findUser(String name) throws SQLException {
        int userId = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(databaseURL, user, password);
            String sql = "SELECT user_id FROM user WHERE username=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                userId = result.getInt("user_id");

            }

        } catch (SQLException ex) {
            logger.error("MovieDao.list(): SQLException ", ex);
            ex.printStackTrace();
            throw ex;
        } catch (ClassNotFoundException e) {
            logger.error("MovieDao.list(): Cannot find jdbc driver " , e);
        }

        return userId;
    }
}
