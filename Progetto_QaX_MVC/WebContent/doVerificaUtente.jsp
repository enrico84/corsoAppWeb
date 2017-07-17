<jsp:useBean id="loginBean" class="it.capone.bean.LoginBean" scope="session"/>
<jsp:useBean id="errBean" class="it.capone.utility.ErrMsg" scope="request"/>
<% 
	if(!loginBean.isValidLogin()) {
		errBean.add("Non puoi accedere alla pagina, devi prima autenticarti");
		//response.sendRedirect("viewLogin.jsp");   //se usata PERDE i dati del bean "errBean" durante la redirect
		
%>
	<jsp:forward page="viewLogin.jsp"/>             <!-- NON perde i dati di "errBean" durante la redirect -->
<% } %>