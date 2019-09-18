<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Solicitar Seguro</title>
</head>
<body>
	<h3>Solicitar Seguro</h3>
	<h4>Para ter um seguro se torna necessario fazer uma pesquisa em suas financas para verificar se podemos disponibilizar uma apolice. Para isso informe abaixo o valor da apolice que deseja solicitar.</h4>
	<form action="sistema?logica=CriarSeguro" method="post">
		Valor da apolice: <br>
		R$ <input type="number" name="nome" > <br><br>
		 
		<input type="submit" value="Solicitar">
	</form>
</body>
</html>