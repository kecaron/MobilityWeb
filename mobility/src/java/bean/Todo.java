/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;
import DOA.BDD;
import static bean.Words.lst;
import java.beans.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author titadone
 */
public class Todo {
    private String idtodo;
    private String task;
    private String status;
    private String creator;
    private String dateCreation;
    public static List<Todo> lst;
    public Todo(){
        this.idtodo="";
        this.task="";
        this.status ="";
        this.creator="";
        this.dateCreation="";
        lst = new ArrayList<Todo>();
    }
     public Todo(String id,String task,String status,String creator,String date){
        this.idtodo=id;
        this.task=task;
        this.status =status;
        this.creator=creator;
        this.dateCreation=date;
        lst = new ArrayList<Todo>();
    }

    /**
     * @return the idhowto
     */
    public String getIdtodo() {
        return idtodo;
    }

    /**
     * @param idhowto the idhowto to set
     */
    public void setIdtodo(String idtodo) {
        this.idtodo = idtodo;
    }

    /**
     * @return the task
     */
    public String getTask() {
        return task;
    }

    /**
     * @param task the task to set
     */
    public void setTask(String task) {
        this.task = task;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the creator
     */
    public String getCreator() {
        return creator;
    }

    /**
     * @param creator the creator to set
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * @return the dateCreation
     */
    public String getDateCreation() {
        return dateCreation;
    }

    /**
     * @param dateCreation the dateCreation to set
     */
    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
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
            PreparedStatement pst = cx.prepareStatement("INSERT INTO Todo VALUES (?,?,?,?,?)");
            pst.setString(1, this.idtodo);
            pst.setString(2, this.task);
            pst.setString(3, this.status);
            pst.setString(4, this.creator);
            pst.setString(5, this.dateCreation);
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
            PreparedStatement pst = cx.prepareStatement("DELETE FROM Todo WHERE idtodo=?");
            pst.setString(1, this.idtodo);
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
            PreparedStatement pst = cx.prepareStatement("UPDATE Todo SET task='?', status='?', creator='?', dateCreation='?' WHRE idtodo='?' ");
            pst.setString(1, this.task);
            pst.setString(2, this.status);
            pst.setString(3, this.creator);
            pst.setString(4, this.dateCreation);
            pst.setString(5,this.idtodo);
            pst.executeUpdate();
            pst.close();
            cx.close();
        }
        catch(SQLException ex){
            System.out.println("Erreur de connection");
            System.exit(1);
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
            PreparedStatement pst = cx.prepareStatement("SELECT * FROM TODO");
            ResultSet p = pst.executeQuery();
            while (p.next()) {
                idtodo=p.getString("idtodo");
                task=p.getString("task");
                status=p.getString("status");
                creator=p.getString("creator");
                dateCreation=p.getString("datecreation");
                lst.add(new Todo(idtodo,task,status,creator,dateCreation));
            }
            
        }
        catch(SQLException ex){
            System.out.println("Erreur de connection");
            System.exit(1);
        }
    }
}
