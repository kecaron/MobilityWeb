/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;
import DOA.BDD;
import java.beans.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author titadone
 */
public class Profile {
    private String idetudiant;
    private String nom;
    private String prenom;
    private String date_naissance;
    private String mobile_phone;
    private String mail1;
    private String mail2;
    private String nationalite;
    private String universite;
    private String password;
    private String avatar;
    private String droit;
    
    public Profile(){
        this.idetudiant="";
        this.nom="";
        this.prenom="";
        this.date_naissance="";
        this.mobile_phone="";
        this.mail1="";
        this.mail2="";
        this.nationalite="";
        this.universite="";
        this.password="";
        this.avatar="";
        this.droit="";
    }

    /**
     * @return the idetudiant
     */
    public String getIdetudiant() {
        return idetudiant;
    }

    /**
     * @param idetudiant the idetudiant to set
     */
    public void setIdetudiant(String idetudiant) {
        this.idetudiant = idetudiant;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the date_naissance
     */
    public String getDate_naissance() {
        return date_naissance;
    }

    /**
     * @param date_naissance the date_naissance to set
     */
    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    /**
     * @return the mobile_phone
     */
    public String getMobile_phone() {
        return mobile_phone;
    }

    /**
     * @param mobile_phone the mobile_phone to set
     */
    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    /**
     * @return the mail1
     */
    public String getMail1() {
        return mail1;
    }

    /**
     * @param mail1 the mail1 to set
     */
    public void setMail1(String mail1) {
        this.mail1 = mail1;
    }

    /**
     * @return the mail2
     */
    public String getMail2() {
        return mail2;
    }

    /**
     * @param mail2 the mail2 to set
     */
    public void setMail2(String mail2) {
        this.mail2 = mail2;
    }

    /**
     * @return the nationalite
     */
    public String getNationalite() {
        return nationalite;
    }

    /**
     * @param nationalite the nationalite to set
     */
    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    /**
     * @return the universite
     */
    public String getUniversite() {
        return universite;
    }

    /**
     * @param universite the universite to set
     */
    public void setUniversite(String universite) {
        this.universite = universite;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * @param avatar the avatar to set
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * @return the droit
     */
    public String getDroit() {
        return droit;
    }

    /**
     * @param droit the droit to set
     */
    public void setDroit(String droit) {
        this.droit = droit;
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
            PreparedStatement pst = cx.prepareStatement("INSERT INTO Profil VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, this.idetudiant);
            pst.setString(2, this.nom);
            pst.setString(3, this.prenom);
            pst.setString(4, this.date_naissance);
            pst.setString(5, this.mobile_phone);
            pst.setString(6, this.mail1);
            pst.setString(7, this.mail2);
            pst.setString(8, this.nationalite);
            pst.setString(9, this.universite);
            pst.setString(10, this.password);
            pst.setString(11,this.avatar);
            pst.setString(12, this.droit);
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
            PreparedStatement pst = cx.prepareStatement("DELETE FROM Profil WHERE idetudiant=?");
            pst.setString(1, this.getIdetudiant());
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
            PreparedStatement pst = cx.prepareStatement("UPDATE Profil SET nom=?, prenom=?, date_naissance=?, mobile_phone=?, mailperso=?, mailup10=?, nationalite=?, universite=?, password=?, avatar=?, droit=? WHERE idetudiant=?");
            //PreparedStatement pst = cx.prepareStatement("UPDATE Profil SET nom=? WHERE idetudiant=?");
            pst.setString(1, this.nom);
            pst.setString(12, this.idetudiant);
            pst.setString(2, this.prenom);
            pst.setString(3, this.mail2);
            pst.setString(4, this.mail1);
            pst.setString(5, this.mobile_phone);
            pst.setString(6, this.nationalite);
            pst.setString(7, this.droit);
            pst.setString(8, this.universite);
            pst.setString(9,this.avatar);
            pst.setString(10, this.date_naissance);
            pst.setString(11, this.password);
            pst.executeUpdate();
            pst.close();
            cx.close();
        } catch (SQLException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void send(String id){
        System.out.println(id);
        try{
            Class.forName(BDD.DRIVER);
        }
        catch(ClassNotFoundException ex){
            System.out.println("La classe "+BDD.DRIVER+"n'a pas été trouvée");
            ex.printStackTrace();
        }
        try{
            Connection cx=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","mamans90");
            PreparedStatement pst = cx.prepareStatement("SELECT * FROM PROFIL WHERE IDETUDIANT='"+id+"'");
            ResultSet p = pst.executeQuery();
            while (p.next()) {
                this.nom=p.getString("NOM");
                this.prenom=p.getString("PRENOM");
                this.password=p.getString("PASSWORD");
                this.universite=p.getString("UNIVERSITE");
                this.avatar=p.getString("AVATAR");
                this.date_naissance=p.getString("DATE_NAISSANCE");
                this.droit=p.getString("DROIT");
                this.idetudiant=p.getString("IDETUDIANT");
                this.mail1=p.getString("MAILPERSO");
                this.mail2=p.getString("MAILUP10");
                this.mobile_phone=p.getString("MOBILE_PHONE");
                this.nationalite=p.getString("NATIONALITE");
            }
            pst.close();
            cx.close();
        }
        catch(SQLException ex){
            System.out.println("Erreur de connection");
            System.exit(1);
        }
    }
    
    
    public void afficher(){
        
    }
}
