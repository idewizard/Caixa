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
	
	public ClienteTemporario efetuaAcao(double valor, ClienteTemporario cliente, String acao,Integer... contaDestino) {
		
		hibernateUtil = new HibernateUtil();	
		clienteTemporario =  hibernateUtil.loginCheck(cliente.getNumeroConta(),
				Integer.parseInt(JOptionPane.showInputDialog("Digite sua senha!")));
		
		
		if(!(clienteTemporario == null)) {
			final int numeroConta = cliente.getNumeroConta();
			this.cliente = (Cliente) hibernateUtil.recoverFromDB(Cliente.class, numeroConta);
			
			switch (acao) {
			case "SACAR": {
				if(!(saque(valor) == null))return this.clienteTemporario;				
			}
			case "DEPOSITAR": {
				
				break;
			}
			case "TRANSFERIR": {
				
				break;
			}
			default:
				throw new IllegalArgumentException("VISH DEU RUIM: " + acao);
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
	
	private void transfere() {}
	
	private void deposita() {}

}
