<%-- 
    Document   : forgotPassword
    Created on : 11 Ιουλ 2019, 7:09:01 μμ
    Author     : bizmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forgot Password?</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
        <link rel="stylesheet" type="text/css" href="static/register.css">
    </head>
    <body>
        <div class="content text-center">
            <div class="graphics">
                <img src="static/pictures/dr.strange.png" class="container img-fluid" id="dr">
            </div>
        </div>
        <div class="forgot">
            <article class="card-body " style="max-width: 400px;">
${userNotFound}
                <h2 class="text-center">Forgot Password?</h2>
                ${message}
                <p class="text-center">Enter your e-mail address and we'll send you a link to reset your password.
                <form  method="POST" action="${pageContext.request.contextPath}/forgot-password">

                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
                        </div>
                        <input placeholder="Your Email" class="form-control" name="email" required type="email"/>
                    </div> <!-- form-group// -->
                    ${success}

                    <div class="form-group">
                        <input type="submit"  class="form-control btn btn-primary btn-block">   
                    </div> <!-- form-group// -->
                </form>
            </article>
        </div>


    </body>
</html>


