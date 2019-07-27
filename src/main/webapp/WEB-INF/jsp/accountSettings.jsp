<%-- 
    Document   : accountSettings
    Created on : 22 Ιουλ 2019, 2:12:41 μμ
    Author     : bizmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account settings</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/register.css">
        <link rel="stylesheet" type="text/css" href="static/navbar.css">
    </head>
    <body>

        <div class="container">
            <div class="row">
                <!-- MovieNights Logo -->
                <div class="col-md-4 col-xs-12 mt-3">
                    <a href="${pageContext.request.contextPath}/movies">
                        <img src="static/pictures/mn.png" class="mx-5 img-fluid" id="movienightsprof" title="Home">
                    </a>
                </div>
                <!-- End -->
                <div class="col-md-4 text-center profpage mt-3"><h2>My profile</h2></div>
            </div>

            <!--Navbar-->
            <div class="row">
                <div class="d-flex justify-content-center mx-auto">
                    <nav class="navbar navbar-expand-lg navbar-dark ">

                        <!-- Navbar brand -->

                        <!-- Collapsible content -->
                        <div class="collapse navbar-collapse " id="basicExampleNav">

                            <!-- Links -->
                            <ul class="navbar-nav profnavbar-nav">
                                <li class="nav-item" id="popular">
                                    <a class="nav-link active" href="accountSettings">Account Settings
                                        <span class="sr-only">(current)</span>
                                    </a>
                                </li>
                                <li class="nav-item" id="favourite">
                                    <a class="nav-link" href="myMovies" id="fav">My movies</a>
                                </li>
                                <li class="nav-item vertical-line">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/logout">Sign out</a>
                                </li>
                            </ul>
                            <!-- Links -->
                        </div>
                        <!-- Collapsible content -->

                    </nav>
                    <!--/.Navbar-->
                </div>

            </div>
        </div>

        
        <div class="">
            <article class="card-body mx-auto" style="max-width: 400px;">
                <div id="set"> ${settings} </div>
                <form:form modelAttribute="user" method="POST" action="${pageContext.request.contextPath}/resetSettings">
                    <form:input type="hidden" path="id" name="id"/>
                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                        </div>
                        <form:input  path="firstname" placeholder="Firstname" class="form-control" title="Update Firstname" required="required"/>
                    </div> 

                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                        </div>
                        <form:input  path="lastname"  placeholder="Lastname" class="form-control" title="Update Lastname" required="required" />
                    </div> 

                    <hr>
${ue}
                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                        </div>
                        <form:input  path="username"  placeholder="Username" class="form-control" title="Update Username"  required="required" />
                    </div> 

${ee}
                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
                        </div>
                        <form:input  path="email"  placeholder="Email" class="form-control" type="email" title="Update Email Address" required="required" name="email"/>
                    </div> 

                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                        </div>
                        <input type="password"  name="password" placeholder="Password"  minlength="5" title="Update password, must be at least 5 characters" class="form-control" required="required" />
                    </div> 
                    <div class="form-group">
                        <input type="submit" value="Submit" class="form-control btn btn-primary btn-block">   
                    </div> <!-- form-group// -->
                </form:form>
            </article>
        </div> <!-- card.// -->
    </body>

    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

</html>
