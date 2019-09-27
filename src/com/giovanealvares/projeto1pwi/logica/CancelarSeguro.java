package com.giovanealvares.projeto1pwi.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.giovanealvares.projeto1pwi.dao.ClienteDAO;
import com.giovanealvares.projeto1pwi.dao.ProdutoDAO;

public class CancelarSeguro implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("idSeguro"));
		int idCliente = Integer.parseInt(req.getParameter("id"));
		String  t = req.getParameter("tipo");
		ProdutoDAO pd = new ProdutoDAO();
		ClienteDAO cd = new ClienteDAO();
		
		
		
		if (t.equals("j")) {
			pd.desativarSeguroJ(id);
			req.setAttribute("clienteLogado", cd.buscarJ(idCliente));
			req.setAttribute("tipo", t);
		}else {
			pd.desativarSeguroF(id);
			req.setAttribute("clienteLogado", cd.buscarF(idCliente));
			req.setAttribute("tipo", t);
		}
		return "paginaCliente.jsp";
	}

}
