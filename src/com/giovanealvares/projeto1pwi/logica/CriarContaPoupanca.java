package com.giovanealvares.projeto1pwi.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.giovanealvares.projeto1pwi.dao.ProdutoDAO;
import com.giovanealvares.projeto1pwi.model.PessoaFisica;

public class CriarContaPoupanca implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int valor = Integer.parseInt(req.getParameter("valor"));
		PessoaFisica pf = (PessoaFisica) req.getAttribute("clienteLogado");
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		int random = 1234567+8765433*(int)Math.random();
		while(produtoDAO.listarNumerosCPF(random)){
		random = 1234567+8765433*(int)Math.random();
	}
		produtoDAO.
		return "/paginaCliente.jsp";
	}

}
