/**
 * Javascript della viewLogin.jsp
 * 
 */

$(document).ready(function(){
	//registrazione degli event handler al caricamento della pagina
	
	$('input[name="nome"]').blur(validaTesto);
	$('input[name="password"]').blur(validaTesto);
	$('form[name="loginForm"]').submit(validaForm);
});


//Funzione chiamata all'evento "blur" delle caselle di testo Login e Password
function validaTesto(){
	
	//this -> nodo DOM della casella di input
	//$(this) -> oggetto Jquery relativo alla casella di input
	var contenuto = $(this).val();
	if(contenuto.length == 0)
		$("p#loginErr").text("Il campo "+$(this).attr("name")+" non deve essere vuoto");
	else
		$("p#loginErr").text("")
}


//Controlla l'intero form al momento del submission
function validaForm() {
	if( $('input[name="nome"]').val().length == 0 || $('input[name="password"]').val().length == 0) {
		$("p#loginErr").text("Impossibile inviare il form, campi mancanti");
		return false;
	}
	else {
		$("p#loginErr").text("")
		return true;
	}
}
