package com.giovanealvares.projeto1pwi.model;

public class Seguro implements Produto {

	private int numero;
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

	public Seguro(int numero, double valor) {
		this.numero = numero;
		this.valor = valor;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
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
	
	

}
