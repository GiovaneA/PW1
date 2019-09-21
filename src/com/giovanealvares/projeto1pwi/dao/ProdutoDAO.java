package com.giovanealvares.projeto1pwi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.giovanealvares.projeto1pwi.conexao.Conexao;
import com.giovanealvares.projeto1pwi.model.Cliente;
import com.giovanealvares.projeto1pwi.model.ContaPoupanca;
import com.giovanealvares.projeto1pwi.model.PessoaFisica;;

public class ProdutoDAO {
	
	private static final Cliente Cliente = null;
	private Connection conexao;
	private PreparedStatement stmt;

	public ProdutoDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	public boolean listarNumerosCPF(int random){
		String sql = "SELECT numero FROM servicof";
		try {
			stmt = (PreparedStatement) conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Integer> lista = new ArrayList<Integer>();
			while (rs.next()) {
				if(random == rs.getInt("numero")) {
					stmt.close();
					return true;
				}
					
			}
			stmt.close();
			return false;
	
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void criarContaPoupancaF(ContaPoupanca cp, PessoaFisica pf) {
		
		String sql = "INSERT INTO servicof (idCliente, numero, saldo, situacao, idTipoServico) VALUES (?,?,?,?,?)";
		try {
			stmt = (PreparedStatement) conexao.prepareStatement(sql);
			stmt.setInt(1,pf.getId());
			stmt.setString(2, (String) cp.getNumero());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
}
	