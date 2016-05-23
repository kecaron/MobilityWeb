<%-- 
    Document   : Howto.jsp
    Created on : 23 mai 2016, 15:57:39
    Author     : caron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%@include  file="sideMenu.html" %>
        <div>TODO write content</div>
        
        <form action="HowTo" method="post">  
            <% String ss =request.getParameter("send");
                if(ss.equals("supp"))    
                {
                    out.print("<div>");
                    out.print("<label for='id'>id du  how to :</label>");
                    out.print("<input type='text' name='idhowto' />");
                    out.print("</div>");
                }
        else
        {
            
        out.print("<div>");
        out.print("<label for='id'>id du  how to :</label>");
        out.print("<input type='text' name='idhowto' />");
        out.print("</div>");
        out.print("<div>");
        out.print("<label for='contenue'>titre  how to :</label>");
        out.print("<input type='text' name='titre' />");
        out.print("</div>");
        out.print("<div>");
        out.print("<label for='contenu'>Contenu :</label>");
        out.print("<input type='text' name='contenu' />");
        out.print("</div>");
                }
            %>
            
             <div>
               <button name ="send" type="submit" value="<%out.print(ss);%>">Send </button><BR>
        
    </div>
</form>
        
    </body>
</html>
