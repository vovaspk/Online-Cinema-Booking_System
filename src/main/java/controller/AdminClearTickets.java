package controller;

import model.TicketDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/clearTickets")
public class AdminClearTickets extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TicketDao ticketDao = new TicketDao();
        ticketDao.clearTikets();
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/adminPage.jsp");
        requestDispatcher.forward(req,resp);

    }
}
