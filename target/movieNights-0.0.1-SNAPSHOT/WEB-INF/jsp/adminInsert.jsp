<%-- 
    Document   : adminInsert
    Created on : 16 Ιουλ 2019, 9:40:29 μμ
    Author     : bizmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>🎬 Insert User</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
        <link rel="stylesheet" type="text/css" href="static/register.css">
        <style>.error{color: white;
               font-size: 20px;
            } </style>
    </head>
    <body>
        <div class="content">
            <div class="graphics">
                <img src="static/pictures/spiderman.png" class="container">
            </div>
        </div>

        <div class="">
            <article class="card-body mx-auto" style="max-width: 400px;">
                <h3 class="card-title mt-3 text-center">Create Account</h3>
                <form:form modelAttribute="user" method="POST" action="${pageContext.request.contextPath}/doInsertByAdmin">
                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                        </div>
                        <form:input  path="firstname" placeholder="Firstname" class="form-control" title="Enter Firstname" required="required"/>
                        <form:errors  path="firstname" cssClass="error"/>
                    </div> <!-- form-group// -->

                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                        </div>
                        <form:input  path="lastname"  placeholder="Lastname" class="form-control" title="Enter Lastname" required="required" />
                        <form:errors  path="lastname" cssClass="error"/>
                    </div> <!-- form-group// -->

                    <hr>
                    <form:errors  path="username" cssClass="error"/>
                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                        </div>
                        <form:input  path="username"  placeholder="Username" class="form-control" title="Enter Username"  required="required" />

                    </div> <!-- form-group// -->
                    <div>   <form:errors  path="email" cssClass="error"/> </div>
                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
                        </div>
                        <form:input  path="email"  placeholder="Email" class="form-control" type="email" title="Enter Email Address" required="required"/>

                    </div> <!-- form-group// -->


                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                        </div>
                        <form:input  path="password"  name="password" placeholder="Password"  minlength="5" title="The password must be at least 5 characters" class="form-control" required="required" />
                        <form:errors  path="password" cssClass="error"/>
                    </div> <!-- form-group// -->
                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-cog"></i> </span>
                        </div>
                        <form:select path="role" class="form-control">
                            <form:option value="-1" disabled="${true}">Select role</form:option>
                            <form:options items="${rolesArray}" itemLabel="userrole" itemValue="id" />
                        </form:select>
                    </div>
                    <div class="form-group">
                        <input type="submit" value="Insert" class="form-control btn btn-primary btn-block">   
                    </div> <!-- form-group// -->
                </form:form>
            </article>
        </div>
    </body>
</html>