<%-- 
    Document   : Profil
    Created on : 17 mai 2016, 20:24:50
    Author     : caron
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <h1>Hello : Voici tes Notes </h1>
        <table>


      
        <jsp:useBean id="profil" scope="request" class="bean.beanprofil"></jsp:useBean>
    <table>  
        <tr>  
            <th>NOM  </th>  
            <th>PRENOM </th>  
            <th>MAIL  </th>  
            <th>INSERER </th> 
            <th>MODIFIER </th>  
            <th>SUPRIMER </th> 
        </tr>
        <%  
            Iterator<ArrayList> ite = profil.getNom().iterator();
            Iterator<ArrayList> ite2 = profil.getPrenom().iterator();
            Iterator<ArrayList> ite3 = profil.getMail().iterator();
            String v1;
            String v2;
            String v3;
            while(ite.hasNext() && ite2.hasNext() && ite3.hasNext())
            {
                v1=ite.next().toString();
                v2=ite2.next().toString();
                v3=ite.next().toString();
                out.print("<tr>");
                out.print("<td>");
                out.print(v1);
                out.print("</td>");
                out.print("<td>");
                out.print(v2);
                out.print("</td>");
                out.print("<td>");
                out.print(v3);
                out.print("</td>");
                out.print("<td>");
                 out.print("<a href='/ProfilServelt?param1=ins&param2="+v1+"'><img src='tonimage.jpg' alt='tonimage' /></a>");
                out.print("</td>");
                out.print("<td>");
                 out.print("<a href='/ProfilServelt?param1=mod&param2="+v2+"'><img src='tonimage.jpg' alt='tonimage' /></a>");
                out.print("</td>");
                out.print("<td>");
                out.print("<a href='/ProfilServelt?param1=del&param2="+v3+"'><img src='tonimage.jpg' alt='tonimage' /></a>");
                out.print("</td>");
            }
            %>
      
    </table>
    </body>
</html>
