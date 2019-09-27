<%@page import="com.giovanealvares.projeto1pwi.model.ContaPoupanca"%>
<%@page import="com.giovanealvares.projeto1pwi.model.ContaCorrente"%>
<%@page import="com.giovanealvares.projeto1pwi.model.Relatorio"%>
<%@page import="com.giovanealvares.projeto1pwi.model.Seguro"%>
<%@page import="com.giovanealvares.projeto1pwi.model.Conta"%>
<%@page import="java.util.List"%>
<%@page import="com.giovanealvares.projeto1pwi.dao.ProdutoDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Relatorio de Servicos</title>
</head>
<body>
	<h2>Relatorio de Servicos</h2>

	<h3>=====Pessoa Fisica=====</h3>

	<h4>-----Contas-----</h4>
	<%
		Relatorio r = new Relatorio();
		ProdutoDAO pd = new ProdutoDAO();
		List<Conta> listContasF = pd.admContasF();
		List<Seguro> listSegurosF = pd.admSegurosF();
		for (Conta conta : listContasF) {
	%>
	<form action="sistema?logica=DeletarServico" method="post">
		<h5>
			Tipo:
			<%
			if (conta.getTipo() == 1) {
					out.println("Conta Corrente");
					ContaCorrente cc = new ContaCorrente(conta.getNumero());
					cc.setId(conta.getId());
					cc.setSaldo(conta.getSaldo());
					cc.setSituacao(conta.isSituacao());
					cc.setTipo(conta.getTipo());
					conta = cc;
				} else if (conta.getTipo() == 2) {
					out.println("Conta Poupanca");
					ContaPoupanca cp = new ContaPoupanca(conta.getNumero());
					cp.setId(conta.getId());
					cp.setSaldo(conta.getSaldo());
					cp.setSituacao(conta.isSituacao());
					cp.setTipo(conta.getTipo());
					conta = cp;
				}
		%>
		</h5>
		<h5>
			Numero:
			<%=conta.getNumero()%></h5>
		<h5>
			Saldo: R$
			<%=conta.getSaldo()%></h5>
		<h5>
			Imposto: R$
			<%=r.calcularImposto(conta)%></h5>
		<h5>
			Situacao:<%
			if (conta.isSituacao()) {
					out.println("Ativo");
				} else {
					out.println("Desativada");
				}
		%>
		</h5>
		<input type=hidden name="id" value="<%=conta.getId()%>">
		<input type=hidden name="tipo" value="f">
		<input type="submit" value="Deletar">
		<br>
		--------------------------
		<br>
	</form>
	<%
		}
	%>
	<h4>-----Seguros-----</h4>
	<%
		for (Seguro s : listSegurosF) {
	%>
	<form action="sistema?logica=DeletarServico" method="post">
		<h5>Tipo: Seguro</h5>
		<h5>
			Numero:
			<%=s.getNumero()%></h5>
		<h5>
			Valor: R$
			<%=s.getValor()%></h5>
		<h5>
			Imposto: R$
			<%=r.calcularImposto(s)%></h5>
		<h5>
			Situacao:<%
			if (s.isSituacao()) {
					out.println("Ativo");
				} else {
					out.println("Desativada");
				}
		%>
		</h5>
		<input type=hidden name="id" value="<%=s.getId()%>">
		<input type=hidden name="tipo" value="f">
		<input type="submit" value="Deletar">
		<br>
		--------------------------
		<br>
	</form>
	<%
		}
	%>

	<h3>=====Pessoa Juridica=====</h3>
	<br>
	<h4>------Contas-----</h4>
	<%
		List<Conta> listContasJ = pd.admContasJ();
		List<Seguro> listSegurosJ = pd.admSegurosJ();
		for (Conta conta : listContasJ) {
	%>
	<form action="sistema?logica=DeletarServico" method="post">
		<h5>
			Tipo:
			<%
			if (conta.getTipo() == 1) {
					out.println("Conta Corrente");
					conta = (ContaCorrente) conta;
				} else if (conta.getTipo() == 2) {
					out.println("Conta Poupanca");
					conta = (ContaPoupanca) conta;
				}
		%>
		</h5>
		<h5>
			Numero:
			<%=conta.getNumero()%></h5>
		<h5>
			Saldo: R$
			<%=conta.getSaldo()%></h5>
		<h5>
			Imposto: R$
			<%=r.calcularImposto(conta)%></h5>
		<h5>
			Situacao:<%
			if (conta.isSituacao()) {
					out.println("Ativo");
				} else {
					out.println("Desativada");
				}
		%>
		</h5>
		<input type=hidden name="id" value="<%=conta.getId()%>">
		<input type=hidden name="tipo" value="j">
		<input type="submit" value="Deletar">
		<br>
		--------------------------
		<br>
	</form>
	<%
		}
	%>
	<h4>------Seguros-----</h4>
	<%
		for (Seguro s : listSegurosJ) {
	%>
	<form action="sistema?logica=DeletarServico" method="post">
		<h5>Tipo: Seguro</h5>
		<h5>
			Numero:
			<%=s.getNumero()%></h5>
		<h5>
			Valor: R$
			<%=s.getValor()%></h5>
		<h5>
			Imposto: R$
			<%=r.calcularImposto(s)%></h5>
		<h5>
			Situacao:<%
			if (s.isSituacao()) {
					out.println("Ativo");
				} else {
					out.println("Desativada");
				}
		%>
		</h5>
		<input type=hidden name="id" value="<%=s.getId()%>">
		<input type=hidden name="tipo" value="j">
		<input type="submit" value="Deletar">
		<br>
		--------------------------
		<br>
	</form>
	<%
	} %>
</body>
</html>