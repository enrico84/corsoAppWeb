/**
 * 	Controlli JQuery per il form di registrazione viewRegistrazione.jsp
 */
$(document).ready(function(){
	//registrazione degli event handler al caricamento della pagina
	
	$('input[name="nome"]').blur(validaTesto);
	$('input[name="password"]').blur(validaTesto);
	$('input[name="email"]').blur(validate);
	$('form[name="regForm"]').submit(validaForm);
});


//Funzione chiamata all'evento "blur" delle caselle di testo Login e Password
function validaTesto() {
	
	//this -> nodo DOM della casella di input
	//$(this) -> oggetto Jquery relativo alla casella di input
	var contenuto = $(this).val();
	if(contenuto.length == 0) {
		$("p#registrationErr").css("color", "red");
		$("p#registrationErr").text("Il campo " +$(this).attr("name")+ " deve essere valorizzato");
	} 
	else{
		$("p#registrationErr").text("");
	}
}


//Funzione chiamata dall'evento "submit" del form
function validaForm() {
	if( ($('input[name="nome"]').val().length != 0) && ($('input[name="password"]').val().length != 0) && 
			($('input[name="email"]').val().length != 0) && validate()) {
		$("p#registrationErr").text("");
		return true;
	}else{
		$("p#registrationErr").css("color", "red");
		$("p#registrationErr").text("Non tutti i campi sono valorizzati correttamente, ricontrolla per favore");
		return false;
	}
		
}


//Regular expressions per validare l'email
function validateEmail(email) {
	  var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	  return re.test(email);
}

function validate() {
	  var valida = false;
	  $("p#registrationErr").text("");
	  var email = $("#email").val();
	  if(email.length == 0){
		  $("p#registrationErr").css("color", "red");
		  $("p#registrationErr").text("Il campo email deve essere valorizzato");
		  valida = false;
	  }
	  if (validateEmail(email)) {
	    $("p#registrationErr").text(email + " valida  :)");
	    $("p#registrationErr").css("color", "green");
	    valida = true;
	  } else {
	    $("p#registrationErr").text(email + " non valida  :(");
	    $("p#registrationErr").css("color", "red");
	    valida = false;
	  }
	  return valida;
	}

//$("#validate").bind("click", validate);

