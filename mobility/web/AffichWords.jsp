<%-- 
    Document   : newjsp
    Created on : 3 juin 2016, 00:35:34
    Author     : caron
--%>

<%@page import="java.util.Iterator"%>
<%@page import="bean.Words"%>
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
        <jsp:useBean id="next" scope="request" class="bean.Words"></jsp:useBean>
        <table>  
        <tr>
            
            <th>' MOT '        </th>  
            <th>' LANGUAGE '   </th>  
            <th>' SELECTION '  </th>  
            <th>' SECTION '    </th> 
        </tr>
        <% 
                
  
           
            Iterator<Words> ite = next.lst.iterator();
            Words v1;
                
            while(ite.hasNext())
            {
                v1=ite.next();
                out.print("<tr>");
                out.print("<td>");
                out.print(v1.getWords());
                out.print("</td>");
                out.print("<td>");
                out.print(v1.getLanguage());
                out.print("</td>");
                out.print("<td>");
                out.print(v1.getSection());
                out.print("</td>");
                out.print("<td>");
                out.print(v1.getTranslation());
                out.print("</td>");
            }
                %>
                
        </table>
    <center>
     <%@include file="Words.jsp" %>
    </center>
    </body>
</html>
