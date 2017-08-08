<!-- 
	 Controller che ottiene la lista delle domande e le passa alla viewList
	 per l'impaginazione
--><%@page 
   import="it.capone.dao.DomandaDAO" %><%@page 
   import="it.capone.service.CGestioneDomande" %><jsp:useBean 
   id="listaDomande" class="it.capone.bean.ListaDomandeBean" scope="request"/>
<% 
	
	//Creo un oggetto dao che interagisce con il db
	
	//DomandaDAO domandaDAO = new DomandaDAO();
  
	// Creo un oggetto CONTROLLER "CGestioneDomande" che mi durerà per tutta la sessione utente, e che 
	// mi porto avanti negli altri Controller
    CGestioneDomande cGestDom = (CGestioneDomande)request.getSession().getAttribute("cGestDom");
    if(cGestDom == null) {
    	cGestDom = new CGestioneDomande();
        request.getSession().setAttribute("cGestDom", cGestDom);
    }
	//l'oggetto dao interrogherà il db e popolerà il bean "listadomande" con il risultato della query
	//domandaDAO.getDomande(listaDomande);
	cGestDom.getDomande(listaDomande);
	
	//response.sendRedirect("viewListaDomande.jsp");  //utilizzandolo la lista delle domande si perde nel passaggio alla view
%>
<jsp:forward page="viewListaDomande.jsp"/>