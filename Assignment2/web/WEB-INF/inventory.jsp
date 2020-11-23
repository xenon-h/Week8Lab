<%-- 
    Document   : inventory
    Created on : Nov 22, 2020, 2:21:25 PM
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
        <title>Home Inventory</title>
    </head>
    <body>
        <h1>Home Inventory</h1>
        <h1>Menu</h1>
        <ul>
            <li><a href="inventory">Inventory</a></li>
            <li><a href="admin">Admin</a></li>
            <li><a href="login" >Logout</a></li>
        </ul>
        <h1>Inventory for ${firstname} ${lastname}</h1>
        <div id="websiteController"><input type="button" name="addButton" onclick="add()" value="Add Item"></div>
        <div id="ViewUser">
            <table class="userTable">
                <tr class="columnLabels">
                    <td>Item Category</td>
                    <td>Item Name</td>
                    <td>Price</td>
                    <td>Delete</td>
                </tr>
                <c:forEach items="${itemList}" var="item">
                    <c:if test="${email == item.owner.email}">
                        <tr>
                        <form method="post" action="inventory">
                            <td id="${item.category.categoryId}">${item.category.categoryName}</td>
                            <td>${item.itemName}</td>
                            <td>${item.price}</td>
                            <td>
                                <input type="hidden" name="itemId" value="${item.itemId}" />
                                <button class='iconButton deleteButton' type="submit" name='action' value='delete'>
                                    <i class="fas fa-trash-alt"></i>
                                </button>
                            </td>
                        </form>
                        </tr>
                    </c:if>
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

                <form method='post' action='inventory'>
                    <div class="inputs">
                        <label name='category' id="category">Category
                            <select name="category" id="category">
                                <c:forEach items="${categoryList}" var="category">
                                    <option value="${category.categoryId}">${category.categoryName}</option>
                                </c:forEach>
                            </select>

                        </label>
                        <label>Item Name<input type='text' name='firstName' value='${newUser.firstName}'></label>
                        <label>Price<input type='text' name='lastName' value='${newUser.lastName}'></label>
                        <input type='hidden' name='roleID' value='${newUser.role.roleID}' />
                    </div>
                    <input class="submit" type='submit' name='action' value='Add'>
                </form>
            </div>
        </div>
    </body>
</html>
