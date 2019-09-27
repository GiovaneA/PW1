package com.giovanealvares.projeto1pwi.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.giovanealvares.projeto1pwi.dao.ProdutoDAO;

public class DesativarJ implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idConta = Integer.parseInt(req.getParameter("id"));
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.desativarJ(idConta);
		return "PaginaInicial.jsp";
	}

}
