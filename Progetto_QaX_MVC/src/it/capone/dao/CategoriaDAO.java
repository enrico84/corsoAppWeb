package it.capone.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
			    //Date data = rs.getDate("data");
			    //int ord = rs.getInt("ord");
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
	
	
//public List<String> getCategorie() {
//		
//		List<String> cat = new ArrayList<String>();
//		
//		Connection conn = null;
//	    Statement st = null;
//	    ResultSet rs = null;
//	    try {
//			conn = it.capone.db.ConnectionFactory.getConnection();
//			st = conn.createStatement();
//			String query = "SELECT * FROM qax.categoria as c ORDER BY c.";
//			rs = st.executeQuery(query);
//			
//			while(rs.next()){
//				String nome = rs.getString("nome");
//			    //Date data = rs.getDate("data");
//			    //int ord = rs.getInt("ord");
//			    compl.add(nome);
//			    
//			}
//			
//	    }
//	    catch(SQLException ex) {
//	    	Logger.getLogger(CategoriaDAO.class.getName(), null).log(Level.SEVERE, null, ex);
//	    	System.out.println("Problema...: " +ex.getMessage());
//	    }
//		
//		finally{
//			try
//            {
//                if(rs != null){
//                    rs.close();
//                }
//                if(st != null)
//                {
//                    st.close();
//                }
//                if(conn != null)
//                {
//                    conn.close();
//                }
//            }
//            catch(Exception ex2)
//            {
//                System.out.println("Eccezione: " +ex2.getMessage());
//            }
//		}
//				
//	    return compl;
//	}
//	
}
