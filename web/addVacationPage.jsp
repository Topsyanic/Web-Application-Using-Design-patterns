<%-- 
    Document   : addVacationPage
    Created on : Jan 10, 2021, 5:36:41 PM
    Author     : Raaid
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Adding vacation...</title>

        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">


        <link href="css/addVacation.css" rel="stylesheet" media="all">
    </head>

    <body>
        <div class="page-wrapper bg-dark p-t-100 p-b-50">
            <div class="wrapper wrapper--w900">
                <div class="card card-6">
                    <div class="card-heading">
                        <h2 class="title">Add vacation</h2>
                    </div>
                    <div class="card-body">
                        <form form action="AdminController" method="POST" enctype="multipart/form-data">
                            <input type="hidden" name="command" value="ADD"/>
                            <div class="form-row">
                                <div class="name">Title</div>
                                <div class="value">
                                    <div class="input-group">
                                        <input class="input--style-6" type="text" name="title" placeholder="Type the title of vacation here" required="">
                                    </div>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name">Description</div>
                                <div class="value">
                                    <div class="input-group">
                                        <textarea class="textarea--style-6" name="description" placeholder="Type the description of the vacation" ></textarea>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name">Package Type</div>
                                <div class="value" > 
                                    <select name="package" class="input--style-6" >
                                        <option values="Basic">Basic</option>
                                        <option values="Standard">Standard</option>
                                        <option values="Luxury">Luxury</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name">Room Capacity</div>
                                <div class="value" > 
                                    <select name="room" class="input--style-6" >
                                        <option value="1">1 Adult</option>
                                        <option value="2">2 Adults</option>
                                        <option value="3">3 Adults</option>
                                        <option value="4">4 Adults</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name">Meal</div>
                                <div class="value" > 
                                    <select name="meal" class="input--style-6" >
                                        <option values="Breakfast">Breakfast</option>
                                        <option values="Breakfast & Lunch">Breakfast & Lunch</option>
                                        <option values="Breakfast, Lunch & Dinner">Breakfast, Lunch & Dinner</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name">Upload Image</div>
                                <div class="value">
                                    <div class="input-group js-input-file">
                                        <input class="input-file" type="file" name="fileToUpload" id="file" required>
                                        <label class="label--file" for="file">Choose file</label>
                                        <span class="input-file__info">No file chosen</span>
                                    </div>
                                    <div class="label--desc">Upload your Vacation image. Max file size 10 MB</div>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name">Price Per Room</div>
                                <div class="value">
                                    <div class="input-group">
                                        <input class="input--style-6" type="number" name="price" placeholder="Type the price per room here." required="">
                                    </div>
                                </div>
                            </div>
                            <div class="card-footer">
                                <button class="btn btn--radius-2 btn--blue-2" type="submit">Post Vacation</button>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>


        <script src="vendor/jquery/jquery.min.js"></script>



        <script src="js/addVacation.js"></script>

    </body>

</html>
