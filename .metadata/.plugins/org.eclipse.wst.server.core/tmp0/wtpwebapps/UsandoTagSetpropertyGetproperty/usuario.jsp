<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<jsp:useBean id="user" class="beans.UsuarioBean"></jsp:useBean>
<jsp:setProperty property="*" name="user"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usando setProperty e getProperty</title>
</head>
<body>
	Dados do usu?rio: <br>
	Nome: <jsp:getProperty property="nome" name="user"/><br>
	Senha: <jsp:getProperty property="senha" name="user"/><br>
	E-mail: <jsp:getProperty property="email" name="user"/><br><br>
	<a href="usuarioNew.jsp">Novo Usu?rio</a>
</body>
</html>

<!-- Tags de a??o jsp: setProperty e jsp: getProperty -->
<!-- Essa classe instancia um objeto do tipo UsuarioBean chamado user, seta todos os valores provenientes do
formul?rio d classe index.jsp atrav?s do atributo setProperty e property="*" e obtem os valores atrav?s do
atributo getProperty

A tag de a??o jsp: setProperty define um valor ou valores de propriedade em um atributo do tipo bean usando o m?todo setter.
A tag de a??o jsp: getProperty retorna o valor do atributo do tipo bean usando o m?todo getter.
 -->