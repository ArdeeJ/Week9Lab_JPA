<%-- 
    Document   : users
    Created on : 18-Oct-2022, 1:15:43 PM
    Author     : ardee
--%>

<%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JDBC</title>
    </head>
    <body>
        <h1>Manage Users ${email}</h1>
        <p>
            <c:if test="${messsage eq 'create'}">User created </c:if>
            <c:if test="${messsage eq 'update'}">User updated </c:if>
            <c:if test="${messsage eq 'delete'}">User deleted </c:if>
            <c:if test="${messsage eq 'error'}">Sorry, something went wrong.</c:if>
            </p>
            <ul>
            <c:forEach items="${users}" var = "user">
                <li><a href="users?action=edit&amp;userId=${user.userId}">${user.email}</a><br></li>
            </c:forEach>
            </ul>
        <c:if test="${selectedUser eq null}">
            <h2>Add User</h2>
            <form action="users" method="post">
        </c:if>
                <table>
                    <tr>
                        <th>Email</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Role</th>
                        <th></th>
                        <th></th>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                </table>
                <p>${message}</p>
                <h1>Add User</h1>
                <form>
                    Email: <input type="email" name="emailAddress"><br>
                    First name: <input type="text" name="firstName"><br>
                    Last name: <input type="text" name="lastName"><br>
                    Password: <input type="password" name="password" required><br>
                    Role: <select name="role" value="system admin">
                        <option value="system admin">system admin</option>
                        <option value="regular user">regular user</option>
                    </select><br>
                    <input type="submit" value="Add user">
                    <p>${message}</p>
                </form>
                </body>
                </html>
