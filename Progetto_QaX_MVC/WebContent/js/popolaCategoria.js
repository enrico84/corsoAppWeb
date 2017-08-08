/**
 * AJAX-JQUERY per popolare una <select><option> con le varie Categorie del Database
 */
$(document).ready(function(){
	//Event-handler che uso per registrare gli eventi al caricamento della pagina
	$("select[name='selectCategoria']").focus(popola);
	
	//Utilizzo di un'altra funzione anonima per registre l'evento del click
//	$("option").click(function() { 
//
//		alert("Ciao");
//
//	});
	
});

//Popola la <select> in maniera dinamica non appena l'utente clicca su di essa
function popola() {
	
	//1° Modo con la funzione JQUERY - GET 
//	$.get("ajaxPopolaCategoria.jsp", 
//			function(risposta){      //il parametro "risposta" contiene la risposta inviata dal server
//				$("select[name='selectCategoria']").html(risposta);
//			});
	
	//2° Modo con la funzione JQUERY - AJAX
	$.ajax({
		  url:"ajax/ajaxPopolaCategoria.jsp",
		  type: "GET",
		  success:function(result){
			  $("select[name='selectCategoria']").html(result);
		  }
		});
	
}




