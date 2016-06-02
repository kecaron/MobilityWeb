/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.Profile;
import bean.beanprofil;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author caron
 */
@WebServlet(name = "ProfilServlet2", urlPatterns = {"/ProfilServlet2"})
public class ProfilServlet2 extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            beanprofil profil = new beanprofil();
            Profile next = new Profile();
            String s=request.getParameter("send");
            String s2=request.getParameter("send2");
            RequestDispatcher rd;
            System.out.println("Get in Servlet 2");
            System.out.println("URL parameter :"+request.getParameter("send"));
            // second check : on regarde ce que l'utilisateur à choisit (add/supp/update)
            // on récupère le mail via de DoGet (je ne vois pas comment faire autrement)
            // qu'on dispatch vers la JSP profil2 de la même façon (solution pour stocker le mail? cookie?
            switch (s)
            {
                case "add":
                    //on entre dans le formulaire pour ajouter une personne
                     rd = request.getRequestDispatcher("/profil2.jsp?send=add");
                    rd.forward(request, response);
                    break;
                case "update":
                    // on entre dans le formulaire pré-remplie pour modifier une personne
                    rd = request.getRequestDispatcher("/profil2.jsp?send=update&mail="+request.getParameter("mail"));
                    // System.out.println("count : "+count);
                    rd.forward(request, response);break;
                case  "supp" :
                    // on set id=mail et on supprime l'etudiant de façon directe.
                    // image et non radio bouton (donc une seule entité par clic)
                  
                    next.setIdetudiant(request.getParameter("mail"));
                    next.supprimer();
                    rd = request.getRequestDispatcher("/adminPanel.jsp");
                    rd.forward(request, response);
                    break;
                default :    rd = request.getRequestDispatcher("/error.jsp");
    //System.out.println("count : "+count);
    
    rd.forward(request, response);
            }
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
