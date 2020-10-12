package tela;

import javax.swing.JFrame;

import br.com.db.HibernateUtil;

public class TelaUtil {
	
	private boolean validLogin = false;
	private HibernateUtil hb;
	
	//passa login e senha e a janela 
	public boolean checaLogin(int numeroConta, int senha, JFrame frame) {		
		hb = new HibernateUtil();		
		validLogin = hb.loginCheck(numeroConta, senha);		
		if (validLogin) {
			System.out.println("abrindo tela de usuario");
			frame.dispose();
		}		
		return validLogin;		
	}
	
}
