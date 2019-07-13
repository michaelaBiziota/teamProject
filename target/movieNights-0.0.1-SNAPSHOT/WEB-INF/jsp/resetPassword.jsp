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
        <title>JSP Page</title>
        <style>.error{background-color: red} </style>
    </head>
    <body>
        <h2>Reset Password</h2>
            <form method="POST" action="${pageContext.request.contextPath}/savePassword">              
                <input type="password" placeholder="new password" name="newPassword"/>
                <input type="submit">    
            </form>


    </body>
</html>
