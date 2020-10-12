package br.com.tela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.SwingConstants;

import br.com.db.ClienteTemporario;
import br.com.db.HibernateUtil;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class TelaPrincipal {

	private static final String LBL_TRANSFERIR = "TRANSFERIR";
	private static final String LBL_DEPOSITAR = "DEPOSITAR";
	private static final String LBL_SACAR = "SACAR";
	private JFrame frame;
	private JLabel labelSaldo;
	private JLabel labelConta;
	private JLabel labelNomeCliente;
	private JLabel labelCifrao;
	private JLabel labelNumeroConta;
	private ClienteTemporario clienteTemporario;
	private TelaUtil telaUtil;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JPanel panel;
	
	
	/**
	 * Launch the application.
	 */
	public void iniciaTela(TelaPrincipal tela) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tela.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public TelaPrincipal(ClienteTemporario clienteTemporario) {
		this.telaUtil = new TelaUtil();
		this.clienteTemporario = clienteTemporario;
		initialize();			
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosed(WindowEvent e) {
				HibernateUtil hb = new HibernateUtil();
				hb.closeEverthing();
				super.windowClosed(e);
			}
			
		});
		
		panel = new JPanel();
		panel.setBounds(0, 0, 434, 170);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		labelSaldo = new JLabel(String.valueOf(clienteTemporario.getSaldo()));
		labelSaldo.setHorizontalAlignment(SwingConstants.RIGHT);
		labelSaldo.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelSaldo.setBounds(302, 11, 122, 14);
		panel.add(labelSaldo);
		
		labelConta = new JLabel("Conta:");
		labelConta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelConta.setBounds(10, 30, 46, 14);
		panel.add(labelConta);
		
		labelNomeCliente = new JLabel(clienteTemporario.getNome());
		labelNomeCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelNomeCliente.setBounds(10, 11, 288, 14);
		panel.add(labelNomeCliente);
		
		labelCifrao = new JLabel("R$");
		labelCifrao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelCifrao.setBounds(274, 11, 26, 14);
		panel.add(labelCifrao);
		
		labelNumeroConta = new JLabel(String.valueOf(clienteTemporario.getNumeroConta()));
		labelNumeroConta.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelNumeroConta.setBounds(54, 31, 46, 14);
		panel.add(labelNumeroConta);
		
		btnNewButton = new JButton(LBL_SACAR);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				telaUtil.constroiTelaHibrida(LBL_SACAR, clienteTemporario);

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(10, 56, 414, 23);
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton(LBL_DEPOSITAR);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				telaUtil.constroiTelaHibrida(LBL_DEPOSITAR, clienteTemporario);

			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(11, 90, 413, 23);
		panel.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton(LBL_TRANSFERIR);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				telaUtil.constroiTelaHibrida(LBL_TRANSFERIR, clienteTemporario);
	
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBounds(10, 124, 414, 23);
		panel.add(btnNewButton_2);
	}

	
}
