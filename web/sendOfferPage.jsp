<%-- 
    Document   : sendOfferPage
    Created on : Jan 23, 2021, 8:28:22 PM
    Author     : Raaid
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/addVacation.css" rel="stylesheet" media="all">
        <title>Send Offer Page</title>
    </head>
    <body>
        <div class="page-wrapper bg-dark p-t-100 p-b-50">
            <div class="wrapper wrapper--w900">
                <div class="card card-6">
                    <div class="card-heading">
                        <h2 class="title">Send Offer Message</h2>
                    </div>
                    <div class="card-body">
                        <form form action="AdminController" method="GET">
                            <input type="hidden" name="command" value="OFFER"/>
                         
                            <div class="form-row">
                                <div class="name" style="padding-left: 100px">Message</div>
                                <div class="value">
                                    <div class="input-group">
                                        <textarea class="textarea--style-6" name="message" placeholder="Type your message here"></textarea>
                                    </div>
                                </div>
                            </div>
                           
                            <div class="card-footer" style="padding-left:375px">
                                <button class="btn btn--radius-2 btn--blue-2" type="submit" >Send</button>
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
