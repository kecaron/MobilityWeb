<%-- 
    Document   : toDo
    Created on : 16 mai 2016, 13:22:04
    Author     : Yann
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
        <link rel="stylesheet" href="css/side-menu.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="layout">
            <%@include  file="sideMenu.html" %>
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
        </div>
        <script src="js/ui.js"></script>
    </body>
</html>
