package it.capone.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;

import com.sun.istack.internal.logging.Logger;

import it.capone.bean.CategoriaBean;
import it.capone.bean.DomandaBean;
import it.capone.bean.ListaDomandeBean;
import it.capone.bean.UtenteBean;
import it.capone.utility.Data;

public class DomandaDAO {

	/**
	 * 
	 * @return Una lista delle prime 10 domande 
	 */
	public void getDomande(ListaDomandeBean listaDomande) {
		
		//List<DomandaBean> listaDomande = new ArrayList<DomandaBean>(); //2° MODO: popolo una lista Locale e la ritorno
		
		Connection conn = null;
	    Statement st = null;
	    ResultSet rs = null;
	    try {
	    	conn = it.capone.db.ConnectionFactory.getConnection();
	    	st = conn.createStatement();
	    	String query = "SELECT * FROM qax.domanda as d, qax.utente as u WHERE d.idutente=u.idutente ORDER BY d.datacreazione LIMIT 10";
	    	rs=st.executeQuery(query);
		    while(rs.next()) {
		    	Timestamp d = rs.getTimestamp("datacreazione");
	            GregorianCalendar gc = new GregorianCalendar();
	            gc.setTime(d);
	            
	            listaDomande.creaDomanda(rs.getInt("iddomanda"), 
	            						rs.getString("titolo"), rs.getString("descrizione"), 
	            						new Data(
	           	            				 gc.get(GregorianCalendar.YEAR),
	           	            		         gc.get(GregorianCalendar.MONTH) + 1,
	           	            		         gc.get(GregorianCalendar.DATE)
	           	            		         ), 
	            						prendiCategoria(rs.getInt("categoria")), prendiUtente(rs.getInt("idutente"))
	            						);
	      
//	            2° MODO
//	            DomandaBean domanda = new DomandaBean(
//	            		rs.getInt("iddomanda"), 
//	            		rs.getString("titolo"),
//	            		rs.getString("descrizione"), 
//	            		new Data(
//	            				 gc.get(GregorianCalendar.YEAR),
//	            		         gc.get(GregorianCalendar.MONTH) + 1,
//	            		         gc.get(GregorianCalendar.DATE)
//	            		         ),
//	            		prendiCategoria(rs.getInt("categoria")), 
//	            		prendiUtente(rs.getInt("idutente")));
//	            
//	            	
//	            listaDomande.add(domanda);  //2° MODO
	            
		    }
			//return listaDomande; //2° MODO
	    }	
		catch(SQLException ex)
	    {
			Logger.getLogger(DomandaDAO.class.getName(), null).log(Level.SEVERE, null, ex);
	    	System.out.println("Problema...: " +ex.getMessage());
	    	//return null;
	    }
	    finally
	    {
	        try {
	             if(rs != null)
	             {
	                rs.close();
	             }
	             if(st != null){
	                st.close();
	             }
	             if(conn != null){
	                conn.close();
	             }
	        }
	        catch(Exception ex1)
	        {
	        	System.out.println("Eccezione: " +ex1.getMessage());
	        }
	   }
		
	}
	
	
	/*public DomandaBean getDomanda(int id) {
		Connection conn = null;
	    Statement st = null;
	    ResultSet rs = null;
	    try {
	    	conn = it.capone.db.ConnectionFactory.getConnection();
	    	st = conn.createStatement();
	    	String query = "SELECT d.titolo, d.descrizione, u.nome , r.descrizione, r.datacreazione "+
	    				   "FROM qax.domanda as d, qax.utente as u, qax.risposta as r "+
	    				   "WHERE d.idutente=u.idutente AND r.iddomanda=d.iddomanda AND d.iddomanda="+id;
	    	rs=st.executeQuery(query);
	    	
		    if(rs.next()) {
		    	Timestamp d = rs.getTimestamp("datacreazione");
		    	GregorianCalendar gc = new GregorianCalendar();
	            gc.setTime(d);
	            
	           
	            
	            listaDomanda.creaDomanda(rs.getInt("iddomanda"), 
	            						rs.getString("titolo"), rs.getString("descrizione"), 
	            						new Data(
	           	            				 gc.get(GregorianCalendar.YEAR),
	           	            		         gc.get(GregorianCalendar.MONTH) + 1,
	           	            		         gc.get(GregorianCalendar.DATE)
	           	            		         ), 
	            						prendiCategoria(rs.getInt("categoria")), prendiUtente(rs.getInt("idutente"))
	            						);
	
	
		    }
			//return listaDomande; //2° MODO
	    }	
		catch(SQLException ex)
	    {
			Logger.getLogger(DomandaDAO.class.getName(), null).log(Level.SEVERE, null, ex);
	    	System.out.println("Problema...: " +ex.getMessage());
	    	//return null;
	    }
	    finally
	    {
	        try {
	             if(rs != null)
	             {
	                rs.close();
	             }
	             if(st != null){
	                st.close();
	             }
	             if(conn != null){
	                conn.close();
	             }
	        }
	        catch(Exception ex1)
	        {
	        	System.out.println("Eccezione: " +ex1.getMessage());
	        }
	}*/
	
	
	/**
	 * 
	 * @param titolo
	 * @param descrizione
	 * @param categoria
	 * @param utente
	 * @param datacreazione
	 * @return Un oggetto Domanda
	 */
	public static DomandaBean creaDomanda(String titolo, String descrizione, CategoriaBean categoria, UtenteBean utente, 
			Data datacreazione) 
	{
		
		Connection conn = null;
		PreparedStatement ps=null;
	    ResultSet rs = null;
	    try {
	    	conn = it.capone.db.ConnectionFactory.getConnection();
	    	ps=conn.prepareStatement("INSERT INTO qax.domanda(titolo, descrizione, categoria, idutente, datacreazione) "+
	                    "VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
	    	ps.setString(1, titolo);
	    	ps.setString(2, descrizione);
	    	ps.setInt(3, categoria.getId());
	    	ps.setInt(4, utente.getIdutente());
	    	
	    	ps.setTimestamp(5, new Timestamp(new GregorianCalendar(
                    datacreazione.getAnno(),
                    datacreazione.getMese() - 1,
                    datacreazione.getGiorno()).getTimeInMillis()));
			ps.executeUpdate();
		    rs=ps.getGeneratedKeys();
	        rs.next();
			int id = rs.getInt(1);
			return new DomandaBean(id, titolo, descrizione, datacreazione, categoria, utente);
	    }	
		catch(SQLException ex)
	    {
			Logger.getLogger(DomandaDAO.class.getName(), null).log(Level.SEVERE, null, ex);
	    	System.out.println("Problema...: " +ex.getMessage());
	    	return null;
	    }
	    finally
	    {
	        try {
	             if(rs != null)
	             {
	                rs.close();
	             }
	             if(ps != null){
	                ps.close();
	             }
	             if(conn != null){
	                conn.close();
	             }
	        }
	        catch(Exception ex1)
	        {
	        	System.out.println("Eccezione: " +ex1.getMessage());
	        }
	   }
	}
	
	
	/**
	 * 
	 * @param id
	 * @return Un oggetto Utente
	 */
	private static UtenteBean prendiUtente(int id){
	        Connection conn = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        try {
	        	conn = it.capone.db.ConnectionFactory.getConnection();    
	            ps = conn.prepareStatement("SELECT idutente, password, nome, email, dataregistrazione " +
	                    "FROM qax.utente " + 
	                    "WHERE idutente = ?" );
	            ps.setInt(1, id);
	            rs = ps.executeQuery();
	            rs.next();
	            Timestamp d = rs.getTimestamp("dataregistrazione");
	            GregorianCalendar gc = new GregorianCalendar();
	            gc.setTime(d);
	            UtenteBean ut = new UtenteBean(
	            		 				  rs.getInt("idutente"),
	                                      rs.getString("password"),
	                                      rs.getString("nome"),
	                                      rs.getString("email"),
	                                      new Data(
	             	            				 gc.get(GregorianCalendar.YEAR),
	             	            		         gc.get(GregorianCalendar.MONTH) + 1,
	             	            		         gc.get(GregorianCalendar.DATE)
	             	            		         )
	                     				  );        
	            return ut;
	        } catch (SQLException ex) {
	        	Logger.getLogger(DomandaDAO.class.getName(), null).log(Level.SEVERE, null, ex);
		    	System.out.println("Problema...: " +ex.getMessage());
		    	return null;
	        } finally {
	            try {
	                if(rs != null)
	                {
	                    rs.close();
	                }
	                if (ps != null) {
	                    ps.close();
	                }
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (Exception ex1) {
	                System.out.println("Eccezione: " + ex1.getMessage());
	            }
	        }
	    }
	
	
	/**
	 * 
	 * @param id
	 * @return Un oggetto Categoria
	 */
	private static CategoriaBean prendiCategoria(int id){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
        	conn = it.capone.db.ConnectionFactory.getConnection();    
            ps = conn.prepareStatement("SELECT idcategoria, nome " +
                    "FROM qax.categoria " + 
                    "WHERE idcategoria = ?" );
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            CategoriaBean cat = new CategoriaBean(rs.getInt("idcategoria"),
            									  rs.getString("nome"));
             
            return cat;
        } catch (SQLException ex) {
        	Logger.getLogger(DomandaDAO.class.getName(), null).log(Level.SEVERE, null, ex);
	    	System.out.println("Problema...: " +ex.getMessage());
	    	return null;
        } finally {
            try {
                if(rs != null)
                {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex1) {
                System.out.println("Eccezione: " + ex1.getMessage());
            }
        }
    }

	
	
	
}
