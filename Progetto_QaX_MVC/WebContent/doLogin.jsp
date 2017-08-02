<!--  
	CONTROLLER 
	1) Controlla se esiste un dato utente nel db 
	2) se OK, setta alcune proprietà del "loginBean" (l'id nel metodo verifyUtente(), nome e password qui
	   e che rimarranno valide finchè non si effettua il logout
	3) Se tutto OK alla fine va alla HomePage 
--><%@page 
import="javafx.beans.property.SetProperty"%><%@page 
import="it.capone.dao.UtenteDAO, it.capone.bean.LoginBean" %><jsp:useBean 
  id="loginBean" class="it.capone.bean.LoginBean" scope="session" /><jsp:useBean 
  id="errBean"   class="it.capone.utility.ErrMsg" scope="request" /><% 
  
  	//Attributo inviatomi dalla Servlet "ControllerUtente" dopo aver modificato i dati 
    LoginBean utenteBean = (LoginBean) request.getSession().getAttribute("utenteBean");
    String nome = null;
    String password = null;
    
    // Se modifico i dati dell'utente entro qui
    if(utenteBean != null){
    	nome = utenteBean.getNome();
    	password = utenteBean.getPassword();
    }
    else {  //Primo accesso
    	nome = request.getParameter("nome");
    	password = request.getParameter("password");
    }
    
	
	UtenteDAO utenteDAO = new UtenteDAO();
	boolean exist = utenteDAO.verifyUtente(loginBean, nome, password);
	//login.setNome(nome);
	//login.setPassword(password);
	if(exist)  
	{            								  //OK
%>	
		<jsp:setProperty name="loginBean" property="nome" />
		<jsp:setProperty name="loginBean" property="password" />		
		<jsp:forward page="doListaDomande.jsp" />
<%  }else { 
		errBean.add(loginBean.getErrorMsg());    //ERRORI
%>
		<jsp:forward page="viewLogin.jsp" />
<%  } %>		


<% 
	//if(loginBean.isValidLogin()) {
%>
<% //} else { 
	//	 for (String err : loginBean.getErrs().getErrori())	
		// 	errBean.add(err);
%>		
<% //} %>
