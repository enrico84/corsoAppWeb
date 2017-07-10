/**
 * JQuery relativo all'autocompletamento
 */
$(document).ready(function(){
	//registrazione degli event handler al caricamento della pagina
	
	$("input[name='categoria']").keyup(completa);
	
});


//Propone possibili completamenti della categoria per la quale l'utente 
//ha cominciato a scrivere la prima lettera
function completa() {
	
	//this -> nodo DOM della casella di input
	//$(this) -> oggetto Jquery relativo alla casella di input
	var testo=$(this).val();
	//var completamenti="aaa bbb ccc ddd";
	
	//$("span#completaCat").text(completamenti);
	if(testo.length>0)
		ajaxCompleta(testo);
	else
		$("span#completaCat").text("");
}

function ajaxCompleta(testo) {
	/**SOLUZIONE STANDARD CON AJAX PURO*/
	
//	var xmlHttp = getXMLHttpRequest();  							//1° istruz. eseguita	
// 	
//	xmlHttp.onreadystatechange = function() {                       //4° e ultima istruz. eseguita se tutto va bene
//		if(xmlHttp.readyState == 4){
//			var completamenti = xmlHttp.responseText;
//			$("span#completaCat").text(completamenti);
//		}
//	};
//	
//	xmlHttp.open("GET", "ajaxCompletaCategoria.jsp?testo="+testo);  //2° istruz. eseguita
//	xmlHttp.send();													//3° istruz. eseguita	
	
	
	/** OPPURE SOLUZIONE CON JQUERY - AJAX */ 
	$.get("ajaxCompletaCategoria.jsp?categoria="+testo, 
		   function(risposta){  //il parametro di questa function ("risposta") è equivalente al xmlHttp.responseText invito dal server
				$("span#completaCat").text(risposta);
	});
	
	
	/** ALTRA SOLUZIONE CON JQUERY - AJAX */
	/** .load() prende la risposta del server e la inserisce negli elementi selezionati*/
	//$("span#completaCat").load("ajaxCompletaCategoria.jsp?categoria="+testo);
}


/**
 * Ritorna l'oggetto XMLHttpRequest per effettuare le chiamata Ajax
 * compatibile anche con old-browser 
 */
function getXMLHttpRequest() {
	try{
		// Firefox, Opera 8.0+, Safari
		xmlHttp=new XMLHttpRequest();							    
	}
	catch(e) {
		// Internet Explorer
		try{ // Internet Explorer 6.0+
			xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
		}
		catch(e) {
			try{ // Internet Explorer 5.5+
				xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
			}
			catch(e) {
				alert("Your browser does not support AJAX!");
				return null;
			}
		}
	}
	
	return xmlHttp;
	
}