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
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Raaid
 */
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            PrintWriter out = response.getWriter();
            UserDAO dao = new UserDAO();
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String role = "Member";//The default user
            User user = new User(firstName, lastName, email, password, role);
            if (dao.registerUser(user)) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/loginPage.jsp");
                dispatcher.forward(request, response);
            } else {
                out.print("<h1 style='color:black;text-align:center;font-weight:100;'>Sorry, User already exists</h1>");
                request.getRequestDispatcher("signUpPage.jsp").include(request, response);
//            RequestDispatcher dispatcher = request.getRequestDispatcher("/signUpErrorPage.jsp");
//            dispatcher.forward(request, response);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
