<%-- 
    Document   : profil2
    Created on : 23 mai 2016, 23:13:15
    Author     : caron
--%>

<%@page import="bean.Profile"%>
<%@page import="bean.beanprofil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mobility</title>
    </head>
    <%
        Profile p = new Profile();
        System.out.println(request.getParameter("mail"));
        if(request.getParameter("send").equals("update"))
        {
            p.send(request.getParameter("mail"));
        }
    %>
    <body>
        <div>
            <form  method="POST" action="ProfilServlet3">

      <div>
        <label for="nom">nom/</label>
        <input type="text" name="nom" value='<%=p.getNom()%>' />
    </div>
    <div>
        <label for="prenom">prenom :</label>
        <input type="text" name="prenom" value='<%=p.getPrenom()%>'/>
    </div>
    
    <div>
        <label for="password">password :</label>
        <input type="text" name="password" value='<%=p.getPassword()%>'/>
    </div>
            
            <div>
        <label for="date_naissance">date_naissance :</label>
        <input type="text" name="date_naissance" value='<%=p.getDate_naissance()%>'/>
    </div>
    
          <div>
        <label for="mobile_phone">mobile_phone :</label>
        <input type="text" name="mobile_phone" value='<%=p.getMobile_phone()%>'/>
    </div>
    <div>
        <label for="mail1">mail1 :</label>
        <input type="text" name="mail1" value='<%=p.getMail1()%>'>
    </div>
            
            <div>
        <label for="mail2">mail2 :</label>
        <input type="text" name="mail2" value='<%=p.getMail2()%>'/>
    </div>      <div>
        <label for="nationalite">nationalite/</label>
        <input type="text" name="nationalite" value='<%=p.getNationalite()%>' />
    </div>
    <div>
        <label for="universite">universite/</label>
        <input type="text" name="universite" value='<%=p.getUniversite()%>' />
    </div>
    <div>
        <label for="avatar">avatar :</label>
        <input type="text" name="avatar" value='<%=p.getAvatar()%>'/>
    </div>
            
            <div>
        <label for="droit">droit :</label>
        <input type="text" name="droit" value='<%=p.getDroit()%>'/>
    </div>
     <label for="send2"> Send it :</label>
    <input type="submit" name="send2" value='<%=request.getParameter("send")%>'>
            </form>
    
        </div>
    </body>
</html>
