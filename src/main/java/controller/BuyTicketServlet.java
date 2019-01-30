package controller;

import model.*;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/buyTicket")
public class BuyTicketServlet extends HttpServlet {
    Logger log = Logger.getLogger(BuyTicketServlet.class);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //should get movie_id and user_id for ticket
        UserDao userDao = new UserDao();
        TicketDao ticketDao = new TicketDao();
        MovieDao dao = new MovieDao();
        String userName = (String) req.getSession().getAttribute("user");
        try {
            int user_id = userDao.findUser(userName);
            String name= req.getParameter("movie_name");
            String day= req.getParameter("day_of_movie");
            String time= req.getParameter("time");
            //int seat= Integer.parseInt(req.getParameter("seat"));
            String seat = req.getParameter("seat");

            // Ticket ticket = new Ticket(user_id, name, day, time, seat);
            Ticket ticket = new Ticket(user_id, name, day, time, seat);
            System.out.println(name);
            System.out.println(day);
            System.out.println(time);
            System.out.println(seat);
            ticket.toString();

            //if(ticket.isExist(){DO NOT ADD Ticket} else{ADD Ticket}
            ticketDao.addTicket(user_id, name, day, time, seat);

            List<Movie> listMovies = dao.list();
            req.setAttribute("listMovies", listMovies);

            List<Ticket> listTickets = ticketDao.getTicketsListforUser(userName);
            req.setAttribute("listTickets", listTickets);

            //CHANGE ON REQ.FORWARD()
            RequestDispatcher rd = req.getRequestDispatcher("/view/loginSuccess.jsp");
            rd.forward(req,resp);
            //resp.sendRedirect("view/loginSuccess.jsp");


        } catch (SQLException e) {
            log.error("BuyTicketsServlet.doPost(): ", e);
            e.printStackTrace();
        }



    }
}
