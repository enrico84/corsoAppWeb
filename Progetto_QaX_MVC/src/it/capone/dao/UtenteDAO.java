package it.capone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.GregorianCalendar;
import java.util.logging.Level;

import com.sun.istack.internal.logging.Logger;

import it.capone.bean.CategoriaBean;
import it.capone.bean.LoginBean;
import it.capone.utility.Data;

public class UtenteDAO {
	
	/**
	 * 
	 * @param loginBean
	 * @param userId
	 * @param password
	 * @return VERIFICA se un dato Utente esiste
	 */
	public boolean verifyUtente(LoginBean loginBean, String userId, String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = it.capone.db.ConnectionFactory.getConnection();
			String query = "SELECT * FROM qax.utente as u WHERE u.nome=? AND u.password=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, userId);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			
			boolean exist=false;
			if(rs.next()) {
				int id = rs.getInt("idutente");
				loginBean.setIdUtente(id);
				exist = true;
			}

			return exist;
			 
		}
		catch(SQLException ex) {
	    	Logger.getLogger(UtenteDAO.class.getName(), null).log(Level.SEVERE, null, ex);
	    	System.out.println("database error in "+this.getClass().getSimpleName()+", errore: " +ex.getMessage());
	    }
		
		finally{
			try
            {
                if(conn != null)
                {
                    conn.close();
                }
                if(ps != null)
                {
                	ps.close();
                }
                if(rs != null) 
                {
                	rs.close();
                }
            }
            catch(Exception ex2)
            {
                System.out.println("Eccezione nella chiusura delle sorgenti dati: " +ex2.getMessage());
            }
		}
		return false;
	}
	
	
	/**
	 * 
	 * @param loginBean
	 * @param nome
	 * @param password
	 * @param email
	 * INSERT UTENTE
	 */
	public void registraUtente(LoginBean loginBean, String nome, String password, String email) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = it.capone.db.ConnectionFactory.getConnection();
			ps = conn.prepareStatement("INSERT INTO qax.utente(password, nome, email, dataregistrazione) VALUES(?, ?, ?, ?)", 
										Statement.RETURN_GENERATED_KEYS);
            
			Data dataregistrazione = new Data();
			ps.setString(1, password);
			ps.setString(2, nome);
			ps.setString(3, email);
			
			ps.setTimestamp(4, new Timestamp(new GregorianCalendar(
					dataregistrazione.getAnno(),
					dataregistrazione.getMese() - 1,
					dataregistrazione.getGiorno(),
					dataregistrazione.getOre(),
					dataregistrazione.getMinuti(),
					dataregistrazione.getSecondi()).getTimeInMillis()));
			
			
			ps.executeUpdate();
			rs=ps.getGeneratedKeys();
			rs.next();
			int idUtente = rs.getInt(1);
			loginBean = new LoginBean(idUtente, nome, password, email, dataregistrazione);
			
			 
		}
		catch(SQLException ex) {
	    	Logger.getLogger(UtenteDAO.class.getName(), null).log(Level.SEVERE, null, ex);
	    	System.out.println("database error in "+this.getClass().getSimpleName()+", errore: " +ex.getMessage());
	    }
		
		finally{
			try
            {
                if(conn != null)
                {
                    conn.close();
                }
                if(ps != null)
                {
                	ps.close();
                }
                if(rs != null) 
                {
                	rs.close();
                }
            }
            catch(Exception ex2)
            {
                System.out.println("Eccezione nella chiusura delle sorgenti dati: " +ex2.getMessage());
            }
		}
	}
	
	
	/**
	 * 
	 * @param idutente
	 * @param password
	 * @param email
	 * @return UPDATE UTENTE
	 */
	public static boolean aggiornaUtente(int idutente, String password, String email) {
		boolean modificato=false;
		Connection conn=null;
		PreparedStatement ps = null;
		try{
			conn = it.capone.db.ConnectionFactory.getConnection();
			String query = "UPDATE qax.utente as u SET u.password=?, u.email=? WHERE u.idutente=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, password);
			ps.setString(2, email);
			ps.setInt(3, idutente);
			
			int res = ps.executeUpdate();
			
			//il risultato di un executeUpdate corretto è il numero di righe 
			//modicate dal db, in questo caso è 1
			if(res != 1) {  
				Logger.getLogger(DomandaDAO.class.getName(), null).log(Level.SEVERE, "Errore nella query di update utente");
				modificato = false;
				throw new RuntimeException("database error in UtenteDAO class");
				
			}
			modificato=true;
		}
		catch(SQLException ex){
			Logger.getLogger(UtenteDAO.class.getName(), null).log(Level.SEVERE, null, ex);
			System.out.println("Problema in : UtenteDAO class, " +ex.getMessage());
			return modificato;
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
		return modificato;
	}
	
}
