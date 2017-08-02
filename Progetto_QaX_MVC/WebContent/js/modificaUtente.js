/**
 * JQUERY che controlla che i campi della View "viewModificaUtente" siano tutti riempiti e validi
 */

$(document).ready(function() {

	$("input[name='password']").blur(validaTesto);
	$("input[name='email']").blur(validaTesto);
	$("form[name='modForm']").submit(validaForm);
});


//Funzione chiamata dall'evento "blur" delle caselle di testo Login e Password
function validaTesto() {
	
	//this --> nodo DOM della casella di input
	//$(this) --> oggetto JQuery relativo alla casella di input
	var contenuto = $(this).val();
	if(contenuto.length <= 0 || contenuto == null) {
		$("span#errForm").css("color", "red");
		$("span#errForm").text("Il campo " +$(this).attr("name")+ " non deve essere vuoto!")
	}
	else{
		$("span#errForm").text("");
	}
}


//Funzione chiamata dall'evento "submit" del form
function validaForm() {
	if( ($("input[name='password']").val().length != 0) && ($("input[name='email']").val().length != 0 ) &&
			validate()) {
		$("span#errForm").text("");
		return true;
	}
	else {
		$("span#errForm").css("color", "red");
		$("span#errForm").text("Uno o più campi non validi, ricontrollare");
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
	  $("span#errForm").text("");
	  var email = $("input[name='email']").val();
	  if(email.length <= 0){
		  $("span#errForm").css("color", "red");
		  $("span#errForm").text("Il campo email deve essere valorizzato");
		  valida = false;
	  }
	  if (validateEmail(email)) {
	    $("span#errForm").text(email + " valida  :)");
	    $("span#errForm").css("color", "green");
	    valida = true;
	  } else {
	    $("span#errForm").text(email + " non valida  :(");
	    $("span#errForm").css("color", "red");
	    valida = false;
	  }
	  return valida;
}

