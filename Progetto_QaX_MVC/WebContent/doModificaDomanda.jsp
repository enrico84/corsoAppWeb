<!-- 
	CONTROLLER 
	1. Prende i campi inviati dal form e li passa al DAO
	2. Il DAO efettua un update dei campi inviati
	3. Dopo l'update si passa al Controller "doMieDomande.jsp", il quale elaborerà la nuova lista 
	   di domande che saranno visualizzate dalla View 
 --><%@page 
         import="it.capone.dao.DomandaDAO" %><%@page
         import="it.capone.service.CGestioneDomande" %><jsp:useBean 
         id="domandaBean" class="it.capone.bean.DomandaBean" scope="request"/><jsp:useBean 
         id="categoriaBean" class="it.capone.bean.CategoriaBean" scope="request"/><jsp:useBean 
         id="errBean" class="it.capone.utility.ErrMsg" scope="request"/><jsp:setProperty 
         property="titolo" name="domandaBean"/><jsp:setProperty 
         property="descrizione" name="domandaBean"/><jsp:setProperty 
         property="iddomanda" name="domandaBean"/><jsp:setProperty 
         property="idcategoria" name="categoriaBean"/><jsp:setProperty 
         property="nome" name="categoriaBean" param="categoria"/>

<% 
	DomandaDAO domandaDAO = new DomandaDAO();
    CGestioneDomande cGestDom = (CGestioneDomande)request.getSession().getAttribute("cGestDom");
	
	if(domandaBean.getTitolo() == null || domandaBean.getTitolo().equals("")) {
		errBean.add("Il titolo non deve essere vuoto");
		domandaBean.setTitolo("");
	}
	if(domandaBean.getDescrizione() == null || domandaBean.getDescrizione().equals("")) { 
		errBean.add("La descrizione non deve essere vuota");
		domandaBean.setDescrizione("");
	}
	if(categoriaBean.getNome() == null || categoriaBean.getNome().equals("")) {
		errBean.add("La categoria non deve essere vuota");
		categoriaBean.setNome("");
	}
   	
	if(errBean.isListErr()) {
%>

		<jsp:forward page="viewModificaDomanda.jsp"/>
	
<%  
	}
	else {
		
		//domandaDAO.aggiornaDomanda(categoriaBean, domandaBean.getIddomanda(), domandaBean.getTitolo(), 
                //domandaBean.getDescrizione(), categoriaBean.getNome());
		cGestDom.aggiornaDomanda(categoriaBean, domandaBean.getIddomanda(), domandaBean.getTitolo(), 
                domandaBean.getDescrizione(), categoriaBean.getNome());
%>	
		<jsp:forward page="doMieDomande.jsp"/>
<% }%>