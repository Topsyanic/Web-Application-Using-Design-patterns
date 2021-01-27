<%-- 
    Document   : makePaymentPage
    Created on : Jan 23, 2021, 6:55:19 PM
    Author     : Raaid
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/addVacation.css" rel="stylesheet" media="all">
        <title>Payment Page</title>
    </head>
    <body>
        <div class="page-wrapper bg-dark p-t-100 p-b-50">
            <div class="wrapper wrapper--w900">
                <div class="card card-6">
                    <div class="card-heading">
                        <h2 class="title">Card Payment</h2>
                    </div>
                    <div class="card-body">
                        <form form action="bookingController" method="POST" enctype="multipart/form-data">
                            <div class="form-row">
                                <div class="name">Full Name</div>
                                <div class="value">
                                    <div class="input-group">
                                        <input class="input--style-6" type="text" name="Full Name" value="" placeholder="Enter First Name Here" required="">
                                    </div>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name">Last Name</div>
                                <div class="value">
                                    <div class="input-group">
                                        <input class="input--style-6" type="text" name="Last Name" value="" placeholder="Enter Last Name Here" required="">
                                    </div>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name">Card Number</div>
                                <div class="value">
                                    <div class="input-group">
                                        <input class="input--style-6" type="text" name="Full Name" value="" placeholder="Enter Card Number Here" required="">
                                    </div>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name">CVV/CVC</div>
                                <div class="value">
                                    <div class="input-group">
                                        <input class="input--style-6" type="text" name="Full Name" value="" placeholder="Enter Code Here" required="">
                                    </div>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name">Month</div>
                                <div class="value" > 
                                    <select class="input--style-6" >
                                        <option >January</option>
                                        <option >February</option>
                                        <option >March</option>
                                        <option >April</option>
                                        <option >May</option>
                                        <option >June</option>
                                        <option >July</option>
                                        <option >August</option>
                                        <option >September</option>
                                        <option >October</option>
                                        <option >November</option>
                                        <option >December</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name">Year</div>
                                <div class="value" > 
                                    <select  class="input--style-6" >
                                        <option >2020</option>
                                        <option >2021</option>
                                        <option >2022</option>
                                        <option >2023</option>
                                        <option >2024</option>
                                        <option >2025</option>
                                        <option >2026</option>
                                        <option >2027</option>
                                        <option >2028</option>
                                        <option >2029</option>

                                    </select>
                                </div>
                            </div>
                            <div class="card-footer">
                                <button class="btn btn--radius-2 btn--blue-2" type="submit">Checkout</button>
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
