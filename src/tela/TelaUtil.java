package tela;

import javax.swing.JFrame;

import br.com.db.HibernateUtil;

public class TelaUtil {
	
	private boolean validLogin = false;
	
	public boolean checaLogin(int numeroConta, int senha, JFrame frame) {
		HibernateUtil hb = new HibernateUtil();
		
		validLogin = hb.loginCheck(numeroConta, senha);
		
		if (validLogin) {
			System.out.println("abrindo tela de usuaripo");
			frame.dispose();
		}
		
		return validLogin;
		
	}
	
}
