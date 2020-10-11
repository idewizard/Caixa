package br.com.nubank;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="pessoa")
public abstract class Pessoa {

	@Column(name="nome")
	private String nome;
	
	@Column(name="cpf")
	private String cpf;
	
	
	@OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL)
	@JoinColumn(name = "cpf", referencedColumnName = "cpf_cliente")
	private Cliente cliente;
	
	
	
	private void checaCPF(String cpf) {
		//TODO validar cpf
	}
	
	public Pessoa(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
}
