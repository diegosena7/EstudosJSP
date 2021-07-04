<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>JSP - Tags de Ação (Forward)</title>
</head>
<body>
<p>Neste exemplo, estamos encaminhando a solicitação/parâmetros pela classe: indexTagsDeAcao.jsp através da tag jsp:forward para o arquivo informaDataHora.jsp com parâmetro 
e o arquivo printdate.jsp imprime o valor do parâmetro com data e hora.</p>
<br>
<% out.print("Hoje é: " + java.util.Calendar.getInstance().getTime()); %>
<br/>
O parâmetro é: <%=request.getParameter("name") %>
</body>
</html>