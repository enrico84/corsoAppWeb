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
 String cat = request.getParameter("selectCategoria");
 
DomandaDAO domandaDAO = new DomandaDAO();
if( (titolo != null && !(titolo.equals(""))) && 
		(descrizione != null && !(descrizione.equals(""))) 
			&& (categoria != null && !(categoria.equals("")) && loginBean.getIdutente() > 0)  ) {  ///OK 
				
			domandaDAO.creaDomanda(titolo, descrizione, categoria, loginBean);
			response.sendRedirect("doMieDomande.jsp");		

} else { 
		errBean.add(domandaBean.getErrorMsg());    //CONTROLLO ERRORI LATO SERVER 
%>
		<jsp:forward page="viewCreaDomanda.jsp" />
<%  } %>
