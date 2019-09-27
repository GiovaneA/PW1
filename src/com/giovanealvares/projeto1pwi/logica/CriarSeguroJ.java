package com.giovanealvares.projeto1pwi.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.giovanealvares.projeto1pwi.dao.ProdutoDAO;
import com.giovanealvares.projeto1pwi.model.ContaCorrente;
import com.giovanealvares.projeto1pwi.model.Seguro;

public class CriarSeguro implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int valor = Integer.parseInt(req.getParameter("valor"));
		int idCliente = Integer.parseInt(req.getParameter("idCliente"));
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		String random = Integer.toString(1234567+(int)(8765433*Math.random()));
		while(produtoDAO.listarNumerosPJ(random)){
		random = Integer.toString(1234567+(int)(8765433*Math.random()));
	}
		Seguro s = new Seguro(random, (double) valor);
		s.setSituacao(true);
		s.setTipo(3);
		produtoDAO.criarSeguroJ(sj, idCliente);
		return "/PaginaInicial.jsp";
	}

}