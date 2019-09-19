package com.giovanealvares.projeto1pwi.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.giovanealvares.projeto1pwi.dao.ClienteDAO;
import com.giovanealvares.projeto1pwi.model.PessoaFisica;
import com.giovanealvares.projeto1pwi.model.PessoaJuridica;

public class CadastrarClienteJ implements Logica {


	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String endereco = req.getParameter("endereco");
		String telefone = req.getParameter("telefone");
		String cnpj = req.getParameter("cnpj");
		String nomeFantasia = req.getParameter("nomeFantasia");
		
		PessoaJuridica p1 = new PessoaJuridica(nome, endereco, telefone, cnpj, nomeFantasia);

		new ClienteDAO().inserirPJ(p1);
		return "sucessoPF.jsp";
	}

}
