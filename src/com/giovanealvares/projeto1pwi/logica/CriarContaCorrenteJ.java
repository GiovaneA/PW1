package com.giovanealvares.projeto1pwi.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.giovanealvares.projeto1pwi.dao.ProdutoDAO;
import com.giovanealvares.projeto1pwi.model.ContaCorrente;
import com.giovanealvares.projeto1pwi.model.ContaPoupanca;

public class CriarContaCorrente implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int valor = Integer.parseInt(req.getParameter("valor"));
		int idCliente = Integer.parseInt(req.getParameter("idCliente"));
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		String random = Integer.toString(1234567+(int)(8765433*Math.random()));
		while(produtoDAO.listarNumerosPJ(random)){
		random = Integer.toString(1234567+(int)(8765433*Math.random()));
	}
		ContaCorrente cc = new ContaCorrente(random);
		cc.setSaldo(valor);;
		cc.setSituacao(true);
		cc.setTipo(1);
		produtoDAO.criarContaPoupancaJ(cc, idCliente);
		return "/PaginaInicial.jsp";
	}

}