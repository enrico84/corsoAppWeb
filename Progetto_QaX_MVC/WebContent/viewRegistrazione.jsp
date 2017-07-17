<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="errBean" 
			class="it.capone.utility.ErrMsg" 
			scope="request"/><!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrazione utente</title>
<link type="text/css" rel="stylesheet" href="css/sito.css"/>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="js/registration.js"></script>
</head>
<body>
	 <jsp:include page="fragment/header.jsp" flush="true"/>
	 <div class="clearfix">    
            <div class = "column content">
            <h1>Registrazione</h1>
            	<% 
            		if(errBean.isListErr()) {
            	%>	
            		<p><%
            			for(String err: errBean.getErrori()) 
            				out.println("<p>"+err+"</p>");
            			%>
            	<% 	
            		}
            	%>
            <form name="regForm" method="post" action="doRegistration.jsp">
            		<table>
            		<tr><td>Username:</td><td><input type="text" name="nome"/></td></tr>      
            		<tr><td>Password:</td><td><input type="text" name="password"/></td></tr>
            		<tr><td>Email:</td><td><input type="text" name="email" id="email"/></td></tr>
            		<tr><td><input type="submit" value="Registrati"/></td><td><input type="reset" value="Resetta i campi"/></td></tr>
            		</table>
            		<p id="registrationErr"></p>
            	</form>
            </div> 
     </div>       
      <jsp:include page="fragment/footer.jsp" flush="true"/>
</body>
</html>