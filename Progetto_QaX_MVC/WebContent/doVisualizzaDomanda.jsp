<!-- 
	 CONTROLLER 
	 dato l'id, ottiene la singola domanda con l'elenco delle risposte, passando  poi alla view
-->
<%@page import="it.capone.bean.DomandaBean"%>
<%@page import="it.capone.dao.DomandaDAO" %>
<jsp:useBean id="listaDomande" 
             class="it.capone.bean.ListaDomandeBean" 
             scope="request"/>
<jsp:useBean id="domandaBean" 
             class="it.capone.bean.DomandaBean" 
             scope="request">
</jsp:useBean>
<% 
	String id = request.getParameter("id");    //recupero l'id inviata da "viewListaDomande.jsp"
	int id_domanda = Integer.parseInt(id); 

	//creo un oggetto dao che interagisce con il db
	DomandaDAO domandaDAO = new DomandaDAO();
    
	//l'oggetto dao interrogherà il db e popolerà il bean "domanda" con il risultato della query
	//domanda.getDomande(id);
	//DomandaBean domanda = domandaDAO.getDomanda(id);
	
	
	
%>
<jsp:forward page="viewDettaglioDomanda.jsp"/>