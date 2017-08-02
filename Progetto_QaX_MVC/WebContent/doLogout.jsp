<!-- 
	CONTROLLER
	Effettua il logout dell'utente loggato e ritorna alla pagina iniziale
 -->
<jsp:useBean id="loginBean" class="it.capone.bean.LoginBean" scope="session" />
<% 
	loginBean.clear();
   
	//passa il controllo a viewLista per impaginarle/visualizzarle
	
%>
<jsp:forward page="doListaDomande.jsp"></jsp:forward>

