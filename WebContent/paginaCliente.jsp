<%@page import="com.giovanealvares.projeto1pwi.model.Seguro"%>
<%@page import="com.giovanealvares.projeto1pwi.model.Conta"%>
<%@page import="java.util.List"%>
<%@page import="com.giovanealvares.projeto1pwi.dao.ProdutoDAO"%>
<%@page import="com.giovanealvares.projeto1pwi.model.Produto"%>
<%@page import="com.giovanealvares.projeto1pwi.model.PessoaFisica"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RiverValley Web Company Ltda.</title>
</head>
<body>
	<h1>Pagina do Cliente</h1>
	<%
		PessoaFisica pf = (PessoaFisica) request.getAttribute("clienteLogado");
		String idCliente = Integer.toString(pf.getId());
	%>
	<h3>
		Bem-vindo
		<%=pf.getNome()%>
		<%=idCliente %>
	</h3>
	<h4>Suas Contas</h4>
	<form action="sistema?logica=AcessarConta" method="post">
		<select name="servicos">
			<%
			List<Conta> lista = new ProdutoDAO().listarProdutos(Integer.parseInt(idCliente));
		
	if (lista.isEmpty()){
		%>
			<option value='0'>Nenhum Servico</option>
			<%
			}else{
				for (Conta conta : lista) {
					switch (conta.getTipo()) {
					case 1:
						out.println("<option value='" + conta.getId() + "' >" + conta.getNumero()
								+ " - Conta Poupanca </option>");
						break;
					case 2:
						out.println("<option value='" + conta.getId() + "' >" + conta.getNumero()
								+ " - Conta Corrente </option>");
					}
				}
			}
		%>

		</select> <br> <br> <input type="submit" value="Acessar Conta">
	</form>
	<h4>Seus Seguros</h4>
	<%List<Seguro> listS = new ProdutoDAO().listarSeguros(Integer.parseInt(idCliente)); 	
	if (listS.isEmpty()){
		%>
	<h5>---Nenhum Seguro Contratado---</h5>
	<%
			}else{
				for (Seguro seguro : listS) {
					%>
	<form action="sistema?logica=CancelarSeguro" method="post">
		<h5>
			Numero da Apólice:
			<%=seguro.getNumero()%></h5>
		<h5>
			Valor: R$
			<%=seguro.getValor()%></h5>
		<h5>
			Situacao:
			<%
			if (seguro.isSituacao()) {

						out.println("Ativo");
					} else {

						out.println("Desativado");

					}
		%>
		</h5>
		<input type="submit" value="Cancelar Seguro">
		<br>---------------------------------
	</form>

	<%
					}
				}
			
		%>
	<h4>Contratar Servicos</h4>

	<form action="formContaPoupanca.jsp">
		<input type="hidden" name="id" value="<%=idCliente%>">
		<button type="submit" value="Enviar">Criar Conta Poupanca</button>

	</form>
	<br>
	<form action="formContaCorrente.jsp">
		<input type="hidden" name="id" value="<%=idCliente%>">
		<button type="submit" value="Enviar">Criar Conta Corrente</button>
		<br>
	</form>
	<br>
	<form action="formSeguro.jsp">
		<input type="hidden" name="id" value="<%=idCliente%>"> <input
			type="submit" value="Solicitar Seguro"></input> <br>
	</form>


</body>
</html>