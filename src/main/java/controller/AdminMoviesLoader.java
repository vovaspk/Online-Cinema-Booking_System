package controller;

import model.Movie;
import model.MovieDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/loadMoviesForAdmin")
public class AdminMoviesLoader extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MovieDao movieDao = new MovieDao();
        try {
            List<Movie> listMovies = movieDao.list();
            req.setAttribute("listMovies", listMovies);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher rd = req.getRequestDispatcher("/view/adminPage.jsp");
        rd.forward(req,resp);
    }
}
