/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sql.connexion;

/**
 *
 * @author caron
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                        String name = request.getParameter("login");
System.out.println("Login :"+name);
String pass = request.getParameter("pass");
System.out.println("Pass :"+pass);
int count=-2;
String url = "jdbc:oracle:thin:@localhost:1521:XE";
String sql = "SELECT COUNT (MAILPERSO) AS ttc FROM PROFIL WHERE (MAILPERSO='"+name+"' OR MAILUP10='"+name+"') AND PASS='"+pass+"'";
System.out.println("Querry :"+sql);
connexion cx = new connexion("system", "mamans90", url);
cx.connectionbase();
cx.create_statement();
ResultSet p = cx.exec(sql);
if (p == null) {
    count =-1;
} else {
    while (p.next()) {
     count=p.getInt("ttc");
    }
}
p.close();
cx.close();
// if count !=1 rejette 
if (count!=1)
{
    RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
    System.out.println("count : "+count);
    rd.forward(request, response);

} else {
    RequestDispatcher rd = request.getRequestDispatcher("/adminPanel.jsp");
    System.out.println("count : "+count);
    rd.forward(request, response);
    }
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
