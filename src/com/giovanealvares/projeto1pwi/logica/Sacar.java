package com.giovanealvares.projeto1pwi.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.giovanealvares.projeto1pwi.dao.ProdutoDAO;

public class Sacar implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Conta conta = (Conta) req.getAttribute("conta");
		int idConta = Integer.parseInt(req.getParameter("id"));
		double valor = Double.parseDouble(req.getParameter("valor"));
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.sacar(idConta, valor);
		return "PaginaInicial.jsp";
	}

}
