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
        <title>Admin</title>
        <script src="https://code.jquery.com/jquery-3.4.0.min.js"
        integrity="sha256-BJeo0qm959uMBGb65z40ejJYGSgR7REI4+CW1fNKwOg=" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
              integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="static/admin.css">
    </head>
    <body>
        <h2 class="text-white">Users</h2>
        <table class="table-hover my-5">
            <tr><th>Username</th>
                <th>Email Address</th>
                <th>Firstname</th>
                <th>Lastname</th>
                <th>Role</th>
                <th>Update</th>
                <th>Delete</th>
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
                    <td class="text-center"><a href="${pageContext.request.contextPath}/update/${i.id}"><img src="static/pictures/update.png" alt="Update"</a></td>
                    <td class="text-center">  <a href="${pageContext.request.contextPath}/delete/${i.id}"><img src="static/pictures/delete.png" alt="Delete"</a></td>

                </tr>
            </c:forEach>
        </table>
        <br>
        <p class="text-center"><a id="a" href="${pageContext.request.contextPath}/insertByAdmin" class="insert my-5">Insert User</a></p>
    </body>
</html>
