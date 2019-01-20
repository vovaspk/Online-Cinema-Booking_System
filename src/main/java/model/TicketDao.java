package model;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDao {
    Logger logger = Logger.getLogger(TicketDao.class);
    String databaseUrl = "jdbc:mysql://localhost:3306/cinemadatabase";
    String user = "root";
    String password = "1234";

    public List<Ticket> getTicketsList() throws SQLException {
        List<Ticket> ticketList = new ArrayList<>();

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(databaseUrl, user, password);
            String sql = "SELECT * FROM booking ORDER BY movie_seat";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery(sql);

            while(result.next()){
                int user_id = result.getInt("booking_id");
                String name = result.getString("movie_name");
                String day = result.getString("movie_day");
                String time = result.getString("movie_time");
                String seat = result.getString("movie_seat");
                Ticket ticket = new Ticket(user_id, name, day, time, seat);
                ticketList.add(ticket);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ticketList;
    }

    public boolean clearTikets(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(databaseUrl, user, password);
            String query = "DELETE FROM booking";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.executeUpdate();
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Ticket> getTicketsListforUser(String username) throws SQLException {
        UserDao dao = new UserDao();
        int id = dao.findUser(username);
        List<Ticket> ticketList = new ArrayList<>();

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(databaseUrl, user, password);
            String sql = "SELECT * FROM booking WHERE booking_id=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            while(result.next()){
                int us_id = result.getInt("booking_id");
                String name = result.getString("movie_name");
                String day = result.getString("movie_day");
                String time = result.getString("movie_time");
                String seat = result.getString("movie_seat");
                Ticket ticket = new Ticket(us_id, name, day, time, seat);
                ticketList.add(ticket);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ticketList;
    }

    //TODO
    public boolean addTicket(int booking_id, String movie_name, String movie_day, String movie_time, String movie_seat){

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(databaseUrl, user, password);
            String sql = "INSERT IGNORE INTO booking(booking_id, movie_name, movie_day, movie_time, movie_seat) VALUES (?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, booking_id);
            statement.setString(2, movie_name);
            statement.setString(3, movie_day);
            statement.setString(4, movie_time);
            statement.setString(5, movie_seat);

            statement.executeUpdate();

            statement.close();
            connection.close();
            return true;


        } catch (ClassNotFoundException e) {
            logger.error("at model.TicketDao.addTicket(): ", e);
            e.printStackTrace();
        } catch (SQLException e) {

            logger.error("at model.TicketDao.addTicket(): " , e);
        }

        return false;
    }
}
