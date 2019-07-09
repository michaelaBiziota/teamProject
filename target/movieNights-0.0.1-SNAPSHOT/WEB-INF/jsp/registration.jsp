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
        <title>JSP Page</title>
        <style>.error{background-color: red} </style>
    </head>
    <body>
        <form:form modelAttribute="user" method="POST" action="${pageContext.request.contextPath}/doRegisterUser">
            <form:input  path="firstname" placeholder="firstname" />
            <form:errors  path="firstname" cssClass="error"/>
            <form:input  path="lastname"  placeholder="lastname" />
            <form:errors  path="lastname" cssClass="error"/>
            <form:input  path="username"  placeholder="username" />
            <form:errors  path="username" cssClass="error"/>
            <form:input  path="email"  placeholder="email"/>
            <form:errors  path="email" cssClass="error"/>
            <form:input  path="password"  name="password" placeholder="password" />
            <form:errors  path="password" cssClass="error"/>
            <input type="submit">    
        </form:form>


    </body>
</html>
