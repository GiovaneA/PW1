package com.giovanealvares.projeto1pwi.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.giovanealvares.projeto1pwi.dao.ClienteDAO;
import com.giovanealvares.projeto1pwi.model.PessoaJuridica;

public class LogarPessoaJuridica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nomeFantasia = req.getParameter("nomeFantasia");
		String cnpj = req.getParameter("cnpj");
		ClienteDAO clienteDAO = new ClienteDAO();
		PessoaJuridica pj = clienteDAO.logarF(nomeFantasia, cnpj);
		String t = "j";
		
		
		req.setAttribute("clienteLogado", pj);
		req.setAttribute("tipo", t);
		return "/paginaCliente.jsp";
	}

}
