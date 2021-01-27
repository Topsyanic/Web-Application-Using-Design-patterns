<%-- 
    Document   : homePage
    Created on : Jan 8, 2021, 4:54:21 PM
    Author     : Raaid
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/homePage.css">
        <title>Adventure Pilot</title>
    </head>
    <body>
        <div class="navBody">
            <h1 class="title-h1">Adventure|Pilot</h1>

            <a href=""  class="btn">Home</a>
            <a href="viewHoliday.jsp" class="btn">Search</a>
            <a href="loginPage.jsp" class="btn">Log in</a>
            <a href="signUpPage.jsp" class="btn">Sign Up</a>
        </div>
        <h2 class="package-heading">Current Packages</h2>
        <c:forEach var="tempHoliday" items="${HOLIDAYLIST}">
            <c:url var="viewLink" value="/viewVacationPage.jsp">
                <c:param name="command" value="VIEW"/>
                <c:param name="holidayId" value="${tempHoliday.holidayId}"/>
                <c:param name="title" value="${tempHoliday.title}"/>
                <c:param name="description" value="${tempHoliday.description}"/>
                <c:param name="packageType" value="${tempHoliday.packageType}"/>
                <c:param name="meal" value="${tempHoliday.meal}"/>
                <c:param name="image" value="${tempHoliday.image}"/>
                <c:param name="pricePerRoom" value="${tempHoliday.pricePerRoom}"/>
                <c:param name="roomCapacity" value="${tempHoliday.roomCapacity}"/>
            </c:url>
            <div class="cards">
                <div class="image">
                    <img src='${tempHoliday.image}'>
                </div>
                <div class="card-title">
                    <h2>${tempHoliday.title}</h2>
                </div>
                <div class="card-des">
                    <p>${tempHoliday.description}</p>
                </div>
                <div class="price-text">
                    <h2>$${tempHoliday.pricePerRoom}</h2>
                </div>
                <a class="card-button" href="${viewLink}" style=" text-decoration: none; ">View</a>
                <br>
                <br>
                <br>
            </div>
        </c:forEach>
    </body>
</html>
