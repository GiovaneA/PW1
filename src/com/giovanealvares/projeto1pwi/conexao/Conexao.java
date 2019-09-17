package com.giovanealvares.projeto1pwi.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	private static final String DSN = "jdbc:mysql://localhost/..."; // faltao nome do banco
	private static final String USUARIO = ""; //falta usuario
	private static final String SENHA = ""; //falta senha

	public Connection getConexao() {
		try {

			Class.forName("com.mysql.jdbc.Driver"); 
			return DriverManager.getConnection(DSN, USUARIO, SENHA);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}


