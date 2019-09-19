package com.giovanealvares.projeto1pwi.logica;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.giovanealvares.projeto1pwi.model.Cliente;
import com.giovanealvares.projeto1pwi.model.PessoaFisica;
import com.giovanealvares.projeto1pwi.dao.ClienteDAO;

public class ListarClientes implements Logica {
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Cliente> lista = new ClienteDAO().listarTudo();
		
		req.setAttribute("lista", lista);
		return "listaClientes.jsp";// criar para listar todos os clientes
	}
}