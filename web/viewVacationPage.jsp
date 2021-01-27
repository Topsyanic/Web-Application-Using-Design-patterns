<%-- 
    Document   : viewVacationPage
    Created on : Jan 9, 2021, 11:05:32 AM
    Author     : Raaid
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Viewing blog...</title>
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
        <link href="css/addVacation.css" rel="stylesheet" media="all">
    </head>
    <body>
        <div class="page-wrapper bg-dark p-t-100 p-b-50">
            <div class="wrapper wrapper--w900">
                <div class="card card-6">
                    <div class="card-heading">
                        <h2 class="title"> Vacation No: <%=request.getParameter("holidayId")%></h2>
                    </div>
                    <div class="card-body">
                        <form form action="BloggerController" method="POST" enctype="multipart/form-data">
                            <input type="hidden" name="command" value="UPDATE"/>
                            <div class="form-row">
                                <div class="name" readonly><%=request.getParameter("title")%></div>
                                <div class="value" > 

                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name"></div>
                                <div class="value">
                                    <div class="input-group">
                                        <img src="<%=request.getParameter("image")%>" width="400">
                                    </div>
                                </div>
                            </div>
                            <div class="card-footer">
                                <p readonly> <%=request.getParameter("description")%></p>


                            </div>
                            <div class="form-row">
                                <div class="name">Package Type</div>
                                <div class="value">
                                    <div class="input-group">
                                        <input readonly class="input--style-6" type="text" name="packageType" value="<%=request.getParameter("packageType")%>" required="">
                                    </div>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name">Room Capacity</div>
                                <div class="value">
                                    <div class="input-group">
                                        <input readonly class="input--style-6" type="text" name="roomCapacity" value="<%=request.getParameter("roomCapacity")%>" required="">
                                    </div>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name">Meal</div>
                                <div class="value">
                                    <div class="input-group">
                                        <input readonly class="input--style-6" type="text" name="meal" value="<%=request.getParameter("meal")%>" required="">
                                    </div>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name" readonly>Price Per Room in USD</div>
                                <div class="value">
                                    <div class="input-group">
                                        <input class="input--style-6" type="text" name="pricePerRoom" value="<%=request.getParameter("pricePerRoom")%>" required="">
                                    </div>
                                </div>

                            </div>
                            <c:url var="bookLink" value="/bookHolidayPage.jsp">
                                <c:param name="packageType" value='<%=request.getParameter("packageType")%>'/>
                                <c:param name="pricePerRoom" value='<%=request.getParameter("pricePerRoom")%>'/>
                            </c:url>
                            <div class="card-footer" style="text-align: center;">
                                <a   href="${bookLink}" >Book</a>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="js/global.js"></script>
    </body>
</html>