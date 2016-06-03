<%-- 
    Document   : Words
    Created on : 2 juin 2016, 22:38:00
    Author     : caron
--%>

<%@page import="bean.Words"%>
<%@page import="java.util.Iterator"%>
<%@page import="bean.beanprofil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mobility</title>
    </head>
    <body>
        <form  method="POST" action="WordsServlet">
            <% 
            
                if(request.getParameter("send").equals("add") || request.getParameter("send").equals("modif") )
            {
               out.print("<div>");
               out.print("<label for='mot'>Mot</label>");
               out.print("<input type='text' name='mot' />");
               out.print("</div>");
                out.print("<div>");
                out.print("<label for='language'>language</label>");
                out.print("<input type='text' name='language' />");
                out.print("</div>");
                out.print("<div>");
                out.print("<label for='translation'>translation :</label>");
                out.print("<input type='text' name='translation'/>");
                out.print("</div>");
                out.print("<div>");
                out.print("<label for='section'>section :</label>");
                out.print("<input type='text' name='section' />");
                out.print("</div>");
                out.print("<div>");
                out.print("<button type='submit' name='send' value='"+request.getParameter("send")+"'>Envoyer votre word </button>");
                out.print("</div>"); 
               }
               else
               {
                out.print("<div>");
                out.print("<label for='mot'>Mot</label>");
                out.print("<input type='text' name='mot' />");
                out.print("</div>");
                out.print("<div>");
                out.print("<button type='submit' name='send' value='"+request.getParameter("send")+"'>Envoyer votre word </button>");
                out.print("</div>"); 
               }
               
    %>
    
        </form>
    </body>
</html>
