package com.giovanealvares.projeto1pwi.model;

public class Seguro implements Produto {
	
	private int id;
	private String numero;
	private double valor;
	private boolean situacao;
	int tipo;
	
	
	
	@Override
	public double valorImposto() {
		double imposto = 50 + 0.03*this.valor;
		return imposto;
	}

	@Override
	public int getTipo() {
		return 3;
	}

	public Seguro(String numero, double valor) {
		this.numero = numero;
		this.valor = valor;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public boolean isSituacao() {
		return situacao;
	}

	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	

}
