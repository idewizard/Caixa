package br.com.nubank;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnTransformer;



@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="cliente")
public class Cliente extends Pessoa implements Serializable{
	
	public Cliente() {}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2130451720454395156L;
	
	public Cliente(String nome, String cpf, int senha) {
		super(nome, cpf);
		this.senha = senha;
	}

	@Id
	@Column(name="numero_conta")
	private int numeroConta;
	
	@Column(name="senha")
	@ColumnTransformer(
			read = "aes_decrypt(senha, 'chaveSegurancaSenha')",
			write = "aes_encrypt(?,'chaveSegurancaSenha')"
	)
	private int senha;
		
	public int getNumeroConta() {
		return numeroConta;
	}
	
	//todo criar metodo para validar senhar
	
	protected void setSenha(int senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Cliente [numeroConta = " + numeroConta + ", senha = " + senha + ", Nome = " + getNome() + ", Cpf = "
				+ getCpf() + "]";
	}
	
	

}
