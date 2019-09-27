package com.giovanealvares.projeto1pwi.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.giovanealvares.projeto1pwi.dao.ClienteDAO;
import com.giovanealvares.projeto1pwi.model.PessoaFisica;

public class LogarPessoaFisica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nomeMae = req.getParameter("nomeMae");
		String cpf = req.getParameter("cpf");
		ClienteDAO clienteDAO = new ClienteDAO();
		PessoaFisica pf = clienteDAO.logar(nomeMae, cpf);
		
		req.setAttribute("clienteLogado", pf);
		req.setAttribute("tipo", "f");
		return "/paginaCliente.jsp";
	}

}
