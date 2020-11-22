<%-- 
    Document   : inventory
    Created on : Nov 22, 2020, 2:21:25 PM
    Author     : 759005
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Home Inventory</h1>
        <h3>Menu</h3>
        <ul>
            <li><a href="/inventory">Inventory</a></li>
            <li><a href="/admin">Admin</a></li>
            <li><a href="/login?action=logout" >Logout</a></li>
        </ul>
        <h2>Inventory for ${user.firstname} ${user.lastname}</h2>
    </body>
</html>
