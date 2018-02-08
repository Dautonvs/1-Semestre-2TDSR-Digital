package br.com.fiap.bean;

import java.util.Calendar;

import br.com.fiap.exceptions.SaldoInsuficienteException;

public class ContaPoupanca extends Conta implements ContaInvestimento {

	private float taxa;
	
	public static final float RENDIMENTO = 2.4f;
	
	@Override
	public double calculaRetornoInvestimento() {
		return saldo*RENDIMENTO;
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}

	@Override
	public void retirar(double valor) throws SaldoInsuficienteException {
		if (saldo < valor) {
			throw new SaldoInsuficienteException("Saldo insuficiente");
		}
		saldo = saldo - valor - taxa;
	}
	
	public ContaPoupanca(int agencia, int numero, Calendar dataAbertura, double saldo, float taxa) {
		super(agencia, numero, dataAbertura, saldo);
		this.taxa = taxa;
	}

	public ContaPoupanca() {
		super();
	}

	public float getTaxa() {
		return taxa;
	}

	public void setTaxa(float taxa) {
		this.taxa = taxa;
	}

}
