package com.giovanealvares.projeto1pwi.model;

public class ContaCorrente extends Conta {	 
	
	public ContaCorrente(int numero) {
		super(numero);
	}


	
	@Override
	public boolean sacar(double valor) {return false;}
	
	public double valorImporto() {return 0;}

}
