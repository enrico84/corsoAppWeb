<!--
	CONTROLLER che Elimina o Modifica la domanda dato il il campo "tipo" passato nell'url
	
	//Eliminazione:
	- Prende l'id inviato dalla VIEW "viewMyListaDomande"
	- Passa l'id allo strato DAO, il quale eliminerà la domanda associata nel db
	- Dopo l'eliminazione effettua una redirect al Controller "doMieDomande" che ricrea
	    la lista delle domande aggiornate  
 --><jsp:useBean 
 id="domandaBean" class="it.capone.bean.DomandaBean" scope="request"/><jsp:useBean 
 id="categoriaBean" class="it.capone.bean.CategoriaBean" scope="request"/><%@page 
 import="it.capone.dao.DomandaDAO, it.capone.bean.DomandaBean" %><%@page
 import="it.capone.service.CGestioneDomande" %><%

//String iddomanda = request.getParameter("iddomanda"); 		
String tipo = request.getParameter("tipo");
DomandaDAO domandaDAO = new DomandaDAO();
CGestioneDomande cGestDom = (CGestioneDomande)request.getSession().getAttribute("cGestDom");

%>
<jsp:setProperty  name="domandaBean" property="iddomanda" param="iddomanda"/>
<%
if(tipo.equals("elimina")) {
	//domandaDAO.eliminaDomanda(domandaBean.getIddomanda());  //1° modo
	//domandaDAO.eliminaDomanda(iddomanda);          //2° modo 
	cGestDom.eliminaDomanda(domandaBean.getIddomanda()); // 3° modo
	
	response.sendRedirect("doMieDomande.jsp");
}
else {
	
	//Setto i Bean DomandaBean e CategoriaBean con i campi da visualizzare poi nella View "viewModificaDomanda"
	//DomandaBean domandaTemp = domandaDAO.prendiDomanda(domandaBean.getIddomanda());
	DomandaBean domandaTemp = cGestDom.prendiDomanda(domandaBean.getIddomanda());
	
	domandaBean.setTitolo(domandaTemp.getTitolo());
	domandaBean.setDescrizione(domandaTemp.getDescrizione());
	domandaBean.setCategoria(domandaTemp.getCategoria());
	categoriaBean.setIdcategoria(domandaTemp.getCategoria().getIdcategoria());
	categoriaBean.setNome(domandaTemp.getCategoria().getNome());
	
%>
	
    <jsp:forward page="viewModificaDomanda.jsp"/>
    
<% } %>