package com.giovanealvares.projeto1pwi.model;

public class ContaCorrente extends Conta {	 
	
	public ContaCorrente(String numero) {
		super(numero);
	}


	
	@Override
	public boolean sacar(double valor) {
		if(super.sacar(valor + valor*0.01)) {
			
			return true;
		}else {
			return false;
		}
		}
	
	public double valorImporto() {
		return 0.05*this.getSaldo();
	}

}
