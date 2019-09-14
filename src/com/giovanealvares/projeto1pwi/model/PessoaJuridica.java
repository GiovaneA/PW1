package com.giovanealvares.projeto1pwi.model;

public class PessoaJuridica extends Cliente {
	
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

}