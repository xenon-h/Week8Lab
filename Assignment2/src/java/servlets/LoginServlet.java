/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.AccountService;

/**
 *
 * @author 759005
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate(); // just by going to the login page the user is logged out :-) 
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        AccountService as = new AccountService();
        User user = as.login(email, password);
        
        if (user == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        
        HttpSession session = request.getSession();
//        User authedUser = new User(user.getEmail(), user.getActive(), null, user.getLastName(), null);
//        session.setAttribute("user", authedUser);
        
        String firstname = user.getFirstName();
        String lastname = user.getLastName();

        session.setAttribute("email", email);
        session.setAttribute("firstname", firstname);
        session.setAttribute("lastname", lastname);
        
        if (user.getRole().getRoleId() == 1|| user.getRole().getRoleId() == 3) {
            response.sendRedirect("admin");
        } else {
            response.sendRedirect("inventory");
        }
    }

}
