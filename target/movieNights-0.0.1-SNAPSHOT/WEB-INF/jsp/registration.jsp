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
        <style>.error{background-color: red} </style>
        <title>Register</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
        <link rel="stylesheet" type="text/css" href="static/register.css">

    </head>
    <body>
        <div class="content">
            <div class="graphics">
                <img src="static/spiderman.png" class="container">
            </div>
        </div>

        <br>
        <p>
        <h6 class="text-center">Tons of websites offer recommendations but fail to provide good ones.
            Instead of picking movies for you, we make it
            super easy to discover great stuff yourself!</h6>
    </p>
    <hr>


    <div class="">
        <article class="card-body mx-auto" style="max-width: 400px;">
            <h3 class="card-title mt-3 text-center">Create Account</h3>

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

                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                    </div>
                    <form:input  path="username"  placeholder="Username" class="form-control" title="Enter a Username"  required="required" />
                    <form:errors  path="username" cssClass="error"/>
                </div> <!-- form-group// -->

                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
                    </div>
                    <form:input  path="email"  placeholder="Email" class="form-control" type="email" title="Enter your Email Address" required="required"/>
                    <form:errors  path="email" cssClass="error"/>
                </div> <!-- form-group// -->



                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                    </div>
                    <form:input  path="password"  name="password" placeholder="Password"  minlength="5" title="The password must be at least 5 characters" class="form-control" required="required" />
                    <form:errors  path="password" cssClass="error"/>
                </div> <!-- form-group// -->


                <div class="form-group">
                    <input type="submit" value="Create Account" class="form-control btn btn-primary btn-block">   
                </div> <!-- form-group// -->
                <p class="text-center">Have an account? <a href="/movieNights/login">Log In</a> </p>

            </form:form>
        </article>
    </div> <!-- card.// -->


    <br><br><br> <br><br>
    <article class=" mb-3">
        <div class="card-body text-center">

            <p class="h5 text-white">
                We’ve collected movie data from around the web so you don’t have to. Just tell us what kind of
                movies
                you’re looking for
                and we’ll give you the best there are!
            </p>
        </div>
    </article>

</body>
</html>
