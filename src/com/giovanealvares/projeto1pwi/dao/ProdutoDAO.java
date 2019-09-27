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
import com.giovanealvares.projeto1pwi.model.Produto;
import com.giovanealvares.projeto1pwi.model.Seguro;;

public class ProdutoDAO {
	
	private static final Cliente Cliente = null;
	private Connection conexao;
	private PreparedStatement stmt;

	public ProdutoDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	public void deletarServicoF(int id) {
		String sql = "DELETE FROM servicof WHERE idServico = ?";
		try {
			stmt = (PreparedStatement) conexao.prepareStatement(sql);
			stmt.setInt(1,id);
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public void deletarServicoJ(int id) {
		String sql = "DELETE FROM servicoj WHERE idServico = ?";
		try {
			stmt = (PreparedStatement) conexao.prepareStatement(sql);
			stmt.setInt(1,id);
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
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
	
	public void criarSeguro(Seguro s, int pf) {
		
		String sql = "INSERT INTO servicof (idCliente, numero, saldo, situacao, idTipoServico) VALUES (?,?,?,?,?)";
		try {
			stmt = (PreparedStatement) conexao.prepareStatement(sql);
			stmt.setInt(1,pf);
			stmt.setString(2, s.getNumero());
			stmt.setDouble(3, s.getValor());
			stmt.setBoolean(4, s.isSituacao());
			stmt.setInt(5, s.getTipo());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public void criarContaPoupancaF(Conta cp, int pf) {
		
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
	
	public List<Conta> listarProdutosJ(int id){
		String sql = "SELECT * FROM servicoj sf WHERE sf.idCliente = ?";
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
	
	public List<Seguro> listarSeguros(int id){
		String sql = "SELECT * FROM servicof sf WHERE sf.idCliente = ? and sf.idTipoServico = 3";
		try {
			stmt = (PreparedStatement) conexao.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Seguro> lista = new ArrayList<Seguro>();
			while (rs.next()) {
				Seguro s = new Seguro(rs.getString("numero"),rs.getDouble("saldo"));
				s.setSituacao(rs.getBoolean("situacao"));
				s.setTipo(rs.getInt("idTipoServico"));
				s.setId(rs.getInt("idServico"));
				lista.add(s);
			}
			stmt.close();
			return lista;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Seguro> listarSegurosJ(int id){
		String sql = "SELECT * FROM servicoj sf WHERE sf.idCliente = ? and sf.idTipoServico = 3";
		try {
			stmt = (PreparedStatement) conexao.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Seguro> lista = new ArrayList<Seguro>();
			while (rs.next()) {
				Seguro s = new Seguro(rs.getString("numero"),rs.getDouble("saldo"));
				s.setSituacao(rs.getBoolean("situacao"));
				s.setTipo(rs.getInt("idTipoServico"));
				s.setId(rs.getInt("idServico"));
				lista.add(s);
			}
			stmt.close();
			return lista;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
		public Conta buscarContaJ(int id){
		String sql = "SELECT * FROM servicoj WHERE idServico = ?";
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
	
	public void criarSeguroJ(Seguro sj, int pj) {
		String sql = "INSERT INTO servicoj (idCliente, numero, saldo, situacao, idTipoServico) VALUES (?,?,?,?,?)";
		try {
			stmt = (PreparedStatement) conexao.prepareStatement(sql);
			stmt.setInt(1,pj);
			stmt.setString(2, sj.getNumero());
			stmt.setDouble(3, sj.getValor());
			stmt.setBoolean(4, sj.isSituacao());
			stmt.setInt(5, sj.getTipo());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public void criarContaPoupancaJ(Conta cp, int pj) {
		
		String sql = "INSERT INTO servicoj (idCliente, numero, saldo, situacao, idTipoServico) VALUES (?,?,?,?,?)";
		try {
			stmt = (PreparedStatement) conexao.prepareStatement(sql);
			stmt.setInt(1,pj);
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
	
	public void sacarJ(int conta, double valor) {
		
		String sql = "UPDATE servicoj SET saldo = ? WHERE idServico = ?";
		Conta c = this.buscarContaJ(conta);
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
	
	public void depositarJ(int conta, double valor) {
		
		String sql = "UPDATE servicoj SET saldo = ? WHERE idServico = ?";
		Conta c = this.buscarContaJ(conta);
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

	public void ativarJ(int conta) {

		String sql = "UPDATE servicoj SET situacao = ? WHERE idServico = ?";
		Conta c = this.buscarContaJ(conta);
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

	public void desativarJ(int conta) {


		String sql = "UPDATE servicoj SET situacao = ? WHERE idServico = ?";
		Conta c = this.buscarContaJ(conta);
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
	

	public List<Conta> admContasF(){
		String sql = "SELECT * FROM servicof sf WHERE sf.idTipoServico <> 3";
		try {
			stmt = (PreparedStatement) conexao.prepareStatement(sql);
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
	
	public List<Conta> admContasJ(){
		String sql = "SELECT * FROM servicoj sf WHERE sf.idTipoServico <> 3";
		try {
			stmt = (PreparedStatement) conexao.prepareStatement(sql);
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

	public List<Seguro> admSegurosJ(){
		String sql = "SELECT * FROM servicoj sf WHERE sf.idTipoServico = 3";
		try {
			stmt = (PreparedStatement) conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Seguro> lista = new ArrayList<Seguro>();
			while (rs.next()) {
				Seguro s = new Seguro(rs.getString("numero"),rs.getDouble("saldo"));
				s.setSituacao(rs.getBoolean("situacao"));
				s.setTipo(rs.getInt("idTipoServico"));
				s.setId(rs.getInt("idServico"));
				lista.add(s);
			}
			stmt.close();
			return lista;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public List<Seguro> admSegurosF(){
		String sql = "SELECT * FROM servicof sf WHERE  sf.idTipoServico = 3";
		try {
			stmt = (PreparedStatement) conexao.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			ArrayList<Seguro> lista = new ArrayList<Seguro>();
			while (rs.next()) {
				Seguro s = new Seguro(rs.getString("numero"),rs.getDouble("saldo"));
				s.setSituacao(rs.getBoolean("situacao"));
				s.setTipo(rs.getInt("idTipoServico"));
				s.setId(rs.getInt("idServico"));
				lista.add(s);
			}
			stmt.close();
			return lista;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
			
	public boolean listarNumerosPJ(String random){
		String sql = "SELECT numero FROM servicoj";
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
}
	
