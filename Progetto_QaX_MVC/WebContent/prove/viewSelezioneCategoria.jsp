<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; utf-8">
<title>Lezione 18 del corso di App. Web</title>
<script type="text/javascript" src="../js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="../js/selezionaCategoria.js"></script>
</head>
<body>
	<h1>Scelta della categoria con Ajax</h1>
	<form action="sceltacategoria" method="GET">
		<p>
			<label>Categoria: <input type="text" name="categoria"></label>
			<span id="completaCat"></span>
		</p>
		<p>
			<label><input type="submit" name="Salva"></label>
		</p>
		
	</form>
</body>
</html>