package br.com.nubank;

public class Cliente extends Pessoa{

	public Cliente(String nome, String cpf, int i) {
		super(nome, cpf);		
		this.senha = i;
	}
	
	private int numeroConta;
	private int senha;
	
	public int getNumeroConta() {
		return numeroConta;
	}
	
	//todo criar metodo para validar senhar
	
	public void setSenha(short senha) {
		this.senha = senha;
	}
	
	

}
