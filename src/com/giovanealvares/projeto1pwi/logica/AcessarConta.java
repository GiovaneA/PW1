package com.giovanealvares.projeto1pwi.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.giovanealvares.projeto1pwi.dao.ProdutoDAO;
import com.giovanealvares.projeto1pwi.model.Conta;

public class AcessarConta implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idConta = Integer.parseInt(req.getParameter("servicos"));
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Conta conta = produtoDAO.buscarConta(idConta);
		req.setAttribute("conta", conta);
		
		
		return "/paginaConta.jsp";
	}

}
