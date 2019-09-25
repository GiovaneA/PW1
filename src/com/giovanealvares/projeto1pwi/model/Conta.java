package com.giovanealvares.projeto1pwi.model;

public class Conta implements Produto {
	
	private int id;
	private String numero;
	private double saldo;
	private boolean situacao;
	int tipo;

	@Override
	public double valorImposto() {	
		return 0.5;
	}

	@Override
	public int getTipo() {
		return tipo;
	}
	
	public Conta(String numero) {
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


	public boolean isSituacao() {
		return situacao;
	}
	

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	

}
