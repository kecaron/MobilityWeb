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
@WebServlet(name = "ProfilServlet3", urlPatterns = {"/ProfilServlet3"})
public class ProfilServlet3 extends HttpServlet {

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
            System.out.println("URL parameter :"+request.getParameter("send2"));
            System.out.println("Get in Servlet 3");
            // troisième entrée : on set la bean pour ajouter / update le profil
            switch (s2)
            {
                
                case "add":
                    next.setNom(request.getParameter("nom"));
                    next.setPrenom(request.getParameter("prenom"));
                    next.setIdetudiant(request.getParameter("mail1"));
                    next.setPassword(request.getParameter("password"));
                    next.setMail1(request.getParameter("mail1"));
                    next.setMail2(request.getParameter("mail2"));
                    next.setMobile_phone(request.getParameter("mobile_phone"));
                    next.setDate_naissance(request.getParameter("date_naissance"));
                    next.setNationalite(request.getParameter("nationalite"));
                    next.setDroit(request.getParameter("droit"));
                    next.setAvatar(request.getParameter("avatar"));
                    next.setUniversite(request.getParameter("universite"));
                    next.inserer();
                     rd = request.getRequestDispatcher("/adminPanel.jsp");
                    // System.out.println("count : "+count);
                    rd.forward(request, response);break;
                case "update":
                    next.setNom(request.getParameter("nom"));
                    next.setPrenom(request.getParameter("prenom"));
                    next.setIdetudiant(request.getParameter("mail1"));
                    next.setPassword(request.getParameter("password"));
                    next.setMail1(request.getParameter("mail1"));
                    next.setMail2(request.getParameter("mail2"));
                    next.setMobile_phone(request.getParameter("mobile_phone"));
                    next.setDate_naissance(request.getParameter("date_naissance"));
                    next.setNationalite(request.getParameter("nationalite"));
                    next.setDroit(request.getParameter("droit"));
                    next.setAvatar(request.getParameter("avatar"));
                    next.setUniversite(request.getParameter("universite"));
                    next.update();
                    rd = request.getRequestDispatcher("/adminPanel.jsp");
                    // System.out.println("count : "+count);
                    rd.forward(request, response);break;
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
