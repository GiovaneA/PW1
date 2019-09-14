package com.giovanealvares.projeto1pwi.model;

public class Seguro implements Produto {

	private int numero;
	private double valor;
	private boolean situacao;
	
	@Override
	public double valorImposto() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return null;
	}

	public Seguro(int numero, double valor) {
		this.numero = numero;
		this.valor = valor;
	}
	
	

}
