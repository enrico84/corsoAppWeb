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
import it.capone.bean.ListaRisposteBean;
import it.capone.bean.UtenteBean;
import it.capone.db.ConnectionFactory;
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
	
	
	/**
	 * 
	 * @return Una domanda con la lista delle sue risposte
	 */
	public void getDomandaConRisposte(int id, DomandaBean domanda, ListaRisposteBean listaRisposta) {
		Connection conn = null;
	    Statement st = null;
	    ResultSet rs = null;
	
	    try {
	    	listaRisposta = new ListaRisposteBean();
	    	conn = it.capone.db.ConnectionFactory.getConnection();
	    	st = conn.createStatement();
	    	String query = "SELECT d.titolo, d.descrizione as dDescrizione, d.datacreazione as dData,"
	    					+ " u.idutente as dUtente, u.nome , "
	    					+ "r.idrisposta as idRisp, r.descrizione as rDescrizione, r.datacreazione, r.iddomanda, r.idutente as rUtente "+
	    				   "FROM qax.domanda as d, qax.utente as u, qax.risposta as r "+
	    				   "WHERE d.idutente=u.idutente AND r.iddomanda=d.iddomanda AND d.iddomanda="+id;
	    	rs=st.executeQuery(query);
	    	
	    	String simpleQuery = "SELECT d.titolo, d.descrizione, d.datacreazione, u.idutente, u.nome "
	    						 + "FROM qax.domanda as d, qax.utente as u "
	    						 + "WHERE d.idutente=u.idutente AND d.iddomanda="+id;
	    	
	    	
		    while(rs.next()) {
		    	Timestamp d = rs.getTimestamp("datacreazione");
		    	GregorianCalendar gc = new GregorianCalendar();
	            gc.setTime(d);
	            	            
	            listaRisposta.creaRisposta(rs.getInt("idRisp"), 
	            						   rs.getString("rDescrizione"), 
	            						   prendiUtente(rs.getInt("rUtente")), 
	            						   new Data(
	          	           	            			gc.get(GregorianCalendar.YEAR),
	          	           	            		    gc.get(GregorianCalendar.MONTH) + 1,
	          	           	            		    gc.get(GregorianCalendar.DATE)
	          	           	            		    ), 	
	            						   prendiDomanda(rs.getInt("iddomanda"))
	            						   );
	          
	            Timestamp dd = rs.getTimestamp("dData");
		    	GregorianCalendar gcc = new GregorianCalendar();
	            gcc.setTime(dd);
	            domanda.setTitolo(rs.getString("titolo"));
	            domanda.setDescrizione(rs.getString("dDescrizione"));
	            domanda.setDatacreazione( new Data(
 	            							gcc.get(GregorianCalendar.YEAR),
			     	            		    gcc.get(GregorianCalendar.MONTH) + 1,
			     	            		    gcc.get(GregorianCalendar.DATE)
			     	            		    ));
	            domanda.setUtente(prendiUtente(rs.getInt("dUtente")));
	            domanda.setRisposte(listaRisposta);
	
		    }
		    
		  
		    
		    if(domanda != null) {
			    if((domanda.getTitolo() != null) && (domanda.getDescrizione() != null)){
			    	if(rs != null)
			        {
			    		rs.close();
			        }
			    }
			    else{
			    	//Nel caso la prima query risulti vuota, ne creo una più semplice con solo le proprietà della Domanda
			    	rs=st.executeQuery(simpleQuery);
			    	while(rs.next()) {
					    	Timestamp d = rs.getTimestamp("datacreazione");
					    	GregorianCalendar gc = new GregorianCalendar();
				            gc.setTime(d);
				            	           				        
				            domanda.setTitolo(rs.getString("titolo"));
				            domanda.setDescrizione(rs.getString("descrizione"));
				            domanda.setDatacreazione( new Data(
			 	            							gc.get(GregorianCalendar.YEAR),
						     	            		    gc.get(GregorianCalendar.MONTH) + 1,
						     	            		    gc.get(GregorianCalendar.DATE)
						     	            		    ));
				            domanda.setUtente(prendiUtente(rs.getInt("idutente")));
			    	}
			    	if(rs != null)
		            {
		               rs.close();
		            }
			    }   
			}
		    else{
		    	Logger.getLogger(DomandaDAO.class.getName(), null).log(Level.SEVERE, "La domanda è nulla, attenzione!");
		    }
			
	    }	
		catch(SQLException ex)
	    {
			Logger.getLogger(DomandaDAO.class.getName(), null).log(Level.SEVERE, null, ex);
	    	System.out.println("Problema nella query di getDomanda(): " +ex.getMessage());
	    }
	    finally
	    {
	        try {
	             if(st != null){
	                st.close();
	             }
	             if(conn != null){
	                conn.close();
	             }
	        }
	        catch(Exception ex1)
	        {
	        	System.out.println("Eccezione generica: " +ex1.getMessage());
	        }
	    }
	}
	
	
	/**
	 * 
	 * @return Una lista delle prime 10 domande 
	 */
	public void getMieDomande(String username, String password, ListaDomandeBean myListaDomande) {
		
		//List<DomandaBean> listaDomande = new ArrayList<DomandaBean>(); //2° MODO: popolo una lista Locale e la ritorno
		
		Connection conn = null;
	    Statement st = null;
	    ResultSet rs = null;
	    try {
	    	conn = it.capone.db.ConnectionFactory.getConnection();
	    	st = conn.createStatement();
	    	String query = "SELECT * FROM qax.domanda as d, qax.utente as u "
	    				   + "WHERE d.idutente=u.idutente AND u.nome='"+username+"' AND u.password='"+password+"' ORDER BY d.datacreazione";
	    	rs=st.executeQuery(query); 
	    	while(rs.next()) {
		    	Timestamp d = rs.getTimestamp("datacreazione");
	            GregorianCalendar gc = new GregorianCalendar();
	            gc.setTime(d);
	            
	            myListaDomande.creaDomanda(rs.getInt("iddomanda"), 
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
	    	System.out.println("Problema in : "+this.getClass().getSimpleName()+", eccezione:" +ex.getMessage());
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
		    	System.out.println("Problema in prendiUtente(): " +ex.getMessage());
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
	    	System.out.println("Problema in prendiCategoria(): " +ex.getMessage());
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
                System.out.println("Eccezione generica: " + ex1.getMessage());
            }
        }
    }

	
	/**
	 * 
	 * @param id
	 * @return Un oggetto Domanda
	 */
	private static DomandaBean prendiDomanda(int iddomanda) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = it.capone.db.ConnectionFactory.getConnection();
			ps = conn.prepareStatement("SELECT * FROM qax.domanda as d WHERE d.iddomanda = ?");
			ps.setInt(1, iddomanda);
			rs=ps.executeQuery();
			rs.next();
			Timestamp d = rs.getTimestamp("datacreazione");
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(d);
			DomandaBean domanda = new DomandaBean(rs.getInt("iddomanda"),
											      rs.getString("titolo"), 
											      rs.getString("descrizione"), 
											      new Data(gc.get(GregorianCalendar.YEAR),
											    		   gc.get(GregorianCalendar.MONTH) + 1,
											    		   gc.get(GregorianCalendar.DATE)
											    		   ),
											      prendiCategoria(rs.getInt("categoria")),
											      prendiUtente(rs.getInt("idutente"))
											      );
			return domanda;
		}
		catch(SQLException ex) {
			Logger.getLogger(DomandaDAO.class.getName(), null).log(Level.SEVERE, null, ex);
	    	System.out.println("Problema in prendiDomanda()....: " +ex.getMessage());
	    	return null;
		}
		finally {
			try{
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
			}
			catch(Exception ex1) {
				 System.out.println("Eccezione generica: " + ex1.getMessage());
			}
		}
	}
	
	
	
}
