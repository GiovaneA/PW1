<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Pessoa Juridica</title>
</head>
<body>
	<h3>Login Pessoa Juridica</h3>
	<form action="sistema?logica=LogarPessoaJuridica" method="post">
		Nome Fantasia: <br>
		<input type="text" name="nomeFantasia" required> <br><br>
		CNPJ: <br>
		<input type="text" name="cnpj" required> <br><br>
		
		<input type="submit" value="Logar">
	</form>
</body>
</html>
