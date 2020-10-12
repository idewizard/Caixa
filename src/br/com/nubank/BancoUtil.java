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
	
	public boolean efetuaAcao(double valor, ClienteTemporario cliente, String acao,Integer... contaDestino) {
		
		hibernateUtil = new HibernateUtil();	
		clienteTemporario =  hibernateUtil.loginCheck(cliente.getNumeroConta(),
				Integer.parseInt(JOptionPane.showInputDialog("Digite sua senha!")));
		
		
		if(!(clienteTemporario == null)) {
			final int numeroConta = cliente.getNumeroConta();
			this.cliente = (Cliente) hibernateUtil.recoverFromDB(Cliente.class, numeroConta);
			
			switch (acao) {
			case "SACAR": {
				return saque(valor);				
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
		
		return false;
	}
	
	private boolean saque(double valor) {
		
		if(this.cliente.getSaldo() >= valor) {
			this.cliente.setSaldo(this.cliente.getSaldo() - valor);
			hibernateUtil.saveToDB(this.cliente);
			return true;
		}else {
			JOptionPane.showMessageDialog(null, "Você não possui saldo suficiente");
			return false;
		}
		
	}
	
	private void transfere() {}
	
	private void deposita() {}

}
