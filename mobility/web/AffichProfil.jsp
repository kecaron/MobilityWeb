<%-- 
    Document   : Profil
    Created on : 17 mai 2016, 20:24:50
    Author     : caron
--%>

<%@page import="bean.beanprofil"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mobility</title>
    </head>
        <%@include  file="sideMenu.html" %>

      
        <jsp:useBean id="profil" scope="request" class="bean.beanprofil"></jsp:useBean>
    <table>  
        <tr>  
            <th>NOM      </th>  
            <th>PRENOM   </th>  
            <th>MAIL     </th>  
            <th>INSERER  </th> 
            <th>MODIFIER </th>  
            <th>SUPRIMER </th> 
        </tr>
        <%  
            Iterator<beanprofil> ite = profil.lst.iterator();
            beanprofil v1;

            while(ite.hasNext())
            {
                v1=ite.next();
                out.print("<tr>");
                out.print("<td>");
                out.print(v1.getNom());
                out.print("</td>");
                out.print("<td>");
                out.print(v1.getPrenom());
                out.print("</td>");
                out.print("<td>");
                out.print(v1.getMail());
                out.print("</td>");
                out.print("<td>");
                 out.print("<a href='/mobility/ProfilServlet2?send=add'><img src='add.png' alt='tonimage' /></a>");
                out.print("</td>");
                out.print("<td>");
                 out.print("<a href='/mobility/ProfilServlet2?send=update&mail="+v1.getMail()+"'><img src='modif.png' alt='tonimage' /></a>");
                out.print("</td>");
                out.print("<td>");
                out.print("<a href='/mobility/ProfilServlet2?send=supp&mail="+v1.getMail()+"'><img src='suppr.png' alt='tonimage' /></a>");
                out.print("</td>");
            }
            %>
      
    </table>
    </body>
</html>
