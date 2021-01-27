<%-- 
    Document   : loginPage
    Created on : Jan 4, 2021, 4:59:15 PM
    Author     : Raaid
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Sign Up Adventure Pilot</title>


        <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">


        <link rel="stylesheet" href="css/signUp.css">
    </head>
    <body>

        <div class="main">
 <p class="loginhere">
     Continue as a Guest <a href="GuestController" class="loginhere-link">Click here</a>
                        </p>
            <section class="signup">
               

                <div class="container">
                    <div class="signup-content">
                        <form action="LoginServlet" method="POST" class="signup-form">
                            <h2 class="form-title">Sign In</h2>
                            <div class="form-group">
                                <input type="email" class="form-input" name="email" id="email" placeholder="Email"/>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-input" name="password" id="password" placeholder="Password"/>
                                <span toggle="#password" class="zmdi zmdi-eye field-icon toggle-password"></span>
                                <br>
                                <br>
                                <div class="form-group">
                                    <input type="submit" name="submit" id="submit" class="form-submit" value="Sign In"/>
                                </div>
                        </form>
                        
                        <p class="loginhere">
                            Don't have an account ? <a href="signUpPage.jsp" class="loginhere-link">Signup here</a>
                        </p>
                    </div>
                </div>
            </section>

        </div>

        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="js/signUp.js"></script>
    </body>
</html>
