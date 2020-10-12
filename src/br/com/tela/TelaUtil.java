package br.com.tela;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


import br.com.db.ClienteTemporario;
import br.com.db.HibernateUtil;
import br.com.nubank.BancoUtil;

public class TelaUtil {
	
	private HibernateUtil hb;
	private TelaPrincipal telaPrincipal;
	private TelaHibrida telaHibrida;
	private TelaUtil telaUtil;

	
	public TelaUtil() {
		// TODO Auto-generated constructor stub
	}

	//passa login e senha e a janela 
	public void checaLogin(int numeroConta, int senha, JFrame frame, TelaUtil telaUtil) {	
		
		hb = new HibernateUtil();		
		this.telaUtil = telaUtil;
			
		//passa senha e numero da conta para checar, caso confirmado
		//retorna um objeto com os dados necessarios
		ClienteTemporario clienteTemporario = hb.loginCheck(numeroConta, senha);
		
		if (!(clienteTemporario == null)) {
			JOptionPane.showMessageDialog(null, "Bem Vindo!");
			frame.dispose();
			this.telaPrincipal = new TelaPrincipal(clienteTemporario, this.telaUtil);
			this.telaPrincipal.iniciaTela(telaPrincipal);			
		}else {
			hb.closeConections();
			JOptionPane.showMessageDialog(null, "Login ou senha incorretos");
		}
		
	}
	
	public void constroiTelaHibrida(String acao, ClienteTemporario clienteTemporario) {
		
		this.telaHibrida = new TelaHibrida(acao.toUpperCase(),clienteTemporario,this.telaUtil);
		this.telaHibrida.iniciaTela(telaHibrida);		
		
	}
	
	protected void efetuaAcaoHibrida(double valor, ClienteTemporario cliente, String acao, Integer... contaDestino) {
		
		final BancoUtil bancoUtil = new BancoUtil();
		ClienteTemporario clienteTemporario = bancoUtil.efetuaAcao(valor, cliente, acao, contaDestino);
		if(!(clienteTemporario== null)) {
			System.out.println(clienteTemporario.getSaldo()+"");
			this.telaPrincipal.showTela(clienteTemporario);
			this.telaHibrida.hideTela();
		}
		
		
	}

	
}
