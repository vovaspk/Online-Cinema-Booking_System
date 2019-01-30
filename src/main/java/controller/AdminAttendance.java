package controller;

import model.Ticket;
import model.TicketDao;
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

@WebServlet("/loadAttendanceForAdmin")
public class AdminAttendance extends HttpServlet {
    Logger log = Logger.getLogger(AdminAttendance.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TicketDao ticketDao = new TicketDao();
        try {
            List<Ticket> listTickets = null;
            listTickets = ticketDao.getTicketsList();
            req.setAttribute("listTickets", listTickets);

            RequestDispatcher rd = req.getRequestDispatcher("/view/adminPage.jsp");
            rd.forward(req, resp);
        } catch (SQLException e) {
            log.error("AdminAttendance.doGet(): ", e);
            e.printStackTrace();
        }

    }
}