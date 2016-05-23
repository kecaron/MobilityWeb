/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.beanprofil;
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
@WebServlet(name = "ProfilServlet", urlPatterns = {"/ProfilServlet"})
public class ProfilServlet extends HttpServlet {

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
System.out.println("URL parameter :"+request.getParameter("send"));
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
String sql="";
System.out.println("Querry :"+sql);
    connexion cx = new connexion("system", "mamans90", url);
    cx.connectionbase();
    cx.create_statement();
    // add it
System.out.println("URL parameter :"+request.getParameter("send"));
if(request.getParameter("send").equals("first"))
{  
    sql="SELECT (NOM,PRENOM,MAILPERSO) FROM PROFIL";
    System.out.println("Querry :"+sql);
    beanprofil profil = new beanprofil();
    ResultSet p = cx.exec(sql);
        try {
        while (p.next()) {
            profil.Nom.add(p.getString("NOM"));
            profil.Prenom.add(p.getString("PRENOM"));
            profil.Mail.add(p.getString("MAILERPSO"));
        }
    } catch (SQLException ex) {
        Logger.getLogger(ProfilServlet.class.getName()).log(Level.SEVERE, null, ex);
    
    }
    request.setAttribute("profil", profil);
    RequestDispatcher rd = request.getRequestDispatcher("/profil.jsp");
   // System.out.println("count : "+count);
    rd.forward(request, response);
    }
else
{
    RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
    //System.out.println("count : "+count);
    
    rd.forward(request, response);
}
/**        
}
if(request.getParameter("param1").equals("ins"))
{
    // redirection formulaire
}
if(request.getParameter("param1").equals("del"))
{
    sql="DELETE FROM PROFIL WHERE (MAILPERSO ="+ +" OR MAILUP10="+ +")";
    System.out.println("Querry :"+sql);
    ResultSet p = cx.exec(sql);
 }
**/
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
