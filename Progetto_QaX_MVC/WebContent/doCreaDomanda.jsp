<!-- 
	CONTROLLER inserimento domands
	Prende i dati dalla "viewCreaDomanda.jsp" e li invia al DAO
	Il DAO domandaDAO eseguirà una query di inserimento al db, tornando il risultato atteso
 -->
 <%@page import="java.util.Calendar"%><%@
 page import="java.sql.Timestamp"%>
 <jsp:useBean id="loginBean" class="it.capone.bean.LoginBean" scope="session"/>
 <jsp:useBean id="domandaBean" class="it.capone.bean.DomandaBean" scope="request"/>
  <jsp:useBean id="errBean" class="it.capone.utility.ErrMsg" scope="request"/><%@
 page import="it.capone.dao.DomandaDAO" %><%  
 
 String titolo = request.getParameter("titolo");
 String descrizione = request.getParameter("descrizione");
 String categoria = request.getParameter("categ");
//  Calendar calendar = Calendar.getInstance();
//  	int anno = calendar.get(Calendar.YEAR);
//  	int mese = calendar.get(Calendar.MONTH);
//  	int giorno = calendar.get(Calendar.DATE);
//  	int ore = calendar.get(Calendar.HOUR_OF_DAY);
//  	int minuti = calendar.get(Calendar.MINUTE);
//  	int secondi = calendar.get(Calendar.SECOND);
// Timestamp times = new Timestamp((calendar).getTimeInMillis());
 
DomandaDAO domandaDAO = new DomandaDAO();
if( (titolo != null && !(titolo.equals(""))) && 
		(descrizione != null && !(descrizione.equals(""))) 
			&& (categoria != null && !(categoria.equals("")) && loginBean.getIdutente() > 0)  ) {  ///OK 
				
			domandaDAO.creaDomanda(domandaBean, titolo, descrizione, categoria, loginBean);
			response.sendRedirect("doMieDomande.jsp");		

} else { 
		errBean.add(domandaBean.getErrorMsg());    //CONTROLLO ERRORI LATO SERVER 
%>
		<jsp:forward page="viewCreaDomanda.jsp" />
<%  } %>
