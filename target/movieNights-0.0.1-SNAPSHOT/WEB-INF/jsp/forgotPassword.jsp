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
        <title>JSP Page</title>
        <style>.error{background-color: red} </style>
    </head>
    <body>
        <h2>Forgot Password?</h2>
        ${message}
        <p>Enter your e-mail address and we'll send you a link to reset your password.
            <form  method="POST" action="${pageContext.request.contextPath}/forgot-password">
                <input   placeholder="your email" name="email"/>
                ${success}
                <input type="submit">    
            </form>


    </body>
</html>

