<!-- 
	 Controller che ottiene la lista delle domande di un utente loggato e le passa alla viewList
	 per l'impaginazione
-->
<%@page import="it.capone.dao.DomandaDAO" %>
<jsp:useBean id="loginBean" class="it.capone.bean.LoginBean" scope="session"></jsp:useBean>
<jsp:useBean id="listaDomande" class="it.capone.bean.ListaDomandeBean" scope="request"/>
<% 
	//creo un oggetto dao che interagisce con il db
	DomandaDAO domandaDAO = new DomandaDAO();
	
	//l'oggetto dao interrogherà il db e popolerà il bean "listadomande" con il risultato della query
	domandaDAO.getMieDomande(loginBean.getNome(), loginBean.getPassword(), listaDomande);
	
%>
<jsp:forward page="viewMyListaDomande.jsp"/>