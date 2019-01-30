package controller;


import controller.passwordController.PasswordHasher;
import model.*;
import org.apache.log4j.Logger;
import utils.DBUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    static Logger logger = Logger.getLogger(LoginServlet.class);
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        DBUtils dbUtils = new DBUtils();
        MovieDao dao = new MovieDao();
        TicketDao ticketDao = new TicketDao();
        try {
            List<Movie>listMovies = dao.list();
            request.setAttribute("listMovies", listMovies);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //credentials to log in: |user| |user@gmail.com| |resu|
        //                       |user2| |user2@gmail.com| |resu2|
        // |admin| |admin@gmail.com| |1234|


        String userName = request.getParameter("username");
        String email = request.getParameter("email");
        String psw = request.getParameter("psw");

        User user = new User(userName, email, psw);
        System.out.println(user.toString());

        String hashPassword = PasswordHasher.hashPassword(psw);

        System.out.println("input Password: " + psw);
        System.out.println("Hashed password: " + hashPassword);


        if(DBUtils.isExist(userName,email,psw)){

            try {
                List<Movie>listMovies = dao.list();
                request.setAttribute("listMovies", listMovies);

                List<Ticket> listTickets = ticketDao.getTicketsListforUser(userName);
                request.setAttribute("listTickets", listTickets);
            } catch (SQLException e) {
                logger.error("Cannot get a list of movies: ", e);
            }
            HttpSession session = request.getSession();
            //maybe do a session.setAttribute("user", useId);
            session.setAttribute("user", userName);
            RequestDispatcher rd = request.getRequestDispatcher("/view/loginSuccess.jsp");
            rd.forward(request, response);
        }
        else if(userName.equals("admin") && email.equals("admin@gmail.com") && psw.equals("1234")){
            try {
                List<Movie>listMovies = dao.list();
                request.setAttribute("listMovies", listMovies);
            } catch (SQLException e) {
                logger.error("Cannot get a list of movies: ", e);
            }

            HttpSession session = request.getSession();
            session.setAttribute("admin", userName);
            RequestDispatcher reqd = request.getRequestDispatcher("/view/adminPage.jsp");
            reqd.forward(request,response);
        }
        else{
            logger.warn("User data is wrong to login");
            //out.print("Wrong parameters");
            System.out.println("wrong data");
            //TODO
            //CHANGE ON REQ.FORWARD()
            response.sendRedirect("/view/login.jsp");
        }

//        RequestDispatcher rd = request.getRequestDispatcher("/view/login.jsp");
//        rd.forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MovieDao movieDao = new MovieDao();
        try {
            List<Movie> listMovies = movieDao.list();
            request.setAttribute("listMovies", listMovies);
           // RequestDispatcher rd = request.getRequestDispatcher("/view/login.jsp");
//        rd.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
