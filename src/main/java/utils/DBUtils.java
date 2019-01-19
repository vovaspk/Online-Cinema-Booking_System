package utils;

import controller.passwordController.PasswordHasher;
import org.apache.log4j.Logger;

import java.sql.*;

public class DBUtils {
    static final Logger logger = Logger.getLogger(DBUtils.class);
    private static String user_Name = "root";
    private static String pass_word = "1234";
    private static String connectionURL = "jdbc:mysql://localhost:3306/cinemadatabase?autoReconnect=true&useSSL=false";

    public static boolean addUser(String userName, String email, String password) {

        try {
            String hashedPassword = PasswordHasher.hashPassword(password);
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn;
            conn = DriverManager.getConnection(connectionURL, user_Name, pass_word);
            PreparedStatement st = conn.prepareStatement("INSERT INTO user(username, email, password) VALUE (?,?,?)");
            st.setString(1, userName);
            st.setString(2, email);
            st.setString(3, hashedPassword);
            st.executeUpdate();

            st.close();
            conn.close();
            return true;
        } catch (SQLException e) {
            logger.error("not able to perform add user: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            logger.error("cannot find class: " + e.getMessage());
            e.printStackTrace();
        }

        return false;
    }

    public static boolean isExist(String userName, String email, String password) {
        Connection conn;
        try {
            String pswrd = PasswordHasher.hashPassword(password);

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(connectionURL, user_Name, pass_word);
            PreparedStatement st = conn.prepareStatement("SELECT * FROM user WHERE username=? AND email=?");
            st.setString(1, userName);
            st.setString(2, email);
            //st.setString(3,password);
            ResultSet rs = st.executeQuery();

            System.out.println("Cannot get in rs.next block");
            if (rs.next()) {
                String pass = rs.getString("password");
                System.out.println(pass);
                System.out.println("there is a resultset");
                if (PasswordHasher.checkPass(password, pass)) {
                    System.out.println("passwordHasher check done is success");
                    return true;
                }
            }
            rs.close();
            st.close();
            conn.close();

            return false;

        } catch (SQLException e) {
            logger.error("error in DBUtils.isExist() " + e);
            logger.error("cannot check isExist: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            logger.error("Cannot find and load class: " + e.getMessage());
            e.getMessage();
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }

}
