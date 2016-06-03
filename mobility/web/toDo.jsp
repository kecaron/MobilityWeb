<%-- 
    Document   : toDo
    Created on : 16 mai 2016, 13:22:04
    Author     : Yann
--%>

<%@page import="java.util.Iterator"%>
<%@page import="bean.Todo"%>
<%@page import="bean.Howto"%>
<%@page import="bean.Howto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
        <link rel="stylesheet" href="css/side-menu.css">
    </head>
    <body>
        <div id="layout">
            <%@include  file="sideMenu.html" %></div>
        <jsp:useBean id="howto" scope="request" class="bean.Howto"></jsp:useBean>
        <table>  
        <tr>  
            <th>IDTODO  </th>  
            <th>TASK </th>  
            <th>STATUS  </th>
            <th>CREATOR  </th>
            <th>DATECREATION  </th>
        </tr>
        <% 
                
  
            Todo p1 = new Todo();
            p1.send();
            Iterator<Todo> ite = p1.lst.iterator();
            Todo v1;
                
            while(ite.hasNext())
            {
                v1=ite.next();
                out.print("<tr>");
                out.print("<td>");
                out.print(v1.getIdtodo());
                out.print("</td>");
                out.print("<td>");
                out.print(v1.getTask());
                out.print("</td>");
                out.print("<td>");
                out.print(v1.getStatus());
                out.print("</td>");
                out.print("<td>");
                out.print(v1.getTask());
                out.print("</td>");
                out.print("<td>");
                out.print(v1.getStatus());
                out.print("</td>");
                out.print("<td>");
                out.print(v1.getCreator());
                out.print("</td>");
                out.print("<td>");
                out.print(v1.getDateCreation());
                out.print("</td>");
            }
                %>
                
        </table>
    <center>
            <div id="main">
                
                <div class="header">
                    <h1>Page Title</h1>
                    <h2>A subtitle for your page goes here</h2>
                    
                    <a href="#taskList">Task list</a>
                    <a href="#create">Create task</a>
                </div>

                <div class="content">
                    <a name="taskList"></a>
                    <h2 class="content-subhead">Task list</h2>
                    <form role="form" action="toDoServlet" method="post">
                           
                    </form>
                    <a name="create"></a>
                    <h2 class="content-subhead">Create task</h2>
                    <form role="form" action="toDoServlet" method="post">
                           <label>Task : </label>
                           <input type="text" placeholder="Task..." name="task" id="task" />
                           <input type="submit" value="<%=request.getParameter("send")%>" name="send" >
                    </form>
                </div>
            </div>
    </center>
        <script src="js/ui.js"></script>
    </body>
</html>
