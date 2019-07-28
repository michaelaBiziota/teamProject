

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/register.css">
    </head>
    <body>

        <div class="content">
            <div class="graphics">
                <img src="${pageContext.request.contextPath}/static/pictures/spiderman.png" class="container">
            </div>
        </div>


        <div class="">
            <article class="card-body mx-auto" style="max-width: 400px;">
                <h3 class="card-title mt-3 text-center">Update Account</h3>

                <form:form modelAttribute="id" method="POST" action="${pageContext.request.contextPath}/updatedUser">
                    <form:hidden  path="id" />
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
<div>${ue}</div>
                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                        </div>
                        <form:input  path="username"  placeholder="Username" class="form-control" title="Update Username"  required="required" />
<input type=hidden name="myusername" value="${id.username}"  />
                    </div> 

<div>${ee}</div>
                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
                        </div>
                        <form:input  path="email"  placeholder="Email" class="form-control" type="email" title="Update Email Address" required="required"/>
                       
                        <input type=hidden name="myemail" value="${id.email}"  />
                    </div> 

<!--                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                        </div>-->
                        <form:hidden  path="password"  name="password" placeholder="Password"  minlength="5" title="Update password, must be at least 5 characters" class="form-control" required="required" />
                        <input type=hidden name="mypass" value="${id.password}"  />
<!--                    </div> -->


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
                        <input type="submit" value="Update" class="form-control btn btn-primary btn-block">   
                    </div> <!-- form-group// -->
                </form:form>
            </article>
        </div> <!-- card.// -->
    </body>
</html>
