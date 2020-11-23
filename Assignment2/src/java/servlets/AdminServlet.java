/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Role;
import models.User;
import services.UserService;

/**
 *
 * @author 759005
 */
public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService service = new UserService();
        List<User> userList;
        List<Role> roles;

        try {
            userList = service.getAllUsers();
            roles = service.getAllRoles();
            request.setAttribute("userList", userList);
            request.setAttribute("roles", roles);
        } catch (Exception ex) {
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService service = new UserService();

        String action = request.getParameter("action");
        
        if (action != null) {

            String email = request.getParameter("email");

            switch (action) {
                case "delete":
                    try {
                        service.deleteUser(email);
                    } catch (Exception ex) {
                        Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "editSelect": {
                    try {
                        User user = service.getUser(email);
                        request.setAttribute("editUser", user);
                    } catch (Exception ex) {
                        Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                default:

                    String firstName = request.getParameter("firstName");
                    String lastName = request.getParameter("lastName");
                    String password = request.getParameter("password");
                    int roleID = 0;
                    try {
                        roleID = service.getUser(email).getRole().getRoleId();
                    } catch (Exception ex) {
                        Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    if (validateFields(email, firstName, lastName, password)) {
                        switch (action) {
                            case "Add": {
                                try {
                                    service.addUser(email, firstName, lastName, password);
                                } catch (Exception ex) {
                                    Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
                                    User user = new User(email, true, firstName, lastName, password);
                                    request.setAttribute("newUser", user);
                                }
                            }
                            break;
                            case "Edit":
                                try {
                                    service.updateUser(email, firstName, lastName, password, roleID);
                                } catch (Exception ex) {
                                    Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
                                    User user = new User(email, true, firstName, lastName, password);
                                    request.setAttribute("editUser", user);
                                }
                                break;
                        }
                    } else {
                    }
                    break;

            }
        }

        List<User> userList;
        List<Role> roles;

        try {
            userList = service.getAllUsers();
            roles = service.getAllRoles();
            request.setAttribute("userList", userList);
            request.setAttribute("roles", roles);
        } catch (Exception ex) {
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);

    }

    private boolean validateFields(String email, String firstName, String lastName, String password) {

        return email != null && !email.equals("") && firstName != null && !firstName.equals("") && lastName != null && !lastName.equals("") && password != null && !password.equals("");

    }

}
