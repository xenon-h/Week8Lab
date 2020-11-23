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
        <div id="websiteController">
            <input type="button" name="addButton" onclick="add()" value="Add user">
            <input type="button" name="addButton" onclick="edit()" value="Edit user">
            <a id="scrollUp"><div class="triangle-up triangle"></div></a>
            <a id="scrollDown"><div class="triangle-down triangle"></div></a>

        </div>
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
                    <form method="post" action="admin">
                        <td>${item.email}</td>
                        <td>${item.firstName}</td>
                        <td>${item.lastName}</td>
                        <td>
                            <button class='iconButton deleteButton' type="submit" name='action' value='delete'>
                                <i class="fas fa-trash-alt"></i>
                            </button>
                        <td>
                            <button class='iconButton editButton' type="button" class ="editButton" onclick="edit('${item.email}')" name='action' value='Edit'>
                                <i class="fas fa-user-edit"></i>
                            </button>
                            <input type='hidden' name="email" value='${item.email}' >
                        </td>
                    </form>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <div class="modalContainer">

            <a id="addUserCloseLink"><div class='modalShaun'></div></a>
            <div class="modal" id="AddUser">
                <div class="closeButtonWrapper">
                    <input type="button" class='close' id="addUserCloseButton" value="+">
                </div>
                <h4>Add User</h4>

                <form method='post' action='admin'>
                    <div class="inputs">
                        <label>Email<input type='text' name='email' value='${newUser.firstName}'></label>
                        <label>First Name<input type='text' name='firstName' value='${newUser.firstName}'></label>
                        <label>Last Name<input type='text' name='lastName' value='${newUser.lastName}'></label>
                        <label>Password<input type='password' name='password' value='${newUser.password}'></label>
                        <input type='hidden' name='roleID' value='${newUser.role.roleID}' />
                    </div>
                    <input class="submit" type='submit' name='action' value='Add'>
                </form>
            </div>
        </div>

        <div class="modalContainer">

            <a id="editUserCloseLink"><div class='modalShaun'></div></a>

            <div id="EditUser" class="modal">
                <h4>Edit User</h4>

                <div class="closeButtonWrapper">
                    <input type="button" class='close' id="editUserCloseButton" value="+">
                </div>

                <form method='post' action='admin'>
                    <div class="inputs">
                        <label>Email<input id='editUserEmail' type='text' name='email' value='${editUser.email}' readonly></label>
                        <label>First Name<input id='editUserFirstName' type='text' name='firstName' value='${editUser.firstName}'></label>
                        <label>Last Name<input id='editUserLastName' type='text' name='lastName' value='${editUser.lastName}'></label>
                        <label>Password<input id='editUserPassword' type='password' name='password' value='${editUser.password}'></label>
                    </div>
                    <input class="submit" type='submit' name='action' value='Edit'>
                </form>
            </div>
        </div>
    </body>
</html>
