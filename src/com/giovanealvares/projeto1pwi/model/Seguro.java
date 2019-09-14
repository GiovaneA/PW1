package com.giovanealvares.projeto1pwi.model;

public class Seguro implements Produto {

	private int numero;
	private double valor;
	private boolean situacao;
	
	@Override
	public double valorImposto() {
		double imposto = 50 + 0.03*this.valor;
		return imposto;
	}

	@Override
	public String getTipo() {
		return "Seguro";
	}

	public Seguro(int numero, double valor) {
		this.numero = numero;
		this.valor = valor;
	}
	
	

}
