/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.GoCarting;
import Model.SafariRide;
import Model.Vacation;
import Model.VacationFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Raaid
 */
public class BookingController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = request.getParameter("command");
        if (command == null) {
            command = "BOOK";
        }
        switch (command) {
            case "BOOK":
                calculateTotal(request, response);
                System.out.println("WORKING PROEPRLY");
                break;
            case "PAY":
                makePayment(request, response);
                System.out.println("WORKING PROEPRLY");
                break;
            default:
                System.out.println("NOT WORKING PROPERLY");
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    private void calculateTotal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int price = Integer.parseInt(request.getParameter("price"));
        String packageType = request.getParameter("package");
        int noOfRooms = Integer.parseInt(request.getParameter("room"));
        String safariRide = request.getParameter("safari");
        String goCarting = request.getParameter("carting");
        VacationFactory vacationFactory = new VacationFactory();
        Vacation vacation = vacationFactory.selectPackage(packageType, price, noOfRooms);
        if (safariRide.equalsIgnoreCase("yes") && goCarting.equalsIgnoreCase("No")) {
            vacation = new SafariRide(vacation);
        } else if (safariRide.equalsIgnoreCase("no") && goCarting.equalsIgnoreCase("yes")) {
            vacation = new GoCarting(vacation);
            System.out.println(vacation.getCost());
        } else if (safariRide.equalsIgnoreCase("yes") && goCarting.equalsIgnoreCase("yes")) {
            vacation = new SafariRide(new GoCarting(vacation));
        }
        request.setAttribute("TOTAL", vacation.getCost());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/confirmBookingPage.jsp");
        dispatcher.forward(request, response);
    }

    private void makePayment(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
