package controller;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteMovie")
public class DeletingMovie extends HttpServlet {
    Logger log = Logger.getLogger(DeletingMovie.class);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            Admin.deleteMovie(id);
            //TODO CHANGE ON ERQ.FORWARD()
            resp.sendRedirect(req.getContextPath() + "/view/adminPage.jsp");
        }
        catch(Exception ex) {
            log.error("DeletingMovie.doPost(): ", ex);
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(req, resp);
        }
    }
}
