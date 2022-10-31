package servlets;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.RoleService;
import services.UserService;

/**
 *
 * @author ardee
 */
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        RoleService rs = new RoleService();
        UserService us = new UserService();
        
        String email = request.getParameter("email");
        
        try {
            HttpSession session = request.getSession();
            List <User> users = us.getAll("email");
            request.setAttribute("users", users);
        } catch (Exception ex) {        
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "error");
        }
        
        String action = request.getParameter("action");
        if (action != null && action.equals("edit")) {
            try {
                HttpSession session = request.getSession();       
                session.setAttribute("email", email);
                User user = us.get(email);
                request.setAttribute("email", email);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (action != null && action.equals("delete")) {
            try {
                us.delete(email);                 
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        try {
            HttpSession session = request.getSession();
            List <User> users = us.getAll("email");
            request.setAttribute("users", users);
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "error");
        }
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp")
                    .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        UserService userService = new UserService();
        RoleService roleService = new RoleService();
        
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp")
                    .forward(request, response);
    }
}
