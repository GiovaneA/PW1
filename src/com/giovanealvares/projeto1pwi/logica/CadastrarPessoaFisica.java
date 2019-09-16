package com.giovanealvares.projeto1pwi.logica;

import java.io.IOException;
import com.giovanealvares.projeto1pwi.model.PessoaFisica;

public class CadastrarPessoaFisica {
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String telefone = Integer.parseInt(request.getParameter("telefone"));
		String cpf = Integer.parseInt(request.getParameter("cpf"));
		String nomePai = request.getParameter("nomePai");
		String nomeMae = request.getParameter("nomeMae");
		
		PessoaFisica p1 = new PessoaFisica (nome, endereco, telefone, cpf);
		//new PessoaFisicaDao().inserir(PessoaFisica);
		
		return "sucessoPF.jsp";
	}
}
