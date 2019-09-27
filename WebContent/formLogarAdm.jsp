<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Login de Administrador</h3>
	<form action="sistema?logica=LogarAdm" method="post">
		Id: <br>
		<input type="text" name="id" required > <br><br>
		Senha: <br>
		<input type="password" name="senha" required> <br><br>
		<input type="submit" value="Logar">
	</form>
</body>
</html>