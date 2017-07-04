<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrazione utente</title>
<link rel="stylesheet" href="css/sito.css">
</head>
<body>
	 <jsp:include page="fragment/header.jsp" flush="true"/>
	 <div class="clearfix">    
            <div class = "column content">
            <h1>Registrazione</h1>
            <form name="loginForm" method="post" action="doRegistration.jsp">
            		<p>
            			<label>Login: <input type="text" name="login"/></label>      
            			<label>Password: <input type="text" name="password"/></label>
            		</p>
            		<p><input type="submit" value="Registrati"/></p>
            		<p id="loginErr"></p>
            	</form>
            </div> 
     </div>       
      <jsp:include page="fragment/footer.jsp" flush="true"/>
</body>
</html>