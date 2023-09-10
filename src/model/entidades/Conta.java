package model.entidades;

import model.excecoes.MyException;

public class Conta {
	
	private Integer numero;
	private String titular;
	private Double saldo;
	private Double limiteSaque;

	public Conta(Integer numero, String titular, Double saldo, Double limiteSaque) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
		this.limiteSaque = limiteSaque;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}

	public Double getLimiteSaque() {
		return limiteSaque;
	}

	public void saque(Double valor) {
		this.saldo-=valor;
	}
	
	public void validarSaque(Double valor) {
		if(valor>limiteSaque ) {
			throw new MyException("Erro de saque: A quantia excede o limite de saque");
		}
		if(valor>saldo) {
			throw new MyException("Erro de saque: Saldo insuficiente");
		}
	}
}
