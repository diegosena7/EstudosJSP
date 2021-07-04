<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:useBean id="user" class="beans.UsuarioBean" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usuário Novo</title>
</head>
<body>
	Dados do usuário novo: <br>
	<jsp:getProperty property="nome" name="user"/>
	<jsp:getProperty property="senha" name="user"/>
	<jsp:getProperty property="email" name="user"/>
</body>
</html>