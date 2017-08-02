package it.capone.dao;

import java.sql.*;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;

import com.sun.istack.internal.logging.Logger;

import it.capone.bean.CategoriaBean;
import it.capone.bean.DomandaBean;
import it.capone.bean.ListaDomandeBean;
import it.capone.bean.ListaRisposteBean;
import it.capone.bean.LoginBean;
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
	 * @return Una lista delle prime 10 domande data la categoria
	 */
	public void getDomande(ListaDomandeBean listaDomande, String categoria) {
		
		//List<DomandaBean> listaDomande = new ArrayList<DomandaBean>(); //2° MODO: popolo una lista Locale e la ritorno
		
		Connection conn = null;
	    Statement st = null;
	    ResultSet rs = null;
	    try {
	    	conn = it.capone.db.ConnectionFactory.getConnection();
	    	st = conn.createStatement();
	    	String query = "select * from qax.domanda as d, qax.categoria as c WHERE d.categoria=c.idcategoria AND c.nome LIKE '"+categoria+"' LIMIT 10";
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
	    				   + "WHERE d.idutente=u.idutente AND u.nome='"+username+"' AND u.password='"+password+"' ORDER BY d.datacreazione DESC";
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
	 */
	public void creaDomanda(String titolo, String descrizione, String categoria, LoginBean utente) 
	{
		
		Connection conn = null;
		PreparedStatement ps=null;
	   
	    try {
	    	conn = it.capone.db.ConnectionFactory.getConnection();
	    	CategoriaBean categ = prendiCategoriaByNome(categoria);
	    	//Se la categoria non esiste la aggiungo nella tabella qax.Categoria
	    	if(categ == null) {
	    		int maxidCategoria = getMaxId("qax.categoria", "idcategoria");
	    		maxidCategoria++;
	    		PreparedStatement pss=null;
	    		pss=conn.prepareStatement("INSERT INTO qax.categoria(idcategoria, nome) VALUES (?, ?)"); 
	    		pss.setInt(1, maxidCategoria);
	    		pss.setString(2, categoria);
	    		
	    		pss.executeUpdate();
				categ = new CategoriaBean(maxidCategoria, categoria);
				pss.close();
	    	}
	    		
	    	ps=conn.prepareStatement("INSERT INTO qax.domanda(iddomanda, titolo, descrizione, categoria, idutente, datacreazione) "+
	                 "VALUES (?, ?, ?, ?, ?, now())");
	    	
	    	int maxidDomanda = getMaxId("qax.domanda", "iddomanda");
	    	maxidDomanda++;
	    	ps.setInt(1, maxidDomanda);
	    	ps.setString(2, titolo);
		    ps.setString(3, descrizione);
		    ps.setInt(4, categ.getIdcategoria());
		    ps.setInt(5, utente.getIdutente());
		 
			ps.executeUpdate();
			
	    }	
		catch(SQLException ex)
	    {
			Logger.getLogger(DomandaDAO.class.getName(), null).log(Level.SEVERE, null, ex);
	    	System.out.println("Problema in : " +this.getClass().getSimpleName()+ ", " +ex.getMessage());
	    }
	    finally
	    {
	        try {
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
	
	
	public void aggiornaDomanda(CategoriaBean categoriaBean, int iddomanda, String titolo, String descrizione, 
			                       String categoria) {
		Connection conn=null;
		PreparedStatement ps = null;
		try{
			conn = it.capone.db.ConnectionFactory.getConnection();
			categoriaBean = prendiCategoriaByNome(categoria);
			//Se la categoria non esiste la aggiungo nella tabella qax.Categoria
	    	if(categoriaBean == null) {
	    		int maxidCategoria = getMaxId("qax.categoria", "idcategoria");
	    		maxidCategoria++;
	    		PreparedStatement pss=null;
	    		pss=conn.prepareStatement("INSERT INTO qax.categoria(idcategoria, nome) VALUES (?, ?)"); 
	    		pss.setInt(1, maxidCategoria);
	    		pss.setString(2, categoria);
	    		
	    		pss.executeUpdate();
	    		categoriaBean = new CategoriaBean(maxidCategoria, categoria);
				pss.close();
	    	}
			String query = "UPDATE qax.domanda as d SET d.titolo=?, d.descrizione=?, d.categoria=? WHERE iddomanda=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, titolo);
			ps.setString(2, descrizione);
			ps.setInt(3, categoriaBean.getIdcategoria());
			ps.setInt(4, iddomanda);
			
			int res = ps.executeUpdate();
			
			//il risultato di un executeUpdate corretto è il numero di righe 
			//modicate dal db, in questo caso è 1
			if(res != 1) {  
				Logger.getLogger(DomandaDAO.class.getName(), null).log(Level.SEVERE, "Errore nella query di update domanda");
				throw new RuntimeException("database error in "+this.getClass().getSimpleName());
			}
		}
		catch(SQLException ex){
			Logger.getLogger(DomandaDAO.class.getName(), null).log(Level.SEVERE, null, ex);
			System.out.println("Problema in : " +this.getClass().getSimpleName()+ ", " +ex.getMessage());
			
		}
		finally {
			try {
				if(ps != null) {
					ps.close();
				}
				if(conn != null) {
					conn.close();
				}
			}
			catch(Exception e) {
				System.out.println("Eccezione generica: " +e.getMessage());
				e.printStackTrace();
			}
			
		}
	}
	
	
	public void eliminaDomanda(int idDomanda) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = it.capone.db.ConnectionFactory.getConnection();
			String query1 = "DELETE FROM qax.risposta WHERE iddomanda=?";
			ps=conn.prepareStatement(query1);
			ps.setInt(1, idDomanda);
			int res = ps.executeUpdate();
//			if (res != 1) {
//            	throw new SQLException("Risposte alla domanda non eliminate");
//            }
			if(ps != null)
				ps.close();
			
			String query2="DELETE FROM qax.domanda WHERE iddomanda=?";
            ps=conn.prepareStatement(query2);
            ps.setInt(1, idDomanda);
            res = ps.executeUpdate();
//            if (res != 1) {
//            	throw new SQLException("Domanda non eliminata");
//            }
			
		}
		catch(SQLException ex) {
			Logger.getLogger(DomandaDAO.class.getName(), null).log(Level.SEVERE, null, ex);
	    	System.out.println("Problema in eliminaDomanda:  " +ex.getMessage());
		}
		finally {
			try {
				if(conn != null) 
					conn.close();
				
				if(ps != null)
					ps.close();
				
			}
			catch(Exception e) {
				System.out.println("Eccezione generica: " +e.getMessage());
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	public int getMaxId(String tab, String id) {
        Connection conn = null;
        Statement st = null;
        ResultSet res = null;

        try {
        	conn = it.capone.db.ConnectionFactory.getConnection();
            st = conn.createStatement();
            String sql = "SELECT MAX("+id+") FROM " +tab;

           res = st.executeQuery(sql);

            int ord;
            if (res.next()) {
                ord = res.getInt(1);
                if (res.wasNull()) {    // in case of empty table
                    ord = -1;
                    // no elements => return (-1), so that first element will be #0
                }
            } else {
                ord = -1;
            }

            res.close();
            st.close();
            conn.close();

            return ord;
        } catch (SQLException ex) {
        	Logger.getLogger(DomandaDAO.class.getName(), null).log(Level.SEVERE, null, ex);
            throw new RuntimeException("database error in " + this.getClass().getSimpleName(), ex);
        }
    }        
	
	
	/**
	 * 
	 * @param id
	 * @return Un oggetto Utente
	 */
	public static LoginBean prendiUtente(int id){
	        Connection conn = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        try {
	        	conn = it.capone.db.ConnectionFactory.getConnection();    
	            ps = conn.prepareStatement("SELECT idutente, nome, password, email, dataregistrazione " +
	                    "FROM qax.utente " + 
	                    "WHERE idutente = ?" );
	            ps.setInt(1, id);
	            rs = ps.executeQuery();
	            rs.next();
	            Timestamp d = rs.getTimestamp("dataregistrazione");
	            GregorianCalendar gc = new GregorianCalendar();
	            gc.setTime(d);
	            LoginBean ut = new LoginBean(
	            		 				  rs.getInt("idutente"),
	            		 				  rs.getString("nome"),
	            		 				  rs.getString("password"),
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
	 * @param nome
	 * @return Verifica se una data Categoria esiste
	 */
	private CategoriaBean prendiCategoriaByNome(String nome){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
        	conn = it.capone.db.ConnectionFactory.getConnection();    
            ps = conn.prepareStatement("SELECT * FROM qax.categoria as q WHERE q.nome = ?" );
                   
            ps.setString(1, nome);
            rs = ps.executeQuery();
            CategoriaBean categoria = null;
            if(rs.next())
            	categoria = new CategoriaBean(rs.getInt("idcategoria"),
						  rs.getString("nome"));
            	
            return categoria;
        } catch (SQLException ex) {
        	Logger.getLogger(DomandaDAO.class.getName(), null).log(Level.SEVERE, null, ex);
	    	System.out.println("Problema in prendiCategoria(nome): " +ex.getMessage());
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

	
	public void creaDomanda(DomandaBean domanda, String titolo, String descrizione, String categoria, LoginBean utente) 
	{
		
		Connection conn = null;
		PreparedStatement ps=null;
	    ResultSet rs = null;
	    
	    try {
	    	conn = it.capone.db.ConnectionFactory.getConnection();
	    	CategoriaBean categ = prendiCategoriaByNome(categoria);
	    	//Se la categoria non esiste la aggiungo nella tabella qax.Categoria
	    	if(categ == null) {
	    		int maxidCategoria = getMaxId("qax.categoria", "idcategoria");
	    		maxidCategoria++;
	    		PreparedStatement pss=null;
	    		pss=conn.prepareStatement("INSERT INTO qax.categoria(idcategoria, nome) VALUES (?, ?)"); 
	    		pss.setInt(1, maxidCategoria);
	    		pss.setString(2, categoria);
	    		
	    		pss.executeUpdate();
				categ = new CategoriaBean(maxidCategoria, categoria);
				pss.close();
	    	}
	    	//Se la Categoria esiste, gliela passo
	    		
	    	ps=conn.prepareStatement("INSERT INTO qax.domanda(iddomanda, titolo, descrizione, categoria, idutente, datacreazione) "+
	                 "VALUES (?, ?, ?, ?, ?, now())", Statement.RETURN_GENERATED_KEYS);
	    	
	    	int maxidDomanda = getMaxId("qax.domanda", "iddomanda");
	    	maxidDomanda++;
	    	ps.setInt(1, maxidDomanda);
	    	ps.setString(2, titolo);
		    ps.setString(3, descrizione);
		    ps.setInt(4, categ.getIdcategoria());
		    ps.setInt(5, utente.getIdutente());
		 
			ps.executeUpdate();
//			rs=ps.getGeneratedKeys();
//			rs.next();
//	        
//			int id = rs.getInt(1);
//			
//			Timestamp d = rs.getTimestamp("datacreazione");
//            GregorianCalendar gc = new GregorianCalendar();
//            gc.setTime(d);
//            Data nuovaData = new Data(
//     				 gc.get(GregorianCalendar.YEAR),
//      		         gc.get(GregorianCalendar.MONTH) + 1,
//      		         gc.get(GregorianCalendar.DATE)
//      		         );
//            
//            
//            domanda = new DomandaBean(id, titolo, descrizione, nuovaData, categ, utente);
			
	    }	
		catch(SQLException ex)
	    {
			Logger.getLogger(DomandaDAO.class.getName(), null).log(Level.SEVERE, null, ex);
	    	System.out.println("Problema in : " +this.getClass().getSimpleName()+ ", " +ex.getMessage());
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
	 * @return Un oggetto Domanda
	 */
	public DomandaBean prendiDomanda(int iddomanda) {
		
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
