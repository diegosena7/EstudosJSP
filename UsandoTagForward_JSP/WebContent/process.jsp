<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>JSP - Exception</title>
</head>
<body>
<h2>Resultado</h2>
<%

String num1 = request.getParameter("numero1");
String num2 = request.getParameter("numero2");

int a = Integer.parseInt(num1);
int b = Integer.parseInt(num2);
int c = a/b;
out.print("Divis�o dos n�meros informados = " + c);

%>
</body>
</html>