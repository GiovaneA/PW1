package com.giovanealvares.projeto1pwi.model;

public class PessoaFisica extends Cliente {

	private String cpf;
	private String nomeMae;
	private String nomePai;
	
	
	public PessoaFisica(String nome, String endereco, String telefone, String cpf) {
		super(nome, endereco, telefone);
		this.cpf = cpf;
		this.setEndereco(endereco);
		this.setNome(nome);
		this.setTelefone(telefone);
		
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getNomeMae() {
		return nomeMae;
	}


	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}


	public String getNomePai() {
		return nomePai;
	}


	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}
	
	 
	
}
