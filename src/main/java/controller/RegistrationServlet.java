package controller;

import org.apache.log4j.Logger;
import utils.DBUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    static final Logger logger = Logger.getLogger(RegistrationServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String userName = req.getParameter("regUsername");
        String email = req.getParameter("regEmail");
        String pswd = req.getParameter("regPsw");


        if(DBUtils.addUser(userName,email,pswd)){
            System.out.println("User was Successfully registred");
            logger.info("User was Successfully registred in system: ");
            RequestDispatcher rd = req.getRequestDispatcher("/view/login.jsp");
            rd.forward(req,resp);

        }else{
            logger.error("Cannot register user");
            System.out.println("Cannot register user");
            resp.sendRedirect("/view/registration.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
