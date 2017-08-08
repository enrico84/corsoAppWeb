<%@page import="it.capone.service.CGestioneCategoria"%><%@page import="java.util.List;"%><%@
page language="java" contentType="text/plain; charset=UTF-8" pageEncoding="UTF-8"%><%

//CONTROLLER
//contentType="text/plain; perchè la pagina non genera html, ma genere del testo semplice-->
//In tutte le JSP c'è un accapo all'inizio della prima riga, basta vedere il sorgente della pagina che inserisce 
//l'accapo automaticamente: disponendo i tag iniziali della pagina tutti uniti riesco ad eliminare gli spazi invisibili

//Prendo una stringa "testo" inviata dalla viewSelezionaCategoria.jsp e la passo allo strato DAO
//Il DAO effettua una query al DB tornando una lista delle categorie che cominciano con la parola inviata in "testo"

String testo = request.getParameter("categoria");   
CGestioneCategoria cGestCat = (CGestioneCategoria)request.getSession().getAttribute("cGestCat");
if(cGestCat == null) {
	cGestCat = new CGestioneCategoria();
    request.getSession().setAttribute("cGestCat", cGestCat);
}

List<String> completamenti = cGestCat.getCompletamenti(testo);
for (String s : completamenti){
	out.print(s+" ");
		
}

%>

