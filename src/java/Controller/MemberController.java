/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Holiday;
import Model.VacationDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
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
public class MemberController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String command = request.getParameter("command");
            if (command == null) {
                command = "HOME";
            }
            switch (command) {
                case "HOME":
                    redirectHome(request, response);
                case "SEARCH":
                    searchVacations(request, response);
                    break;
                default:
                    redirectHome(request, response);
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    private void redirectHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        VacationDAO doa = new VacationDAO();
        List<Holiday> holidayList = doa.viewHolidays();
        request.setAttribute("HOLIDAYLIST", holidayList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/memberHomePage.jsp");
        dispatcher.forward(request, response);
    }

    private void searchVacations(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String order = request.getParameter("order");
        String keyword = "%" + request.getParameter("keyword") + "%";
        VacationDAO dao = new VacationDAO();
        if (order.equalsIgnoreCase("ascending")) {
            List<Holiday> holidayList = dao.searchVacationAscending(keyword);
            request.setAttribute("HOLIDAYLIST", holidayList);
        } else if (order.equalsIgnoreCase("descending")) {
            List<Holiday> holidayList = dao.searchVacationDescending(keyword);
            request.setAttribute("HOLIDAYLIST", holidayList);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/memberSearchPage.jsp");
        dispatcher.forward(request, response);
    }

}
