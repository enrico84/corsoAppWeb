package it.capone.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import com.sun.istack.internal.logging.Logger;


public class CategoriaDAO {

	public List<String> getCompletamenti(String testo) {
		
		List<String> compl = new ArrayList<String>();
		
		Connection conn = null;
	    Statement st = null;
	    ResultSet rs = null;
	    try {
			conn = it.capone.db.ConnectionFactory.getConnection();
			st = conn.createStatement();
			String query = "SELECT nome FROM qax.categoria WHERE nome LIKE '"+testo+"%' ORDER BY nome";
			rs = st.executeQuery(query);
			
			while(rs.next()){
				String nome = rs.getString("nome");
			    compl.add(nome);
			    
			}
			
	    }
	    catch(SQLException ex) {
	    	Logger.getLogger(CategoriaDAO.class.getName(), null).log(Level.SEVERE, null, ex);
	    	System.out.println("Problema...: " +ex.getMessage());
	    }
		
		finally{
			try
            {
                if(rs != null){
                    rs.close();
                }
                if(st != null)
                {
                    st.close();
                }
                if(conn != null)
                {
                    conn.close();
                }
            }
            catch(Exception ex2)
            {
                System.out.println("Eccezione: " +ex2.getMessage());
            }
		}
				
	    return compl;
	}
	
	
public Map<Integer, String> getCategorie() {
		
		Map<Integer, String> categorie = new HashMap<Integer, String>();
		
		Connection conn = null;
	    Statement st = null;
	    ResultSet rs = null;
	    try {
			conn = it.capone.db.ConnectionFactory.getConnection();
			st = conn.createStatement();
			String query = "SELECT * FROM qax.categoria ORDER BY nome";
			rs = st.executeQuery(query);
			
			while(rs.next()){
				int id = rs.getInt("idcategoria");
				String nome = rs.getString("nome");
			    categorie.put(id, nome);
			}
			
			
	    }
	    catch(SQLException ex) {
	    	Logger.getLogger(CategoriaDAO.class.getName(), null).log(Level.SEVERE, null, ex);
	    	System.out.println("Problema...: " +ex.getMessage());
	    	return null;
	    }
		
		finally{
			try
            {
                if(rs != null){
                    rs.close();
                }
                if(st != null)
                {
                    st.close();
                }
                if(conn != null)
                {
                    conn.close();
                }
            }
            catch(Exception ex2)
            {
                System.out.println("Eccezione: " +ex2.getMessage());
            }
		}
				
	    return categorie;
	}
	
}
