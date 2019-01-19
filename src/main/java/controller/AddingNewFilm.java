package controller;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/addNewFilm")
public class AddingNewFilm extends HttpServlet {
    Logger logger = Logger.getLogger(AddingNewFilm.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//'YYYY-MM-DD HH:MM:SS' DateTime MySQL
        String movieName = req.getParameter("movieName");
        String director =  req.getParameter("movie_director");
        String actors =    req.getParameter("movie_actors");
        String releaseDateStr = req.getParameter("movie_releaseDate");
        //TODO
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");

        //Date releaseDate = null;
//        try {
//            releaseDate = sdf.parse(releaseDateStr);
//        } catch (ParseException e) {
//            logger.error("Cennot parse a date: ", e);
//            e.printStackTrace();
//        }
        //String finalDatestr=sdf.format(releaseDate);


        int duration =  Integer.parseInt(req.getParameter("movie_duration"));
        String time = req.getParameter("time");

        if (Admin.addMovie(movieName, director, actors, releaseDateStr, duration, time)) {
            logger.info("AddingNewFilm.doPost(): movie added successfully ");
            //TODO
            //CHANGE ON REQ.FORWARD()
            resp.sendRedirect("/view/adminPage.jsp");
        } else {
            logger.error("AddingNewFilm.doPost(): cannot add movie");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
