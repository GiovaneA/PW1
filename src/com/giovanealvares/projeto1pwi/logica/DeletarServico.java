package com.giovanealvares.projeto1pwi.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.giovanealvares.projeto1pwi.dao.ProdutoDAO;

public class DeletarServico implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String tipo = req.getParameter("tipo");
		ProdutoDAO pd = new ProdutoDAO();
		if(tipo.equals("f")) {
		pd.deletarServicoF(id);
		}else if(tipo.equals("j")) {
			pd.deletarServicoJ(id);
		}
		return "/sucessoDelet.jsp";
	}

}
