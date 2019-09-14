package com.giovanealvares.projeto1pwi.model;

public class Conta implements Produto {
	
	private int numero;
	private double saldo;
	private boolean situacao;

	@Override
	public double valorImposto() {	
		return 0.5;
	}

	@Override
	public String getTipo() {
		String tipo = "Conta";
		return tipo;
	}
	
	public Conta(int numero) {
		this.numero = numero;
	}
	
	public boolean sacar(double valor) { return false;}
	
	public boolean depositar(double valor) {return false;}
	
	public void desativar() {}
	
	public void ativar() {}
	
	public boolean estaAtivada() {return false;}
	
	public double getSaldo() {return 0;}
	
	

}
