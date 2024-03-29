package br.com.tela;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.sun.istack.Nullable;

import br.com.db.ClienteTemporario;
import br.com.db.HibernateUtil;
import br.com.nubank.BancoUtil;
import net.bytebuddy.implementation.bind.annotation.Empty;

public class TelaUtil {
	
	private HibernateUtil hb;
	private TelaPrincipal telaPrincipal;
	private TelaHibrida telaHibrida;
	private TelaUtil telaUtil;
	private ClienteTemporario clienteTemporario;
	
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
			this.clienteTemporario = clienteTemporario;
			this.telaPrincipal = new TelaPrincipal(clienteTemporario, this.telaUtil);
			this.telaPrincipal.iniciaTela(telaPrincipal);			
		}else {
			hb.closeConections();
			JOptionPane.showMessageDialog(null, "Login ou senha incorretos");
		}
		
	}
	
	public void constroiTelaHibrida(String acao, ClienteTemporario clienteTemporario) {
		
		if (this.telaHibrida == null) {
			this.telaHibrida = new TelaHibrida(acao.toUpperCase(),clienteTemporario,this.telaUtil);
			this.telaHibrida.iniciaTela(telaHibrida);
		}else {
			this.telaHibrida.showTela(acao.toUpperCase(),this.clienteTemporario);
			this.telaPrincipal.hideTela();
		}
				
		
	}
	
	protected void efetuaAcaoHibrida(double valor, ClienteTemporario cliente, String acao, @Nullable int contaDestino) {
		
		final BancoUtil bancoUtil = new BancoUtil();
		ClienteTemporario clienteTemporario = bancoUtil.efetuaAcao(valor, cliente, acao, contaDestino);
		if(!(clienteTemporario== null)) {
			this.clienteTemporario = clienteTemporario;
			this.telaPrincipal.showTela(clienteTemporario);
			this.telaHibrida.hideTela();
		}
		
		
	}

	
}
