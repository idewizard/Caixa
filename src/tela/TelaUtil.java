package tela;

import br.com.db.HibernateUtil;

public class TelaUtil {
	
	private boolean validLogin = false;
	
	public boolean checaLogin(int numeroConta, int senha) {
		HibernateUtil hb = new HibernateUtil();
		
		validLogin = hb.loginCheck(numeroConta, senha);
		
		if (validLogin) System.out.println("abrindo tela de usuaripo");
		
		return validLogin;
		
	}
	
}
