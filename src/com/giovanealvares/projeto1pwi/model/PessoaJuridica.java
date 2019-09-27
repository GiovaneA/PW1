package com.giovanealvares.projeto1pwi.model;

public class PessoaJuridica extends Cliente {
	
	private int id;
	private String cnpj;
	private String nomeFantasia;

	public PessoaJuridica(String nome, String endereco, String telefone, String cnpj, String nomeFantasia) {
		super(nome, endereco, telefone);
		this.cnpj = cnpj;
		this.nomeFantasia = nomeFantasia;
		this.setEndereco(endereco);
		this.setNome(nome);
		this.setTelefone(telefone);
		
	}
	
	public PessoaJuridica() {
		
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}


	

	
}
