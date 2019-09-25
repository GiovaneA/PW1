package com.giovanealvares.projeto1pwi.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.giovanealvares.projeto1pwi.dao.ProdutoDAO;
import com.giovanealvares.projeto1pwi.model.ContaPoupanca;
import com.giovanealvares.projeto1pwi.model.PessoaFisica;

public class CriarContaPoupanca implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int valor = Integer.parseInt(req.getParameter("valor"));
		int idCliente = Integer.parseInt(req.getParameter("idCliente"));
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		String random = Integer.toString(1234567+(int)(8765433*Math.random()));
		while(produtoDAO.listarNumerosPF(random)){
		random = Integer.toString(1234567+(int)(8765433*Math.random()));
	}
		ContaPoupanca cp = new ContaPoupanca(random);
		cp.setSaldo(valor);;
		cp.setSituacao(true);
		cp.setTipo(2);
		produtoDAO.criarContaPoupancaF(cp, idCliente);
		return "/PaginaInicial.jsp";
	}

}
