<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Pessoa Fisica</title>
</head>
<body>
	<h3>Login Pessoa Fisica</h3>
	<form action="sistema?logica=LogarPessoaFisica" method="post">
		Nome da Mae: <br>
		<input type="text" name="nomeMae" > <br><br>
		CPF: <br>
		<input type="text" name="cpf"> <br><br>
		<input type="submit" value="Logar">
	</form>
</body>
</html>