/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Holiday;
import Model.HolidayAdapter;
import Model.Mail;
import Model.User;
import Model.UserDAO;
import Model.VacationDAO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Raaid
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50)
public class AdminController extends HttpServlet {

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
                    break;
                case "ADD":
                    addVacation(request, response);
                    break;
                case "OFFER":
                    sendOffer(request, response);
                    break;
                case "SEARCH":
                    searchVacations(request, response);
                    break;
                case "DELETE":
                    deletePost(request, response);
                    break;
                default:
                    redirectHome(request, response);
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String command = request.getParameter("command");
            if (command == null) {
                command = "HOME";
            }
            switch (command) {
                case "HOME":
                    redirectHome(request, response);
                    break;
                case "ADD":
                    addVacation(request, response);
                    break;
                case "UPDATE":
                    editPost(request, response);
                    break;
                default:
                    redirectHome(request, response);
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void redirectHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        VacationDAO doa = new VacationDAO();
        List<Holiday> holidayList = doa.viewHolidays();
        request.setAttribute("HOLIDAYLIST", holidayList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/adminHomePage.jsp");
        dispatcher.forward(request, response);
    }

    private void addVacation(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        PrintWriter out = response.getWriter();
        VacationDAO dao = new VacationDAO();

        String description = request.getParameter("description");
        String title = request.getParameter("title");
        String packageType = request.getParameter("package");
        String roomCapacity = request.getParameter("room");
        String meal = request.getParameter("meal");
        String pricePerRoom = request.getParameter("price");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        Part part = request.getPart("fileToUpload");
        String fileName = randomIdentifier() + ".jpg";
        String savePath = "VacationImages" + File.separator + fileName;
        File fileSaveDir = new File(savePath);
        part.write("D:\\APIIT\\NetBeansProjects\\OOAE\\web\\VacationImages\\" + fileName);
        if (description == null || description.equals("")) {
            HolidayAdapter holidayAdapter = new HolidayAdapter();
            Holiday holiday = holidayAdapter.addHoliday(title, description, Integer.parseInt(pricePerRoom), packageType, Integer.parseInt(roomCapacity), meal, savePath);
            dao.addVacation(holiday);
        } else {
            Holiday holiday = new Holiday(title, description, Integer.parseInt(pricePerRoom), packageType, Integer.parseInt(roomCapacity), meal, savePath);
            dao.addVacation(holiday);
        }
        redirectHome(request, response);

    }

    final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";

    final java.util.Random rand = new java.util.Random();

    final Set<String> identifiers = new HashSet<String>();

    public String randomIdentifier() {
        StringBuilder builder = new StringBuilder();
        while (builder.toString().length() == 0) {
            int length = rand.nextInt(5) + 5;
            for (int i = 0; i < length; i++) {
                builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
            }
            if (identifiers.contains(builder.toString())) {
                builder = new StringBuilder();
            }
        }
        return builder.toString();
    }

    private void editPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        VacationDAO dao = new VacationDAO();

        String holidayId = request.getParameter("holidayId");

        String description = request.getParameter("description");
        String title = request.getParameter("title");
        String packageType = request.getParameter("package");
        String roomCapacity = request.getParameter("room");
        String meal = request.getParameter("meal");
        String pricePerRoom = request.getParameter("pricePerRoom");
        dao.editPost(holidayId, description, title, packageType, roomCapacity, meal, pricePerRoom);
        redirectHome(request, response);
    }

    private void sendOffer(HttpServletRequest request, HttpServletResponse response) throws MessagingException, SQLException, IOException {
        String offer = request.getParameter("message");
        UserDAO dao = new UserDAO();
        String email;
        List<User> userList = dao.getAllUser();
        for (User tempUser : userList) {
            email = tempUser.getEmail();
            Mail.sendMail(email, offer);
        }
        PrintWriter writer = response.getWriter();
        writer.print("<script type=\"text/javascript\">");
        writer.print("alert('Offer was successfully sent.');");
        writer.print("location='AdminController';");
        writer.print("</script>");

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
        RequestDispatcher dispatcher = request.getRequestDispatcher("/adminSearchPage.jsp");
        dispatcher.forward(request, response);
    }

    private void deletePost(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String holidayId = request.getParameter("holidayId");
        VacationDAO dao = new VacationDAO();
        dao.deleteVacation(holidayId);
        redirectHome(request, response);
    }

}
