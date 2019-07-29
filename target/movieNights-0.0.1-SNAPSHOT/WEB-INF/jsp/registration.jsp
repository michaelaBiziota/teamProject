<%-- 
    Document   : registration
    Created on : 8 Ιουλ 2019, 12:35:29 πμ
    Author     : bizmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>🎬 Register</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
        <link rel="stylesheet" type="text/css" href="static/register.css">
    </head>
    <body>
        <div class="content">
            <div class="graphics">
                <img src="static/pictures/spiderman.png" class="container">
            </div>
        </div>
        <div class="">
            <article class="card-body mx-auto" style="max-width: 400px;">
                <h2 class="card-title mt-3 text-center">Create Account</h2>
                <br>
                <form:form modelAttribute="user" method="POST" action="${pageContext.request.contextPath}/doRegisterUser">

                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                        </div>
                        <form:input  path="firstname" placeholder="Firstname" class="form-control" title="Enter your Firstname" required="required"/>

                        <form:errors  path="firstname" cssClass="error"/>
                    </div> <!-- form-group// -->

                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                        </div>
                        <form:input  path="lastname"  placeholder="Lastname" class="form-control" title="Enter your Lastname" required="required" />
                        <form:errors  path="lastname" cssClass="error"/>
                    </div> <!-- form-group// -->

                    <hr>
                    <div>  <form:errors  path="username" cssClass="error"/></div>
                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                        </div>
                        <form:input  path="username"  placeholder="Username" class="form-control" title="Enter a Username"  required="required" />

                    </div> <!-- form-group// -->
                    <div>   <form:errors  path="email" cssClass="error"/> </div>
                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
                        </div>
                        <form:input  path="email"  placeholder="Email" class="form-control" type="email" title="Enter your Email Address" required="required" name="email"/>

                    </div> <!-- form-group// -->

                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                        </div>
                        <form:input  id="p" type="password" path="password"  name="password" placeholder="Password"  minlength="5" title="The password must be at least 5 characters" class="form-control" required="required" />
                        <form:errors  path="password" cssClass="error"/>
                    </div> <!-- form-group// -->   

                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                        </div>
                        <input  type="password" id="confp" class="form-control" placeholder="Confirm Password"  required="required" />
                        <div id="conft"></div>
                    </div> 

                    <div class="form-group">
                        <input id="s" type="submit" value="Create Account" class="form-control btn btn-primary btn-block">   
                    </div> <!-- form-group// -->
                    <p class="text-center">Have an account? <a href="/movieNights/login">Log In</a> </p>

                </form:form>
            </article>
        </div> <!-- card.// -->

        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <script>
            jQuery(App);
            function App($) {
                $("#confp").on("keyup", function () {
                    if ($("#p").val() !== $("#confp").val()) {
                        $("#s").prop("disabled", true);
                        $("#conft").html("confirm password and password do not match");
                    } else {
                        $("#s").prop("disabled", false);
                        $("#conft").html("");
                    }
                });
            }
        </script>
    </body>
</html>
