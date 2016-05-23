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
            <% if(ss.equals("Howto.jsp") || ss.equals("profil.jsp") || ss.equals("Todo.jsp") || ss.equals("Learns.jsp") || ss.equals("Words.jsp") || ss.equals("Message.jsp") )
        {
            out.print("<button name='send' type='submit' value='add'>Ajouter </button><BR>");
            if(ss.equals("Howto.jsp") || ss.equals("profil.jsp") || ss.equals("Todo.jsp") || ss.equals("Learns.jsp") || ss.equals("Words.jsp"))
            {
                out.print("<button name='send' type='submit' value='modif'>Modifier </button><BR>");
                if(ss.equals("Howto.jsp") || ss.equals("profil.jsp") || ss.equals("Todo.jsp") || ss.equals("Learns.jsp") || ss.equals("Words.jsp"))
                {
                    out.print("<button name='send' type='submit' value='supp'>Supprimer </button><BR>");
                }
            }
        }%>
            
        </form>
               
    </body>
</html>
