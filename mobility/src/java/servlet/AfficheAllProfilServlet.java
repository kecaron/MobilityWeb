/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DOA.BDD;
import bean.Profile;
import bean.beanprofil;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
public class AfficheAllProfilServlet extends HttpServlet {

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
            // j'utilise deux beans différent pour question de BDD, après harmonisation il reste que la bean profile
            beanprofil profil = new beanprofil();
            Profile next = new Profile();
            String s=request.getParameter("send");
            String s2=request.getParameter("send2");
            RequestDispatcher rd;
            System.out.println("URL parameter :"+request.getParameter("send"));
            System.out.println("Get in Servlet 1");
            // premier check depuis panel : au premier jet on entre dans first pour afficher la base
            switch (s)
            {
                case "first":
                    profil.send(); 
                    request.setAttribute("profil", profil);
                    rd = request.getRequestDispatcher("/AffichProfil.jsp");
                    // System.out.println("count : "+count);
                    rd.forward(request, response);
                    break;
               
                default :    
                    rd = request.getRequestDispatcher("/error.jsp");
                    //System.out.println("count : "+count); 
                    rd.forward(request, response);
            }
            // quand le formulaire nous redispatch

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
