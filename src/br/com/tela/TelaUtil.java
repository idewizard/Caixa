package br.com.tela;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.com.db.ClienteTemporario;
import br.com.db.HibernateUtil;

public class TelaUtil {
	
	private boolean validLogin = false;
	private HibernateUtil hb;
	
	//passa login e senha e a janela 
	public void checaLogin(int numeroConta, int senha, JFrame frame) {		
		hb = new HibernateUtil();		
			
		//passa senha e numero da conta para checar, caso confirmado
		//retorna um objeto com os dados necessarios
		ClienteTemporario clienteTemporario = hb.loginCheck(numeroConta, senha);
		
		if (!(clienteTemporario == null)) {
			JOptionPane.showMessageDialog(null, "Bem Vindo!");
			frame.dispose();
			TelaPrincipal telaPrincipal = new TelaPrincipal(clienteTemporario.getSaldo(),
					clienteTemporario.getNumeroConta(),
					clienteTemporario.getNome());
			telaPrincipal.IniciaTela(telaPrincipal);			
		}else {
			hb.closeConections();
			JOptionPane.showMessageDialog(null, "Login ou senha incorretos");
		}
		
	}
	
}
