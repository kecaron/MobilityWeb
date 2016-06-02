/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import DOA.BDD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
public String Nom;
public String Prenom;
public String Mail;
public static List<beanprofil> lst;

    public beanprofil(String n,String p,String m)
    {
        Nom=n;
        Prenom=p;
        Mail=m;
    }
    public beanprofil()
    {
        lst=new ArrayList<beanprofil>();
    }
    
    public String getNom() {
        return Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public String getMail() {
        return Mail;
    }
    
    public void send()
    {
            try{
            Class.forName(BDD.DRIVER);
        }
        catch(ClassNotFoundException ex){
            System.out.println("La classe "+BDD.DRIVER+"n'a pas été trouvée");
            ex.printStackTrace();
        }
         
    String sql="SELECT * FROM PROFIL";
    System.out.println("Querry :"+sql);
    try{
            Connection cx=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","mamans90");
            PreparedStatement pst = cx.prepareStatement(sql);
            ResultSet p = pst.executeQuery();
            while (p.next()) {
                // ne prends que la dernière colonne 
            Nom=p.getString("NOM");
            Prenom=p.getString("PRENOM");
            Mail=p.getString("MAILPERSO");
            lst.add(new beanprofil(Nom,Prenom,Mail));
        }
        pst.close();
        cx.close();
    } catch (SQLException ex) {
        Logger.getLogger(ProfilServlet.class.getName()).log(Level.SEVERE, null, ex);
    
    }
    }
    
    
}
