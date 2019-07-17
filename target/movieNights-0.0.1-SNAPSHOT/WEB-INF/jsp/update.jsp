<%-- 
    Document   : update
    Created on : 16 Ιουλ 2019, 8:24:24 μμ
    Author     : bizmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>update</title>
    </head>
    <body>
        <table>
        <form:form modelAttribute="id" method="POST" action="${pageContext.request.contextPath}/updatedUser">
        <tr><td>   <form:input  path="firstname" /></td></tr>
       <tr> <td>     <form:input type="hidden" path="id"/></td></tr>
       <tr> <td>  <form:input  path="lastname"/></td></tr>
       <tr> <td>  <form:input  path="username"/></td></tr>
        <tr><td>  <form:input  path="email"/> </td></tr>
        <tr><td>  <form:input  path="password" name="password"/> </td></tr>
        <tr><td>   
                      <form:select path="role">
                          <form:option value="-1">Select role</form:option>
    <form:options items="${rolesArray}" itemLabel="id" itemValue="id" />
               </form:select></td></tr>
      <tr>  <td> <input type="submit">  </td></tr>
    </table>
</form:form>
</body>
</html>
