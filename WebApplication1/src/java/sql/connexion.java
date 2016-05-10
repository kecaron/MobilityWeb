/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class connexion {
	
	private String login;
	private String pass;
	private String url;
	private Connection cx;
	private Statement st;
	
	public connexion(String login,String pass,String url)
	{
		this.login=login;
		this.pass=pass;
		this.url=url;
		this.cx=null;
		this.st=null;
	}
// connexion base de donnée 

public void connectionbase() 
{
    /** Chargement du driver JDBC - 
	Étape 1
     */ 
    	try { 
    		Class.forName("oracle.jdbc.driver.OracleDriver");
    	} 
    	catch( Exception ex ) { 
    		System.err.println("Erreur lors du chargement du driver" ); 
    		System.exit(1); 
    	} 
    	try { 
    		/** Connection à la base - 
	Étape 2
    		 */
    		this.cx = DriverManager.getConnection (this.url,this.login,this.pass);

    	}
    	catch( Exception ex ) { 
    		System.err.println("Erreur lors de la connexion à la base \n"); 
                System.err.println("URL :"+this.url+"\n Login :"+this.login+ "\n pass:"+this.pass); 
    		System.exit(1); 
    	}
}

public Statement create_statement() 
{
	try{
		this.st = getCx().createStatement();
	}
	catch( Exception ex ) { 
		System.err.println("Erreur lors de la creation du statement"); 
		System.exit(1); 
	}
	return st;
	
}
/**
 * Executer une requete SQL
 * @param sql
 * @return resultat de la requete
 */
public ResultSet exec(String sql) {
    try {
        ResultSet rs = this.st.executeQuery(sql);
        return rs;
    } catch (SQLException ex) {
    	System.err.println("Erreur lors de la querry"); 
    }
    return null;
}

public void close()
{
            try {
                this.cx.close();
                this.st.close();
            } catch (SQLException ex) {
                Logger.getLogger(connexion.class.getName()).log(Level.SEVERE, null, ex);
            }
}
/**
 * Fermer la connexion au serveur de DB
 */


public String getLogin() {
	return login;
}

public String getPass() {
	return pass;
}

public String getUrl() {
	return url;
}

public Connection getCx() {
	return cx;
}


}
