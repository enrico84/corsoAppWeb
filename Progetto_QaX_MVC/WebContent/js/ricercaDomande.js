/**
 * JQuery relativo alla ricerca Asincrona(Ajax-style) delle domande
 * collegato al pulsante "Cerca" della View "viewListaDomande"
 */

$(document).ready(function() {
	//registrazione degli event-handler al caricamento della pagina
	
	$('form[name="formAutoCompl"]').submit(ricercaDomanda);
});



function ricercaDomanda() {
	
	var contenuto = $('input[name="categoria"]').val();
	
	ajaxCercaDomanda(contenuto);
}

function ajaxCercaDomanda(contenuto) {
	
	/**SOLUZIONE STANDARD CON AJAX PURO*/
//	var xmlHttp = getXMLHttpRequest();
//	xmlHttp.onreadystatechange = function() {
//		if( (this.readyState == 4 || this.readyState == 1)){
//			var risposta = xmlHttp.responseText;
//			//risposta contiene il risultato della query
//			$("table#tableDefault").hide();
//			$("span#completaDom").text(risposta);
//			
//		}
//		else{
//			
//		}
//	}
//	
//	xmlHttp.open("GET", "ajaxRicercaDomanda.jsp?categoriaDomanda="+contenuto, "true");
//	xmlHttp.send();
	
	
//	/** OPPURE SOLUZIONE CON JQUERY - AJAX */ 
//	$.get("ajaxRicercaDomanda.jsp?categoriaDomanda="+contenuto,
//			function(risposta) {  //il parametro di questa function ("risposta") è equivalente al xmlHttp.responseText invito dal server
//			//risposta contiene il risultato della query
//			$("table#tableDefault").hide();
//		    $("span#completaDom").html(risposta);
//		}
//	);
	
	
	/** ALTRA SOLUZIONE CON JQUERY - AJAX */
	/** .load() prende la risposta del server e la inserisce negli elementi selezionati*/
	//$("span#completaDom").load("ajaxRicercaDomanda.jsp?categoriaDomanda="+contenuto);
//	$("span#completaDom").load("ajaxRicercaDomanda.jsp?categoriaDomanda="+contenuto, function( response, status, xhr ) {
//		if ( status == "error" ) {
//			  $( "span#completaDom" ).html( "Errore nella ricerca" );
//		} else {
//			if(response.length > 0 ) {
//				$("table#tableDefault").hide();
//				//$( "span#completaDom" ).html( response );
//			}
//			
//		}
//			 
//	});
	
	
	/** ALTRA SOLUZIONE CON JQUERY - AJAX */
	$.ajax({
		  url:"ajax/ajaxRicercaDomanda.jsp",
		  type: "POST",
		  data: { categoriaDomanda: contenuto},
		  success:function(result){
			  $("table#tableDefault").hide();
			  $( "span#completaDom" ).html( result );
		  },
		  error: function(richiesta,stato,errori){
			  $( "span#completaDom" ).html( "Errore nella ricerca" );
		  }
		});
	
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