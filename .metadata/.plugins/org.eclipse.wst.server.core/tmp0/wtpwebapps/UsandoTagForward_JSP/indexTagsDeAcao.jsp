<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>JSP - Tags de A??o</title>
</head>
<body>
<h2>Index Page</h2>
<p>Neste exemplo, estamos encaminhando a solicita??o/par?metros atrav?s da tag jsp:forward para o arquivo informaDataHora.jsp
com par?metro e o arquivo printdate.jsp imprime o valor do par?metro com data e hora.</p>
<jsp:forward page="informaDataHora.jsp" >
<jsp:param name="name" value="Usando o jsp:forward para encaminhar a p?gina para outro recurso..."/>
</jsp:forward>
</body>
</html>
