package com.giovanealvares.projeto1pwi.model;

import java.util.List;

public abstract class Cliente {
	
	private String nome;
	private String endereco;
	private String telefone;
	private List<Produto> produtos;
	
	
	public Cliente(String nome, String endereco, String telefone) {
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	
	public void addCCorrente(String numero) {
		ContaCorrente contaCorrente = new ContaCorrente(numero);
		this.produtos.add(contaCorrente);
	}
	
	public void addCPoupanca(String numero) {
		ContaPoupanca contaPoupanca = new ContaPoupanca(numero);
		this.produtos.add(contaPoupanca);
	}
	
	public void addSeguro(String numero, double valor) {
		Seguro seguro = new Seguro(numero, valor);
		this.produtos.add(seguro);
	}
	
	public List<Produto> getServico(){
		return this.produtos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	} 
}
