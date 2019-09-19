<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Clientes</title>
</head>
<body>
	<h4>Lista de Clientes</h4>
	<table border="1">
		<tr>
			<th>Nome</th>
			<th>Endereco</th>
			<th>Telefone</th>
		</tr>
		<%
			List<Cliente> cliente = (List<Cliente>);

			for (Cliente c : Cliente) {
		%>
		<tr>
			<td><%=a.getNome()%></td>
			<td><%=a.getEndereco()%></td>
			<td><%=a.getTelefone()%></td>
			<td><a href="sistema?logica=ExcluirCliente=<%=a.getNome()%>">X</a></td>
		</tr>
		<%
			}
		%>
	</table>
	<br><br>
	<a href="PaginaInicial.jsp">Voltar</a>
</body>
</html>