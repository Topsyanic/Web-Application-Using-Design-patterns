/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Model.User;
import Model.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Raaid
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            UserDAO dao = new UserDAO();
            User authenticatedUser = dao.authenticateUser(email, password);
            PrintWriter out = response.getWriter();
            switch (authenticatedUser.getRole()) {
                case "Admin": {
                    HttpSession session = request.getSession();
                    String username = authenticatedUser.getFirstName() + " " + authenticatedUser.getLastName();
                    session.setAttribute("username", username);
                    session.setAttribute("role","Admin");
                    response.sendRedirect("AdminController");
                    break;
                }
                case "Member": {
                    HttpSession session = request.getSession();
                    String username = authenticatedUser.getFirstName() + " " + authenticatedUser.getLastName();
                    session.setAttribute("username", username);
                    session.setAttribute("role","Member");
                    response.sendRedirect("MemberController");
                    break;
                }
                default: {
                    out.print("<h1 style='color:black;text-align:center;font-weight:100;'>Email or password was incorrect. Please try again.</h1>");
                    request.getRequestDispatcher("loginPage.jsp").include(request, response);
                    break;
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
