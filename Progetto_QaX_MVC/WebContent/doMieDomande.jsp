<!-- 
	 Controller che ottiene la lista delle domande di un utente loggato e le passa alla viewList
	 per l'impaginazione
-->
<%@page 
import="it.capone.dao.DomandaDAO" %><%@page 
import="it.capone.service.CGestioneDomande" %><jsp:useBean 
id="loginBean" class="it.capone.bean.LoginBean" scope="session"/><jsp:useBean 
id="listaDomande" class="it.capone.bean.ListaDomandeBean" scope="request"/><%

	//Creo un oggetto dao che interagisce con il db
	//DomandaDAO domandaDAO = new DomandaDAO();
    CGestioneDomande cGestDom = (CGestioneDomande)request.getSession().getAttribute("cGestDom");
	
    //l'oggetto dao interrogherà il db e popolerà il bean "listadomande" con il risultato della query
	//domandaDAO.getMieDomande(loginBean.getNome(), loginBean.getPassword(), listaDomande);
    cGestDom.getMieDomande(loginBean.getNome(), loginBean.getPassword(), listaDomande);
	
%>
<jsp:forward page="viewMyListaDomande.jsp"/>