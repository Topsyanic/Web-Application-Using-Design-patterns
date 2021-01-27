<%-- 
    Document   : adminSearchPage
    Created on : Jan 24, 2021, 9:30:08 AM
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

            <a href="AdminController" class="btn">Home</a>
            <a href="adminSearchPage.jsp" class="btn">Search</a>
            <a href="addVacationPage.jsp" class="btn">Add new vacation</a>
            <a href="sendOfferPage.jsp" class="btn">Send Offer</a>
            <a href="LogoutServlet" class="btn">Log Out</a>
        </div>
        <form form action="AdminController" method="GET">
            <input type="hidden" name="command" value="SEARCH"/>
            <div class="search-box">
                <select name="order" class="search-select" >
                    <option value="Ascending">Low to High</option>
                    <option value="Descending">High to Low</option>
                </select>
                <input class="search-input" type="text" name="keyword" placeholder="Enter a search keyword here">
                <button class="search-btn" type="submit" >Search</button>
            </div> 

        </form>
        <h2 class="package-heading">Search Results</h2>
        <c:forEach var="tempHoliday" items="${HOLIDAYLIST}">
            <c:url var="deleteLink" value="AdminController">
                <c:param name="command" value="DELETE"/>
                <c:param name="blogId" value="${tempHoliday.holidayId}"/>
            </c:url>
            <c:url var="viewLink" value="/adminViewVacationPage.jsp">
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
            <c:url var="updateLink" value="/editPostPage.jsp">
                <c:param name="command" value="UPDATE"/>
                <c:param name="blogId" value="${tempHoliday.holidayId}"/>
                <c:param name="title" value="${tempHoliday.title}"/>
                <c:param name="body" value="${tempHoliday.description}"/>
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