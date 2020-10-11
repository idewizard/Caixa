package br.com.nubank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnTransformer;



@Entity
@Table(name="cliente")
public class Cliente extends Pessoa{

	public Cliente(String nome, String cpf, int i) {
		super(nome, cpf);		
		this.senha = i;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="numeroconta",updatable = false, nullable = false)
	private int numeroConta = 0;
	
	@Column(name="senha")
	@ColumnTransformer(
			read = "aes_decrypt(lastName, 'chaveSegurancaSenha')",
			write = "aes_encrypt(?,'chaveSegurancaSenha')"
	)
	private int senha;
	
	public int getNumeroConta() {
		return numeroConta;
	}
	
	//todo criar metodo para validar senhar
	
	protected void setSenha(short senha) {
		this.senha = senha;
	}
	
	

}
