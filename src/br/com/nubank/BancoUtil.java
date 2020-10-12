package br.com.nubank;

import javax.swing.JOptionPane;

import com.sun.istack.Nullable;

import br.com.db.ClienteTemporario;
import br.com.db.HibernateUtil;

public class BancoUtil {
	
	private HibernateUtil hibernateUtil;
	private Cliente cliente;
	private ClienteTemporario clienteTemporario;
	
	public void efetuaAcao(double valor, ClienteTemporario cliente, String acao,Integer... contaDestino) {
		
		hibernateUtil = new HibernateUtil();	
		clienteTemporario =  hibernateUtil.loginCheck(cliente.getNumeroConta(),
				Integer.parseInt(JOptionPane.showInputDialog("Digite sua senha!")));
		
		
		if(!(clienteTemporario == null)) {
			final int numeroConta = cliente.getNumeroConta();
			this.cliente = (Cliente) hibernateUtil.recoverFromDB(Cliente.class, numeroConta);
			
			switch (acao) {
			case "SACAR": {
				saque(valor);
				break;
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
	}
	
	private void saque(double valor) {
		
		if(this.cliente.getSaldo() >= valor) {
			this.cliente.setSaldo(this.cliente.getSaldo() - valor);
			hibernateUtil.saveToDB(this.cliente);
		}else {
			JOptionPane.showMessageDialog(null, "Você não possui saldo suficiente");
		}
		
	}
	
	private void transfere() {}
	
	private void deposita() {}

}
