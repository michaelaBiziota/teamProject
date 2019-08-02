<%-- 
    Document   : resetPassword
    Created on : 11 Ιουλ 2019, 7:09:17 μμ
    Author     : bizmi
--%>

<%-- 
    Document   : resetPassword
    Created on : 11 Ιουλ 2019, 7:09:17 μμ
    Author     : bizmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>🎬 Reset Password</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/register.css">
    </head>
    <body>


        <div class="content text-center">
            <div class="graphics">
                <img src="../static/pictures/dr.strange.png" class="container">
            </div>
        </div>

        <div class="forgot">

            <article class="card-body mx-auto" style="max-width: 400px;">

                <h2 class="text-center">Reset Password?</h2>
                ${message}
                <p class="text-center">Enter your new password
                <form method="POST" action="${pageContext.request.contextPath}/savePassword">   

                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                        </div>
                        <input id="p" placeholder="New Password" class="form-control" name="newPassword" minlength="5" type="password" title="The password must be at least 5 characters" required/>


                    </div> 

                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                        </div>
                        <input  placeholder="Confirm Password" type="password" id="confp" class="form-control"  required="required" />
                    </div> 

                    <div class="form-group">
                        <input type="submit"  id="s" class="form-control btn btn-primary btn-block"> 

                    </div> 
                </form>
                <div id="conft"><div>
            </article>
        </div>
                                
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <script src="${pageContext.request.contextPath}/static/resetPassword.js"></script>
    </body>
</html>