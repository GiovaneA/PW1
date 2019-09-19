package com.giovanealvares.projeto1pwi.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.giovanealvares.projeto1pwi.model.Cliente;
import com.giovanealvares.projeto1pwi.model.PessoaFisica;
import com.giovanealvares.projeto1pwi.dao.ClienteDAO;

public class CadastrarClienteF implements Logica {
	

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String endereco = req.getParameter("endereco");
		String telefone = req.getParameter("telefone");
		String cpf = req.getParameter("cpf");
		String nomePai = req.getParameter("nomePai");
		String nomeMae = req.getParameter("nomeMae");
		
		PessoaFisica p1 = new PessoaFisica (nome, endereco, telefone, cpf);
		p1.setNomeMae(nomeMae);
		p1.setNomePai(nomePai);
		new ClienteDAO().inserirPF(p1);
		
		return "sucessoPF.jsp";
	}
}

