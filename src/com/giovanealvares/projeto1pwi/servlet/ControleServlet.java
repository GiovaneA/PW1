/*package com.giovanealvares.projeto1pwi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Sistema")
public class ControleServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String parametro = req.getParameter("logica");
		String nomeClasse = //inserir logica aqui + parametro;

		try {
			Class<?> classe = Class.forName(nomeClasse);
			Logica logica = (Logica) classe.getDeclaredConstructor().newInstance();
			
			String pagina = logica.executa(req, resp);
			
			req.getRequestDispatcher(pagina).forward(req, resp);

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
*/