<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formul?rio</title>
</head>
<body>
	<form action="usuario.jsp" method = "post">
		Nome: <input type="text" name="nome"><br><br>
		Senha: <input type="password" name="senha"><br><br>
		E-mail: <input type="text" name="email"><br><br>
		<input type="submit" value="Enviar">
	</form>
</body>
</html>
<!-- Classe respons?vel pela entrada de valores que ? enviado para a classe usuario.jsp-->