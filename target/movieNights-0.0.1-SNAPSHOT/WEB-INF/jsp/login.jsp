<%-- 
    Document   : login
    Created on : 8 Ιουλ 2019, 7:40:45 μμ
    Author     : bizmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>🎬 Login</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/login.css">
    </head>

    <body>
        <div class="content">
            <div class="graphics">
                <img src="static/pictures/ironman.png" class="container">
            </div>
        </div>

        <div class="container">
            <div class="d-flex justify-content-center h-100">
                <div class="card">
                    <c:if test="${empty EmailSent && empty reset && empty invalidToken && empty savePass}">
                        <div id="bc">    <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/> </div>

                    </c:if>
                    <div id="email">${EmailSent}</div>
                    <div id="token">${invalidToken}</div>
                    <div id="reset">${reset}</div>
                    <div id="pass">${savePass}</div>
                    <div class="card-header">
                        <h3>Sign In</h3>
                    </div>
                    <div class="card-body">
                        <form name='f' action="login" method='POST'>
                            <div class="input-group form-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-user"></i></span>
                                </div>
                                <input type="text" class="form-control" placeholder="username" name="username" required>

                            </div>
                            <div class="input-group form-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-key"></i></span>
                                </div>
                                <input type="password" class="form-control" placeholder="password" name="password" required>
                            </div>
                            <div class="row align-items-center remember">
                                <input type="checkbox" name="remember-me" value="true">Remember Me
                            </div>
                            <div class="form-group">
                                <input type="submit" value="Login" class="btn float-right login_btn">
                            </div>
                        </form>
                    </div>
                    <div class="card-footer">
                        <div class="d-flex justify-content-center links">
                            Don't have an account?<a href="registerUser">Sign Up</a>
                        </div>
                        <div class="d-flex justify-content-center">
                            <a href="forgot-password">Forgot your password?</a>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <article >
            <div class="card-body text-left">

                <p class="h5 text-white my-5">
                    Welcome to Movie Nights,<br> the biggest online
                    Movies Library with a twist!
                </p>
                <p class="h5 text-white my-5">Tons of websites
                    offer recommendations but fail to provide
                    good ones.
                </p>
                <p class="h5 text-white my-5">Instead of picking movies for you,
                    we make it super easy to discover great stuff
                    yourself.We’ve collected movie data from
                    around the web so you don’t have to.
                </p> 
                <p class="h5 text-white my-5">Just tell
                    us what kind of movies you’re looking for and
                    we’ll give you the best there are.
                </p>
            </div>
        </article>
    </body>

</html>
