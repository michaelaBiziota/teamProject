<%-- 
    Document   : admin
    Created on : 15 Ιουλ 2019, 9:28:36 μμ
    Author     : bizmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table class="table-hover">
            <tr><th>username</th>
                <th>email</th>
                <th>firstname</th>
                <th>lastname</th>
                <th>role</th>
            </tr>
            <c:forEach var = "i" items="${userlist}">
                <tr> <td>
                <c:out value="${i.username}"/>
                </td>
                <td>
                <c:out value="${i.email}"/>
                </td>
                <td>
                <c:out value="${i.firstname}"/>
                </td>
                <td>
                <c:out value="${i.lastname}"/>
            </td>                    <td>
        <c:out value="${i.role.userrole}"/>
        </td>
        <td>  <a href="${pageContext.request.contextPath}/delete/${i.id}">delete</a></td>
        <td><a href="${pageContext.request.contextPath}/update/${i.id}">update</a></td>
        </tr>
    </c:forEach>
</table>
<br>
<a id="a" href="${pageContext.request.contextPath}/insertByAdmin">Insert a new admin or a new user</a>
</body>
</html>
