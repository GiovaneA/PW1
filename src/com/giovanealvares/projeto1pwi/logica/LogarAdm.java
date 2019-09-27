package com.giovanealvares.projeto1pwi.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogarAdm implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String senha = req.getParameter("senha");
		
		if(id.equals("admin") && senha.equals("admin")) {
			return "/relatorio.jsp";
		}else {
			return "/erroLogar.jsp";
		}
		
	}

}
