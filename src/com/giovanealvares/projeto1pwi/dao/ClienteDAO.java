package com.giovanealvares.projeto1pwi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.giovanealvares.projeto1pwi.conexao.Conexao;
import com.giovanealvares.projeto1pwi.model.Cliente;
import com.mysql.jdbc.PreparedStatement;


public class ClienteDAO {

	private static final Cliente Cliente = null;
	private Connection conexao;
	private PreparedStatement stmt;

	public ClienteDAO() {
		this.conexao = new Conexao().getConexao();
	}

	public void inserir(Cliente cliente) {
		String sql = "INSERT INT cliente (nome, endereco, telefone) values (?,?,?)";
		try {
			stmt = (PreparedStatement) conexao.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEndereco());
			stmt.setString(3, cliente.getTelefone());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	} 
	
	public void deletarCliente(String nome) {
		String sql = "DELETE FROM cliente WHERE nome = ?";
		try {
			stmt = (PreparedStatement) conexao.prepareStatement(sql);
			stmt.setString(1, nome);
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException (e);
		}
	}
	
	public List<Cliente> listarTudo(){
		String sql = "SELECT * FROM cliente";
		try {
			stmt = (PreparedStatement) conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			List<Cliente> lista = new ArrayList<Cliente>();
			lista.add(Cliente);
			stmt.close();
			return lista;
		}catch (Exception e) {
			throw new RuntimeException (e);
		}
	}
}