package com.giovanealvares.projeto1pwi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.giovanealvares.projeto1pwi.conexao.Conexao;
import com.giovanealvares.projeto1pwi.model.Cliente;
import com.giovanealvares.projeto1pwi.model.Conta;
import com.giovanealvares.projeto1pwi.model.ContaPoupanca;
import com.giovanealvares.projeto1pwi.model.PessoaFisica;
import com.giovanealvares.projeto1pwi.model.Produto;;

public class ProdutoDAO {
	
	private static final Cliente Cliente = null;
	private Connection conexao;
	private PreparedStatement stmt;

	public ProdutoDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	public boolean listarNumerosPF(String random){
		String sql = "SELECT numero FROM servicof";
		try {
			stmt = (PreparedStatement) conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				if(random.equals(rs.getString("numero"))) {
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
	
	public Conta buscarConta(int id){
		String sql = "SELECT * FROM servicof WHERE idServico = ?";
		try {
			stmt = (PreparedStatement) conexao.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Conta conta = new Conta(rs.getString("numero"));
				conta.setId(rs.getInt("idServico"));
				conta.setSaldo(rs.getDouble("saldo"));
				conta.setSituacao(true);
				conta.setTipo(rs.getInt("idTipoServico"));
				stmt.close();
				return conta;
			}
			stmt.close();
			return null;
	
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void criarContaPoupancaF(ContaPoupanca cp, int pf) {
		
		String sql = "INSERT INTO servicof (idCliente, numero, saldo, situacao, idTipoServico) VALUES (?,?,?,?,?)";
		try {
			stmt = (PreparedStatement) conexao.prepareStatement(sql);
			stmt.setInt(1,pf);
			stmt.setString(2, cp.getNumero());
			stmt.setDouble(3, cp.getSaldo());
			stmt.setBoolean(4, cp.isSituacao());
			stmt.setInt(5, cp.getTipo());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public void sacar(int conta, double valor) {
		
		String sql = "UPDATE servicof SET saldo = ? WHERE idServico = ?";
		Conta c = this.buscarConta(conta);
		try {
			stmt = (PreparedStatement) conexao.prepareStatement(sql);
			stmt.setDouble(1,(c.getSaldo()-valor));
			stmt.setInt(2, conta);
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public void depositar(int conta, double valor) {
		
		String sql = "UPDATE servicof SET saldo = ? WHERE idServico = ?";
		Conta c = this.buscarConta(conta);
		try {
			stmt = (PreparedStatement) conexao.prepareStatement(sql);
			stmt.setDouble(1,(c.getSaldo()+valor));
			stmt.setInt(2, conta);
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	public void ativar(int conta) {

		String sql = "UPDATE servicof SET situacao = ? WHERE idServico = ?";
		Conta c = this.buscarConta(conta);
		try {
			stmt = (PreparedStatement) conexao.prepareStatement(sql);
			stmt.setBoolean(1, true);
			stmt.setInt(2, conta);
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public void desativar(int conta) {

		String sql = "UPDATE servicof SET situacao = ? WHERE idServico = ?";
		Conta c = this.buscarConta(conta);
		try {
			stmt = (PreparedStatement) conexao.prepareStatement(sql);
			stmt.setBoolean(1, false);
			stmt.setInt(2, conta);
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Conta> listarProdutos(int id){
		String sql = "SELECT * FROM servicof sf WHERE sf.idCliente = ?";
		try {
			stmt = (PreparedStatement) conexao.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Conta> lista = new ArrayList<Conta>();
			while (rs.next()) {
				Conta conta = new Conta(rs.getString("numero"));
				conta.setSaldo(rs.getDouble("saldo"));
				conta.setSituacao(rs.getBoolean("situacao"));
				conta.setTipo(rs.getInt("idTipoServico"));
				conta.setId(rs.getInt("idServico"));
				lista.add(conta);
			}
			stmt.close();
			return lista;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
	