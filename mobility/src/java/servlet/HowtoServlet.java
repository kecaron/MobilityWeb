/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.Howto;
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
@WebServlet(name = "HowTo", urlPatterns = {"/HowTo"})
public class HowtoServlet extends HttpServlet {

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
          String id =request.getParameter("idhowto");
          String titre =request.getParameter("titre");
          String contenu =request.getParameter("contenu");
          String type =request.getParameter("send");
          // on récupère les données du formulaire, on vérifie le send qui donne ce que souhaite user(add,supp,update)
          System.out.println(type);
          Howto objet = new Howto();
          objet.setCorpse(contenu);
          objet.setTitle(titre);
          // revoir l'ID ( long ou string ?) , user doit le fournir ou c'est un ajout automatique ?
          objet.setIdhowto(id);
          RequestDispatcher rd;
          // on set les items plus le request dispatch : on effectue l'une des 3 actions et si problème on default error
          switch(type)
          {
              case "add" :
                     objet.inserer();
                     break;
              case "supp":
                  objet.supprimer();
                  break;
              case "modif" :
                  objet.update();
                  break;
      
              default :
                 rd = request.getRequestDispatcher("/error.jsp");
                 rd.forward(request, response);
                  break;
          }
          // problème connexion BDD à résoudre, Problème au niveau de l'entrée serveur ?
         // fin de la request on set pour revenir sur l'adminpanel.
          rd = request.getRequestDispatcher("/adminPanel.jsp");
         rd.forward(request, response);  
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