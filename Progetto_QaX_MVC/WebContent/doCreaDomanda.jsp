<!-- 
	CONTROLLER inserimento domands
	Prende i dati dalla "viewCreaDomanda.jsp" e li invia al DAO
	Il DAO domandaDAO eseguirà una query di inserimento al db, tornando il risultato atteso
 -->
 <%@page 
 import="java.util.Calendar"%><%@page 
 import="java.sql.Timestamp"%><%@page 
 import="it.capone.dao.DomandaDAO" %><%@page
 import="it.capone.service.CGestioneDomande" %><jsp:useBean 
 id="loginBean" class="it.capone.bean.LoginBean" scope="session"/><jsp:useBean 
 id="domandaBean" class="it.capone.bean.DomandaBean" scope="request"/><jsp:useBean 
 id="errBean" class="it.capone.utility.ErrMsg" scope="request"/><%  
 
 String titolo = request.getParameter("titolo");
 String descrizione = request.getParameter("descrizione");
 String selectCat = request.getParameter("selectCategoria");
 String categoria = request.getParameter("categ");
 CGestioneDomande cGestDom = (CGestioneDomande)request.getSession().getAttribute("cGestDom");
 
DomandaDAO domandaDAO = new DomandaDAO();
if( (titolo != null && !titolo.equals("") ) && 
		(descrizione != null && !descrizione.equals("") ) && 
		( (selectCat != null && !selectCat.equals("") ) || (categoria != null && !categoria.equals("") ) )  && 
		loginBean.getIdutente() > 0 )  {  ///OK 
	    
	    //String cate = selectCat.equals("") ? selectCat : categoria;
	    String cate;
		if(!selectCat.equals("")) {
			cate=selectCat;
		}
		else
			cate=categoria;
		
		//domandaDAO.creaDomanda(titolo, descrizione, categoria, loginBean);
		cGestDom.creaDomanda(titolo, descrizione, cate, loginBean);

		response.sendRedirect("doMieDomande.jsp");		

} else { 
		errBean.add(domandaBean.getErrorMsg());    //CONTROLLO ERRORI LATO SERVER 
%>
		<jsp:forward page="viewCreaDomanda.jsp" />
<%  } %>
