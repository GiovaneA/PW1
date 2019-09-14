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
		return "Conta";
	}
	
	public Conta(int numero) {
		this.numero = numero;
	}
	
	public boolean sacar(double valor) { 
		if(this.saldo>=valor) {
			this.saldo = this.saldo - valor;
			return true;
		}else {
			return false;
		}
		}
	
	public boolean depositar(double valor) {
		if(situacao) {
			this.saldo = this.saldo + valor;
			return true;
		}else {
			return false;
		}
		}
	
	public void desativar() {
		this.situacao = false;
	}
	
	public void ativar() {
		this.situacao = true;
	}
	
	public boolean estaAtivada() {
		return this.situacao;
		}
	
	public double getSaldo() {
		return this.saldo;
		}
	
	
	

}
