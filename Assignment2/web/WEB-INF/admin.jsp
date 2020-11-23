<%-- 
    Document   : admin
    Created on : Nov 22, 2020, 2:20:29 PM
    Author     : 759005
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles.css">
        <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
        <script src="https://kit.fontawesome.com/97e2ee3dbf.js" crossorigin="anonymous"></script>
        <script src="JScript.js" rel="script" type="text/javascript" defer></script><title>JSP Page</title>

    </head>
    <body>
        <h1>Home Inventory</h1>
        <h1>Menu</h1>
        <ul>
            <li><a href="inventory">Inventory</a></li>
            <li><a href="admin">Admin</a></li>
            <li><a href="login" >Logout</a></li>
        </ul>
        <div id="ViewUser">
            <table class="userTable">
                <tr class="columnLabels">
                    <td>Email</td>
                    <td>First Name</td>
                    <td>Last Name</td>
                    <td>Delete</td>
                    <td>Edit</td>
                </tr>
                <c:forEach items="${userList}" var="item">
                    <tr id="${item.email}">
                    <form method="post" action="user">
                        <td>${item.email}</td>
                        <td>${item.firstName}</td>
                        <td>${item.lastName}</td>
                        <td>
                            <button class='iconButton deleteButton' type="submit" name='action' value='delete'>
                                <i class="fas fa-trash-alt"></i>
                            </button>
                        <td>
                            <button class='iconButton editButton' type="button" class ="editButton" onclick="edit('${item.email}')" name='action' value='editSelect'>
                                <i class="fas fa-user-edit"></i>
                            </button>
                        </td>
                        <input type='hidden' name="email" value='${item.email}' readonly>
                    </form>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
