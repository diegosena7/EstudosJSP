<h1>First JSP</h1>  
<%  
Cookie ck=new Cookie("nome","Diego Sena");  
response.addCookie(ck);  
%>  
<a href="process.jsp">click</a>  