<%-- 
    Document   : AffichHowto
    Created on : 2 juin 2016, 20:44:53
    Author     : caron
--%>

<%@page import="java.util.Iterator"%>
<%@page import="bean.Howto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mobility</title>
        <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
        <link rel="stylesheet" href="css/side-menu.css">
    </head>
    <body>
        <div id="layout">
            <%@include  file="sideMenu.html" %></div>
        <jsp:useBean id="howto" scope="request" class="bean.Howto"></jsp:useBean>
        <table>  
        <tr>  
            <th>' ID '</th>  
            <th>' titre '</th>  
            <th>' Contenu '</th>  
        </tr>
        <% 
                
  
           
            Iterator<Howto> ite = howto.lst.iterator();
            Howto v1;
                
            while(ite.hasNext())
            {
                v1=ite.next();
                out.print("<tr>");
                out.print("<td>");
                out.print(v1.getIdhowto());
                out.print("</td>");
                out.print("<td>");
                out.print(v1.getTitle());
                out.print("</td>");
                out.print("<td>");
                out.print(v1.getCorpse());
                out.print("</td>");
            }
                %>
                
        </table>
    <center>
     <%@include file="Howto.jsp" %>
    </center>
    </body>
</html>
