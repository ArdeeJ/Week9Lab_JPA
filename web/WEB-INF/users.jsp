<%-- 
    Document   : users
    Created on : 18-Oct-2022, 1:15:43 PM
    Author     : ardee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JDBC</title>
    </head>
    <body>
        <h1>Manage Users</h1>
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
        </form>
    </body>
</html>
