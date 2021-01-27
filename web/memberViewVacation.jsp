<%-- 
    Document   : viewHoliday
    Created on : Jan 10, 2021, 11:31:47 AM
    Author     : Raaid
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/viewVacation.css">
        <title>Booking Page</title>
    </head>
    <body>
        <div class="navBody">
            <h1 class="title-h1">Adventure|Pilot</h1>

            <a href="MemberController" class="btn">Home</a>
            <a href="#" class="btn">Search</a>
            <a href="LogoutServlet" class="btn">Log Out</a>
        </div>
        <div class="alignment">
            <div class="cards">
                <div class="image">
                    <img src="images/disney.jpg">
                </div>
                <div class="card-title">
                    <h1>Disney Land</h1>
                </div>
                <div class="price-tag">
                    <h3>$400 Per Head</h3>
                </div>
                <div class="card-des">
                    <p>This is a trip to disney world.</p>
                </div>
                <form class="form-style">
                    <label for="people">Choose number of adventurers </label>

                    <select name=people" id="cars">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                    </select>
                    <br>
                    <p>Select Services<p>
                    <input type="checkbox" id="safari" name="safari" value="safari">
                    <label for="safari"> Safari Ride $20 per head </label><br>
                    <input type="checkbox" id="gocarting" name="gocarting" value="gocarting">
                    <label for="gocarting"> Go Carting $40 per head</label><br>
                    <br>
                    <submit class="card-button" >Book Now</submit>
                    <br>
                    <br>
                </form>
            </div>
        </div>
    </body>
</html>
