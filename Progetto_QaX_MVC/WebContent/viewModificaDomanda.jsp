<jsp:useBean id="loginBean" class="it.capone.bean.LoginBean" scope="session" />
<jsp:useBean id="domandaBean" class="it.capone.bean.DomandaBean" scope="request" />
<jsp:useBean id="categoriaBean" class="it.capone.bean.CategoriaBean" scope="request" />
<jsp:useBean id="errBean" class="it.capone.utility.ErrMsg" scope="request"/><%@ 
page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Modifica domanda</title>
<link type="text/css" rel="stylesheet" href="css/sito.css">
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="js/verifyDomanda.js"></script>
<script type="text/javascript" src="js/popolaCategoria.js"></script>
</head>
<body>
	<jsp:include page="fragment/header.jsp" flush="true" />

	<div class="clearfix">
		<div class="column content">
		
			<h1>Modifica domanda</h1>
			<div>
				<% 
            		if(errBean.isListErr()) {
            	%>	
            			<%
            			for(String err: errBean.getErrori()) 
            				out.println("<p>"+err+"</p>");
            			%>
            	<% 	
            		}
            	%>
				<form action="doModificaDomanda.jsp" method="POST" name="domandaForm">
					<table>
            		<tr><td>Titolo:</td><td><input type="text" name="titolo" value="${domandaBean.titolo}"></td></tr>      
            		<tr><td>Descrizione:</td><td><textarea rows="4" cols="50" name="descrizione"><%=domandaBean.getDescrizione() %></textarea></td></tr>
            		<tr><td>Categoria:</td>
            			<td>
            				<select name="selectCategoria"><option value="">Scegli la categoria</option>
            			    </select>
            			</td>
            		<tr>
            			<td>Se la categoria non è presente tra quelle elencate, aggiungila:</td><td><input type="text" name="categoria" value="${categoriaBean.nome}">
            			<input type="hidden" name="iddomanda" value="${domandaBean.iddomanda}">
            			<input type="hidden" name="idcategoria" value="${categoriaBean.idcategoria}">
            			</td>
            		</tr>
            		
            		<tr><td><input type="submit" value="Modifica"/></td><td><input type="reset" value="Resetta i campi"/></td></tr>
            		</table>
            		<p id="modificaErr"></p>
				</form>
			</div>
			
		</div>
		<jsp:include page="fragment/side.jsp" flush="true" />
	</div>

	<jsp:include page="fragment/footer.jsp" flush="true" />
</body>
</html>