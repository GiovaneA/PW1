package com.giovanealvares.projeto1pwi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.giovanealvares.projeto1pwi.conexao.Conexao;
import com.giovanealvares.projeto1pwi.model.Cliente;
import com.giovanealvares.projeto1pwi.model.PessoaFisica;
import com.giovanealvares.projeto1pwi.model.PessoaJuridica;
import com.mysql.jdbc.PreparedStatement;


public class ClienteDAO {

	private static final Cliente Cliente = null;
	private Connection conexao;
	private PreparedStatement stmt;

	public ClienteDAO() {
		this.conexao = new Conexao().getConexao();
	}

	public void inserirPF(PessoaFisica cliente) {
		String sql = "INSERT INTO PessoaFisica(nome, endereco, telefone, cpf, nomePai, nomeMae) values(?,?,?,?,?,?)";
		try {
			stmt = (PreparedStatement) conexao.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEndereco());
			stmt.setString(3, cliente.getTelefone());
			stmt.setString(4, cliente.getCpf());
			stmt.setString(5, cliente.getNomePai());
			stmt.setString(6, cliente.getNomeMae());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
			
		}
	} 
	
	public void inserirPJ(PessoaJuridica cliente) {
		String sql = "INSERT INTO PessoaJuridica (nome, endereco, telefone, cnpj, nomeFantasia) values (?,?,?,?,?)";
		try {
			stmt = (PreparedStatement) conexao.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEndereco());
			stmt.setString(3, cliente.getTelefone());
			stmt.setString(4, cliente.getCnpj());
			stmt.setString(5, cliente.getNomeFantasia());
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
	
	public PessoaFisica logar(String nomeMae, String cpf) {
		String sql = "SELECT * FROM pessoafisica pf WHERE pf.nomeMae = ? AND pf.cpf = ?";
		try {
			stmt = (PreparedStatement) conexao.prepareStatement(sql);
			stmt.setString(1, nomeMae);
			stmt.setString(2, cpf);
			ResultSet rs = stmt.executeQuery();
			PessoaFisica pf = null;
			if (rs.next()) {
				pf = new PessoaFisica(rs.getString("nome"), rs.getString("endereco"), rs.getString("telefone") , rs.getString("cpf") );
				pf.setNomeMae(rs.getString("nomeMae"));
				pf.setNomePai(rs.getString("nomePai"));
				pf.setId(rs.getInt("idClienteF"));
			}
			return pf;
		}catch(Exception e) {
			throw new RuntimeException (e);
				}
	}
}