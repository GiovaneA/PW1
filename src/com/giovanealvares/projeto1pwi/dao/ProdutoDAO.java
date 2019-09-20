package com.giovanealvares.projeto1pwi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.giovanealvares.projeto1pwi.conexao.Conexao;
import com.giovanealvares.projeto1pwi.model.Cliente;;

public class ProdutoDAO {
	
	private static final Cliente Cliente = null;
	private Connection conexao;
	private PreparedStatement stmt;

	public ProdutoDAO() {
		this.conexao = new Conexao().getConexao();
	}
}
	