<%-- 
    Document   : bookHolidayPage
    Created on : Jan 23, 2021, 4:32:17 PM
    Author     : Raaid
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/addVacation.css" rel="stylesheet" media="all">
        <title>Customize Booking Page</title>
    </head>
    <body>
        <div class="page-wrapper bg-dark p-t-100 p-b-50">
            <div class="wrapper wrapper--w900">
                <div class="card card-6">
                    <div class="card-heading">
                        <h2 class="title">Customize Booking</h2>
                    </div>
                    <div class="card-body">
                        <form form action="bookingController" >
                            <input type="hidden" name="command" value="BOOK"/>
                            <input  type="hidden" name="price" value='<%=request.getParameter("pricePerRoom")%>'>
                            <input  type="hidden" name="package" value='<%=request.getParameter("packageType")%>'>
                            <div class="form-row">
                                <div class="name">Pricing Details</div>
                                <div class="value" > 
                                    <div class="input-group">
                                        <textarea class="textarea--style-6" name="description" >The price per room before tax is $<%=request.getParameter("pricePerRoom")%>. This package is a <%=request.getParameter("packageType")%> package and taxes will be charged accordingly. Both Safari Ride and Go carting are $75 each.</textarea>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name">No of Rooms </div>
                                <div class="value" > 
                                    <select name="room" class="input--style-6" >
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name">Safari Ride</div>
                                <div class="value" > 
                                    <select name="safari" class="input--style-6" >
                                        <option values="1">Yes</option>
                                        <option values="2">No</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name">Go Carting</div>
                                <div class="value" > 
                                    <select name="carting" class="input--style-6" >
                                        <option values="1">Yes</option>
                                        <option values="2">No</option>
                                    </select>
                                </div>
                            </div>
                            <div class="card-footer">
                                <button class="btn btn--radius-2 btn--blue-2" type="submit" >Proceed</button>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>
    </body>
</html>
