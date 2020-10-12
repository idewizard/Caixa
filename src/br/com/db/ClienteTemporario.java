package br.com.db;

public class ClienteTemporario {

	private String nome;
	private int numeroConta;
	private double saldo;
	
	
	public ClienteTemporario(String nome, int numeroConta, double saldo) {
		super();
		this.nome = nome;
		this.numeroConta = numeroConta;
		this.saldo = saldo;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
	
}
