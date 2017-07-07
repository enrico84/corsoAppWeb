<!-- 
	 Controller che ottiene la lista delle domande e le passa alla viewList
	 per l'impaginazione
-->
<%@page import="it.capone.dao.DomandaDAO" %>
<jsp:useBean id="listaDomande" 
             class="it.capone.bean.ListaDomandeBean" 
             scope="request"/>
<% 
	
	//creo un oggetto dao che interagisce con il db
	DomandaDAO domandaDAO = new DomandaDAO();
    
	//l'oggetto dao interrogherà il db e popolerà il bean "listadomande" con il risultato della query
	domandaDAO.getDomande(listaDomande);
	
	//response.sendRedirect("viewListaDomande.jsp");  //utilizzandolo la lista delle domande si perde nel passaggio alla view
%>
<jsp:forward page="viewListaDomande.jsp"/>