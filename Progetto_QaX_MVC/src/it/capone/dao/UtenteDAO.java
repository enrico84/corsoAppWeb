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

import it.capone.bean.LoginBean;
import it.capone.utility.Data;

public class UtenteDAO {
	
	
	public boolean verifyUtente(String userId, String password) {
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
			if(rs.next())
				exist = true;

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
	
	
}
