/**
 * JQuery che verifica il corretto completamento dei campi della view "viewCreaDomanda.jsp"
 */

$(document).ready(function() {
	//registro gli event-handler al caricamento della pagina
	
	$("input[name='titolo'").blur(validaTesto);
	$("textarea[name='descrizione']").blur(validaTesto);
	$("input[name='categoria']").blur(validaTesto);
	$("form[name='domandaForm']").submit(validaForm);
});


//Funzione chiamata dall'evento "blur" delle caselle di testo Input, Descrizione e Categoria
function validaTesto() {
	
	//this -> nodo DOM della casella di input
	//$(this) -> oggetto Jquery relativo alla casella di input
	var contenuto = $(this).val();
	if(contenuto.length==0 || contenuto.length==null) {
		$("p#modificaErr").css("color", "red");
		$("p#modificaErr").text("Il contenuto della casella " +$(this).attr("name")+ " non deve essere vuoto");
	}
	else {
		$("p#modificaErr").text("");
	}
	
}


//Funzione chiamata dall'evento "submit" del form
function validaForm() {
	if ( ($("input[name='titolo'").val().length != 0) && ($("textarea[name='descrizione']").val().length != 0) && 
		 ($("input[name='categoria']").val().length != 0) ) {
		
		$("p#modificaErr").text("");
		return true;

	}
	else{
		$("p#modificaErr").css("color", "red");
		$("p#modificaErr").text("Non tutti i campi sono valorizzati correttamente, ricontrolla per favore");
		return false;
	}
}