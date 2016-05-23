<%-- 
    Document   : Choice
    Created on : 23 mai 2016, 16:21:04
    Author     : caron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
String ss =request.getParameter("page");
%>
        <form action="<%out.print(ss);%>" method="post">
        <button name="send" type="submit" value="add">Ajouter </button><BR>
        <button name="send" type="submit" value="modif">Modifier </button><BR>
        <button name="send" type="submit" value="supp">Supprimer </button><BR>
        </form>
               
    </body>
</html>
