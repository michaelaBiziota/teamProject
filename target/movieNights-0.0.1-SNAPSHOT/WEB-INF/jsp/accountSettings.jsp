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
        <title>JSP Page</title>
    </head>
    <body>
        ${settings}
        <table >
            <form:form modelAttribute="user" method="POST" action="${pageContext.request.contextPath}/resetSettings">
                <form:input path="id" type="hidden"/>
                <tr><td>Username</td> <td><form:input  path="username"  placeholder="Username"  title="Update Username"  required="required" /></td></tr>
                <tr><td>Lastname</td><td><form:input  path="lastname"  placeholder="Lastname" title="Update Lastname" required="required" /></td></tr>
                <tr><td>FirstName</td><td><form:input  path="firstname"   title="Update Firstname" required="required"/></td></tr>
                <tr><td>Email Address</td><td> <form:input  path="email"  placeholder="Email"  type="email" title="Update Email Address" required="required"/></td></tr>
                <tr><td>Password</td><td><input type="password" name="password" placeholder="Password"  minlength="5" title="Update password, must be at least 5 characters" required="required" /></td></tr>
                <tr><td><input type="submit"></td></tr>
                    </form:form>
        </table>
        <a href="${pageContext.request.contextPath}/movies">Back to movies</a>
    </body>
</html>
