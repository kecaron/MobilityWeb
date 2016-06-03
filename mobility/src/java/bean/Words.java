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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author titadone
 */
public class Words {
    private String idwords;
    private String words;
    private String language;
    private String translation;
    private String section;
    public static List<Words> lst;
    
    public Words(){
        this.idwords="";
        this.words="";
        this.language="";
        this.translation="";
        this.section="";
        lst= new ArrayList<Words>();
    }
    public Words(String id,String w,String l,String t,String s){
        this.idwords=id;
        this.words=w;
        this.language=l;
        this.translation=t;
        this.section=s;
    }

    /**
     * @return the idwords
     */
    public String getIdwords() {
        return idwords;
    }

    /**
     * @param idwords the idwords to set
     */
    public void setIdwords(String idwords) {
        this.idwords = idwords;
    }

    /**
     * @return the words
     */
    public String getWords() {
        return words;
    }

    /**
     * @param words the words to set
     */
    public void setWords(String words) {
        this.words = words;
    }

    /**
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language the language to set
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @return the translation
     */
    public String getTranslation() {
        return translation;
    }

    /**
     * @param translation the translation to set
     */
    public void setTranslation(String translation) {
        this.translation = translation;
    }

    /**
     * @return the section
     */
    public String getSection() {
        return section;
    }

    /**
     * @param section the section to set
     */
    public void setSection(String section) {
        this.section = section;
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
            PreparedStatement pst = cx.prepareStatement("INSERT INTO Words VALUES (?,?,?,?,?)");
            pst.setString(1, this.idwords);
            pst.setString(2, this.words);
            pst.setString(3, this.language);
            pst.setString(4, this.translation);
            pst.setString(5, this.section);
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
            PreparedStatement pst = cx.prepareStatement("DELETE FROM Words WHERE IDWORDS=?");
            pst.setString(1, this.idwords);
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
            PreparedStatement pst = cx.prepareStatement("UPDATE Words SET mots=?, langue=?, translated=?, section=? WHRERE idwords=? ");
            //PreparedStatement pst2 = cx.prepareStatement("UPDATE Howto  SET title=?, corpse=? WHERE idhowto=? ");
            pst.setString(1, this.words);
            pst.setString(2, this.language);
            pst.setString(3, this.translation);
            pst.setString(4, this.section);
            pst.setString(5, this.idwords);
            pst.executeUpdate();
            pst.close();
            cx.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void send() {
        //System.out.println(id);
        try{
            Class.forName(BDD.DRIVER);
        }
        catch(ClassNotFoundException ex){
            System.out.println("La classe "+BDD.DRIVER+"n'a pas été trouvée");
            ex.printStackTrace();
        }
        try{
            Connection cx=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","mamans90");
            PreparedStatement pst = cx.prepareStatement("SELECT * FROM WORDS");
            ResultSet p = pst.executeQuery();
            while (p.next()) {
                words=p.getString("MOTS");
                language=p.getString("LANGUE");
                translation=p.getString("TRANSLATED");
                section=p.getString("SECTION");
                lst.add(new Words(words,words,language,translation,section));
                       
            }
            
        }
        catch(SQLException ex){
            System.out.println("Erreur de connection");
            System.exit(1);
        }
    }
}