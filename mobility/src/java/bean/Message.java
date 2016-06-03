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
 * @author brbathil
 */
public class Message {
    private String titre;
    private String corpse;
    private String image;
    private String datecreation;
    private String est_vu;

    public Message(){
        this.titre = "";
        this.corpse = "";
        this.image = "";
        this.datecreation = "";
        this.est_vu = "";
    }
    /**
     * @return the titre
     */
    public String getTitre() {
        return titre;
    }

    /**
     * @param titre the titre to set
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * @return the corpse
     */
    public String getCorps() {
        return corpse;
    }

    /**
     * @param corps the corpse to set
     */
    public void setCorps(String corps) {
        this.corpse = corps;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the datecreation
     */
    public String getDate() {
        return datecreation;
    }

    /**
     * @param date the datecreation to set
     */
    public void setDate(String date) {
        this.datecreation = date;
    }

    /**
     * @return the est_vu
     */
    public String getEst_vu() {
        return est_vu;
    }

    /**
     * @param est_vu the est_vu to set
     */
    public void setEst_vu(String est_vu) {
        this.est_vu = est_vu;
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
            PreparedStatement pst = cx.prepareStatement("INSERT INTO Message VALUES (?,?,?,?,?)");
            pst.setString(1, this.titre);
            pst.setString(2, this.corpse);
            pst.setString(3, this.image);
            pst.setString(4, this.datecreation);
            pst.setString(5, this.est_vu);
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
            PreparedStatement pst = cx.prepareStatement("DELETE FROM Message WHERE titre=?");
            pst.setString(1, this.titre);
            pst.executeUpdate();
            pst.close();
            cx.close();
        }
        catch(SQLException ex){
            System.out.println("Erreur de connection");
            System.exit(1);
        }
    }
    public void update(){
       try{
            Class.forName(BDD.DRIVER);
        }
        catch(ClassNotFoundException ex){
            System.out.println("La classe "+BDD.DRIVER+"n'a pas été trouvée");
            ex.printStackTrace();
        }
        try{
            Connection cx=DriverManager.getConnection(BDD.URL,BDD.LOGIN,BDD.PASSWORD);
            PreparedStatement pst = cx.prepareStatement("UPDATE Message SET corpse='?', image='?', datecreation='?', est_vu='?' WHRE titre='?' ");
            pst.setString(5, this.titre);
            pst.setString(1, this.corpse);
            pst.setString(2, this.image);
            pst.setString(3, this.datecreation);
            pst.setString(4, this.est_vu);
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
