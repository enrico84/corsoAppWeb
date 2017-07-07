<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="errBean" 
			class="it.capone.utility.ErrMsg" 
			scope="request"/>
<html>
    <head>
        <title>Login page</title>
        <link type="text/css" rel="stylesheet" href="css/sito.css">
        <script type="text/javascript" src="js/jquery-3.2.1.js"></script>
        <script type="text/javascript" src="js/jsLogin.js"></script>
    </head>
    <body>
        <jsp:include page="fragment/header.jsp" flush="true"/>
        
        <div class="clearfix">    
            <div class = "column content">
            <h1>Login</h1>
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
            	<form name="loginForm" method="post" action="doLoginANDRegistrazione.jsp">
            		<p>
            			<label>Nome: <input type="text" name="nome"/></label>      
            			<label>Password: <input type="text" name="password"/></label>
            		</p>
            		<p><input type="submit" value="ENTRA"/></p>
            		<p><a href="doRegistrazione.jsp">Registrazione</a></p>
            		<p id="loginErr"></p>
            	</form>
            </div>
            
            <jsp:include page="fragment/side.jsp" flush="true"/>
        </div>
        
        <jsp:include page="fragment/footer.jsp" flush="true"/>
    </body>    
</html>