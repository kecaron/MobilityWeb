/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;
import DOA.BDD;
import java.beans.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author titadone
 */
public class Howto {
    private String idhowto;
    private String corpse;
    private String title;
    
    public Howto(){
        this .idhowto= "null";
        this.corpse = "texte vide";
        this.title = "titre vide";
    }

    /**
     * @return the idhowto
     */
    public String getIdhowto() {
        return idhowto;
    }

    /**
     * @param idhowto the idhowto to set
     */
    public void setIdhowto(String idhowto) {
        this.idhowto = idhowto;
    }

    /**
     * @return the corpse
     */
    public String getCorpse() {
        return corpse;
    }

    /**
     * @param corpse the corpse to set
     */
    public void setCorpse(String corpse) {
        this.corpse = corpse;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
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
            PreparedStatement pst = cx.prepareStatement("INSERT INTO Howto VALUES (?,?,?)");
            pst.setString(1, this.idhowto);
            pst.setString(2, this.title);
            pst.setString(3, this.corpse);
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
            PreparedStatement pst = cx.prepareStatement("DELETE FROM Howto WHERE idhowto=?");
            pst.setString(1, this.idhowto);
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
            PreparedStatement pst = cx.prepareStatement("UPDATE Howto SET body='?', title='?', WHERE idhowto='?' ");
            pst.setString(1, this.corpse);
            pst.setString(2, this.title);
            pst.setString(3, this.idhowto);
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
