/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import servlet.ProfilServlet;
import sql.connexion;

/**
 *
 * @author caron
 */
public class beanprofil {
public List Nom = new ArrayList();
public List Prenom = new ArrayList();
public List Mail = new ArrayList();

    
    public List getNom() {
        return Nom;
    }

    public List getPrenom() {
        return Prenom;
    }

    public List getMail() {
        return Mail;
    }
    
    
    
}
