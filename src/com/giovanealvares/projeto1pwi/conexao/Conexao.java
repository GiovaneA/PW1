package com.giovanealvares.projeto1pwi.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	private static final String DSN = "jdbc:mysql://localhost/..."; // faltao nome do banco
	private static final String USUARIO = ""; //falta usuario
	private static final String SENHA = ""; //falta senha

	public Connection getConexao() {
		try {
//			Pode ser assim (forma mais antiga, mas funcional)
//			Class.forName("com.mysql.jdbc.Driver"); 
			
//			Ou assim (forma mais atual)
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(DSN, USUARIO, SENHA);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}


