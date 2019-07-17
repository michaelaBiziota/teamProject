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
        <title>JSP Page</title>
        <style>.error{background-color: red} </style>
    </head>
    <body>
        <form:form modelAttribute="user" method="POST" action="${pageContext.request.contextPath}/doInsertByAdmin">
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
                        <form:select path="role">
                            <form:option value="-1">Select role</form:option>
                            <form:options items="${rolesArray}" itemLabel="userrole" itemValue="id" />
                        </form:select>
            <input type="submit">    
        </form:form>


    </body>
</html>