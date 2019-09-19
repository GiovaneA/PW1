package com.giovanealvares.projeto1pwi.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.giovanealvares.projeto1pwi.model.Cliente;
import com.giovanealvares.projeto1pwi.dao.ClienteDAO;
import com.giovanealvares.projeto1pwi.model.PessoaFisica;
import com.giovanealvares.projeto1pwi.model.PessoaJuridica;

public class CadastrarCliente implements Logica {
	

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String endereco = req.getParameter("endereco");
		String telefone = Integer.parseInt(req.getParameter("telefone"));
		String cpf = Integer.parseInt(req.getParameter("cpf"));
		String nomePai = req.getParameter("nomePai");
		String nomeMae = req.getParameter("nomeMae");
		
		PessoaFisica p1 = new PessoaFisica (nome, endereco, telefone, cpf);
		new ClienteDAO().inserir(Cliente);
		
		return "sucessoPF.jsp";
	}
}
