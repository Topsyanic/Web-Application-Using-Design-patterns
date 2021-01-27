<%-- 
    Document   : confirmBookingPage
    Created on : Jan 23, 2021, 6:29:43 PM
    Author     : Raaid
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/addVacation.css" rel="stylesheet" media="all">
        <title>Confirm Booking Page</title>
    </head>
    <body>
        <div class="page-wrapper bg-dark p-t-100 p-b-50">
            <div class="wrapper wrapper--w900">
                <div class="card card-6">
                    <div class="card-heading">
                        <h2 class="title">Receipt</h2>
                    </div>
                    <div class="card-body">
                        <form form action="PaymentProxyController"  enctype="multipart/form-data">
                            <input type="hidden" name="command" value="PAY"/>
                            <div class="form-row">
                                <div style="padding-left: 350px;">
                                    <div class="name" >Total Price</div>
                                    <div class="value">
                                        <div class="input-group">
                                            <br>
                                            <p> $${TOTAL}.00 </p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="card-footer" style="padding-left: 350px">
                                <button class="btn btn--radius-2 btn--blue-2" type="submit">Make Payment</button>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>

    </body>
</html>
