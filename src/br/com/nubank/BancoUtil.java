package br.com.nubank;

import javax.swing.JOptionPane;

import com.sun.istack.Nullable;

import br.com.db.ClienteTemporario;
import br.com.db.HibernateUtil;
import br.com.tela.TelaHibrida;

public class BancoUtil {
	
	private HibernateUtil hibernateUtil;
	private Cliente cliente;
	private ClienteTemporario clienteTemporario;
	
	public ClienteTemporario efetuaAcao(double valor, ClienteTemporario cliente, String acao,int contaDestino) {
		
		hibernateUtil = new HibernateUtil();	
		clienteTemporario =  hibernateUtil.loginCheck(cliente.getNumeroConta(),
				Integer.parseInt(JOptionPane.showInputDialog("Digite sua senha!")));
		
		
		if(!(clienteTemporario == null)) {
			final int numeroConta = cliente.getNumeroConta();
			this.cliente = (Cliente) hibernateUtil.recoverFromDB(Cliente.class, numeroConta);
			
			switch (acao) {
			case "SACAR": {
				if(!(saque(valor) == null))return this.clienteTemporario;
				break;
			}
			case "DEPOSITAR": {
				if(!(deposita(valor) == null))return this.clienteTemporario;	
				break;
			}
			case "TRANSFERIR": {
				if(!(transfere(valor, contaDestino) == null ))return this.clienteTemporario;
				break;
			}
			default:
				JOptionPane.showMessageDialog(null,"Algo deu errado :(");
				
				this.cliente = (Cliente) hibernateUtil.recoverFromDB(Cliente.class, cliente.getNumeroConta());
				this.clienteTemporario.setSaldo(this.cliente.getSaldo());
				this.clienteTemporario.setNome(this.cliente.getNome());
				this.clienteTemporario.setNumeroConta(this.cliente.getNumeroConta());
				
				return this.clienteTemporario;						
			}
			
		}else {
			JOptionPane.showMessageDialog(null, "CLIENTE NULO");
		}
		
		return null;
	}
	
	private ClienteTemporario saque(double valor) {
		
		if(this.cliente.getSaldo() >= valor) {
			this.cliente.setSaldo(this.cliente.getSaldo() - valor);
			hibernateUtil.saveToDB(this.cliente);		
			this.clienteTemporario.setSaldo(this.cliente.getSaldo());
			this.clienteTemporario.setNome(this.cliente.getNome());
			this.clienteTemporario.setNumeroConta(this.cliente.getNumeroConta());
			return this.clienteTemporario;
		}else {
			JOptionPane.showMessageDialog(null, "Você não possui saldo suficiente");
			return null;
		}
		
	}
	
	private ClienteTemporario transfere(double valor, int contaDestino) {
		
		if(this.cliente.getSaldo() >= valor) {
			
			//pega o primeiro cliente que esta no objeto cliente e efetua a subtracao do valor
			this.cliente.setSaldo(this.cliente.getSaldo() - valor);
			int contaOrigem = this.cliente.getNumeroConta();
			hibernateUtil.saveToDB(this.cliente);
			
			//apos salvar no banco (linha acima) ele busca um novo cliente usando a consta destino e
			//adiciona o valor
			this.cliente = (Cliente) hibernateUtil.recoverFromDB(Cliente.class, contaDestino);
			this.cliente.setSaldo(this.cliente.getSaldo() + valor);
			hibernateUtil.saveToDB(this.cliente);
			JOptionPane.showMessageDialog(null, "Valor de R$ " + valor +" Transferido para "
					+ "\n"+this.cliente.getNome());
			
			//novamente chama o cliente original e passa ele para um remporario para retornar
			this.cliente = (Cliente) hibernateUtil.recoverFromDB(Cliente.class, contaOrigem);
			this.clienteTemporario.setSaldo(this.cliente.getSaldo());
			this.clienteTemporario.setNome(this.cliente.getNome());
			this.clienteTemporario.setNumeroConta(this.cliente.getNumeroConta());
			
			return this.clienteTemporario;
		}else {
			JOptionPane.showMessageDialog(null, "Você não possui saldo suficiente");
			return null;
		}
		
	}
	
	private ClienteTemporario deposita(double valor) {
		
		this.cliente.setSaldo(this.cliente.getSaldo() + valor);
		hibernateUtil.saveToDB(this.cliente);		
		this.clienteTemporario.setSaldo(this.cliente.getSaldo());
		this.clienteTemporario.setNome(this.cliente.getNome());
		this.clienteTemporario.setNumeroConta(this.cliente.getNumeroConta());
		
		return this.clienteTemporario;
	}

}
