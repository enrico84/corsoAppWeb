<!-- 
	 CONTROLLER 
	 dato l'id, ottiene la singola domanda con l'elenco delle risposte, passando poi alla view
-->
<%@page import="it.capone.dao.DomandaDAO" %>
<%@page import="it.capone.service.CGestioneDomande"%>
<jsp:useBean id="domanda" 
             class="it.capone.bean.DomandaBean" 
             scope="request" >
</jsp:useBean>             
<jsp:useBean id="listaRisposta" 
             class="it.capone.bean.ListaRisposteBean" 
             scope="request" >
</jsp:useBean>                          
<% 
	String id = request.getParameter("iddomanda");    //recupero l'id inviata da "viewListaDomande"
	int id_domanda = Integer.parseInt(id); 
	
	CGestioneDomande cGestDom = (CGestioneDomande)request.getSession().getAttribute("cGestDom");
    
	//creo un oggetto dao che interagisce con il db
	//DomandaDAO domandaDAO = new DomandaDAO();
	
	
	//l'oggetto DAO interrogha il db e popola i bean "domanda" e "listaRisposte" con il risultato della query
	//questi bean popolati saranno poi passati alla view
	//domandaDAO.getDomandaConRisposte(id_domanda, domanda, listaRisposta);
	cGestDom.getDomandaConRisposte(id_domanda, domanda, listaRisposta);
%>
<jsp:forward page="viewDettaglioDomanda.jsp"/>