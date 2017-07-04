package it.capone.db;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import java.util.logging.Level;
import com.sun.istack.internal.logging.Logger;



public final class ConnectionFactory {

	private ConnectionFactory(){}
	
	/*
	 * VERSIONE NUOVA CON IL CONNECTION POOL
	 */
	public static Connection getConnection() {
		
		Context initContext;
		try{
			//JNDI query to locate the DataSource object
			initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env") ; // JNDI standard naming root
			DataSource ds = (DataSource)envContext.lookup("jdbc/qAx");
			// Ask DataSource for a connection 
			Connection conn;
			try {	
				conn = ds.getConnection();
				return conn;
			}
	        catch(SQLException ex)
	        {
	        	Logger.getLogger(ConnectionFactory.class.getName(), null).log(Level.SEVERE, null, ex);
	            throw new RuntimeException("cannot open Connection", ex);
	        }
	       
		} 
		catch(NamingException ex)
		{
			Logger.getLogger(ConnectionFactory.class.getName(), null).log(Level.SEVERE, null, ex);
			throw new RuntimeException("cannot find DataSource reference", ex);
		}
		  catch(Exception ex3)
        {
            System.out.println("Eccezione generica: " +ex3.getMessage());
            throw new RuntimeException("Generic Exception", ex3);
        }
		
	}
	
	
	/*
	 * DO NOT USE - Versione vecchia, senza connection pooling 

	public static Connection getConnection() {
		
		try{
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/spesa", "root", "");
		
        catch(SQLException ex)
        {
            System.out.println("Problema connessione database");
            System.out.println(ex.getMessage());
            return null;
        }
        catch(ClassNotFoundException ex2)
        {
            System.out.println("Classe non trovata");
            System.out.println(ex2.getMessage());
            return null;
       }
        catch(Exception ex3)
        {
            System.out.println("Eccezione generica: " +ex3.getMessage());
            return null;
        }
		
	}
	*/
	
}
