<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>JSP - Tags de A��o (Forward)</title>
</head>
<body>
<p>Neste exemplo, estamos encaminhando a solicita��o/par�metros pela classe: indexTagsDeAcao.jsp atrav�s da tag jsp:forward para o arquivo informaDataHora.jsp com par�metro 
e o arquivo printdate.jsp imprime o valor do par�metro com data e hora.</p>
<br>
<% out.print("Hoje �: " + java.util.Calendar.getInstance().getTime()); %>
<br/>
O par�metro �: <%=request.getParameter("name") %>
</body>
</html>