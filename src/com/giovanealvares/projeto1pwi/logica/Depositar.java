package com.giovanealvares.projeto1pwi.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.giovanealvares.projeto1pwi.dao.ProdutoDAO;
import com.giovanealvares.projeto1pwi.model.Conta;

public class Depositar implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Conta conta = (Conta) req.getAttribute("conta");
		int idConta = Integer.parseInt(req.getParameter("id"));
		double valor = Double.parseDouble(req.getParameter("valor"));
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.depositar(idConta, valor);
		return "PaginaInicial.jsp";
	}

}
