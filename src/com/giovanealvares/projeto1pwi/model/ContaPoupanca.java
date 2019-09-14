package com.giovanealvares.projeto1pwi.model;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(int numero) {
		super(numero);
	}
	
	public double valorImposto() {
		return 0.01*this.getSaldo();
	}
	
}
