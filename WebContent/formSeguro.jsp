<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Solicitar Seguro</title>
</head>
<body>
<%String id = request.getParameter("id"); 
String tipo = request.getParameter("tipo");%>
	<h3>Solicitar Seguro</h3>
	<h4>Para ter um seguro se torna necessario fazer uma pesquisa em suas financas para verificar se podemos disponibilizar uma apolice. Para isso informe abaixo o valor da apolice que deseja solicitar.</h4>
	<%if (tipo.equals("j")){ %>
		<form action="sistema?logica=CriarSeguroJ" method="post">
		<%}else{ %>
	<form action="sistema?logica=CriarSeguro" method="post">
	<%} %>
		Valor da apolice: <br>
		R$ <input type="number" name="valor" required> <br><br>
		 <input type=hidden name="idCliente" value="<%=id%>"><br>
		 
		<input type="submit" value="Solicitar">
	</form>
</body>
</html>