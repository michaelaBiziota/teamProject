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
    </head>
    <body>
        <form:form modelAttribute="user" method="POST" action="${pageContext.request.contextPath}/doRegisterUser">
            <form:input  path="firstname" cssClass="error" placeholder="firstname"/>
            <form:input  path="lastname" cssClass="error" placeholder="lastname"/>
            <form:input  path="username" cssClass="error" placeholder="username"/>
            <form:input  path="email" cssClass="error" placeholder="email"/>
            <form:input  path="password" cssClass="error" name="password" placeholder="password"/>
            <input type="submit">    
        </form:form>
           

    </body>
</html>
