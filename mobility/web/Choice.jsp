<%-- 
    Document   : Choice
    Created on : 23 mai 2016, 16:21:04
    Author     : caron
--%>
<!-- Détermine si l'utilisateur veut : Ajouter / Modifier / Supprimer : 
j'ai fait ce choix car simple et rapide à implémenter.
Possibilité d'embelir par du CSS. -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mobility</title>
    </head>
    <body>
    
        <% 
String ss =request.getParameter("page");
System.out.println(ss);
%>
        <form action="<%out.print(ss);%>" method="post">
            <% if(ss.equals("AfficheAllHowtoServlet") || ss.equals("profil.jsp") || ss.equals("toDo.jsp") || ss.equals("Learns.jsp") || ss.equals("Words.jsp") || ss.equals("Message.jsp") || ss.equals("AfficheAllWordsServlet") )
        {
            out.print("<button name='send' type='submit' value='add'>Ajouter </button><BR>");
            if(ss.equals("AfficheAllHowtoServlet") || ss.equals("profil.jsp") || ss.equals("toDo.jsp") || ss.equals("Learns.jsp") || ss.equals("Words.jsp") || ss.equals("AfficheAllWordsServlet"))
            {
                out.print("<button name='send' type='submit' value='modif'>Modifier </button><BR>");
                if(ss.equals("AfficheAllHowtoServlet") || ss.equals("profil.jsp") || ss.equals("toDo.jsp") || ss.equals("Learns.jsp") || ss.equals("Words.jsp") || ss.equals("AfficheAllWordsServlet"))
                {
                    out.print("<button name='send' type='submit' value='supp'>Supprimer </button><BR>");
                }
            }
        }%>
        </form>
               
    </body>
</html>
