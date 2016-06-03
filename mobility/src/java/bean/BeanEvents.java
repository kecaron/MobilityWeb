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
import java.sql.SQLException;

/**
 *
 * @author sadaurin
 */
public class BeanEvents {

    private String idEvent;
    private String titre;
    private String corp;
    private String image;
    private String date;
    private String est_vue;

//    public BeanEvents(String a, String c, String d, String e, String f) {
//        this.idEvent = a;
//       // this.titre = b;
//        this.corp=c;
//        this.image=d;
//        this.date=e;
//        this.est_vue=f;
//       }
    
    
    public BeanEvents(){
        
    }

    public String getIdEvent() {
        return idEvent;
    }

    public String getTitre() {
        return titre;
    }

    public String getCorp() {
        return corp;
    }

    public String getImage() {
        return image;
    }

    public String getDate() {
        return date;
    }

    public String getEst_vue() {
        return est_vue;
    }

    public void setIdEvent(String idEvent) {
        this.idEvent = idEvent;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setCorp(String corp) {
        this.corp = corp;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setEst_vue(String est_vue) {
        this.est_vue = est_vue;
    }
    
     public void inserer(){
        try{
            Class.forName(BDD.DRIVER);
        }
        catch(ClassNotFoundException ex){
            System.out.println("La classe "+BDD.DRIVER+"n'a pas été trouvée");
            ex.printStackTrace();
        }
        try{
            Connection cx=DriverManager.getConnection(BDD.URL,BDD.LOGIN,BDD.PASSWORD);
            PreparedStatement pst = cx.prepareStatement("INSERT INTO Events VALUES (?,?,?,?,?)");
            pst.setString(1, this.idEvent);
            pst.setString(2, this.titre);
            pst.setString(3, this.corp);
            pst.setString(4, this.image);
            pst.setString(5, this.date);
            pst.executeUpdate();
            pst.close();
            cx.close();
        }
        catch(SQLException ex){
            System.out.println("Erreur de connection");
            System.exit(1);
        }
    }
    
   public void supprimer(){
        try{
            Class.forName(BDD.DRIVER);
        }
        catch(ClassNotFoundException ex){
            System.out.println("La classe "+BDD.DRIVER+"n'a pas été trouvée");
            ex.printStackTrace();
        }
        try{
            Connection cx=DriverManager.getConnection(BDD.URL,BDD.LOGIN,BDD.PASSWORD);
            PreparedStatement pst = cx.prepareStatement("DELETE FROM Events WHERE idtitre=?");
            pst.setString(1, this.idEvent);
            pst.executeUpdate();
            pst.close();
            cx.close();
        }
        catch(SQLException ex){
            System.out.println("Erreur de connection");
            System.exit(1);
        }
    }
}
