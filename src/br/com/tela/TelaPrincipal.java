package br.com.tela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import br.com.db.HibernateUtil;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class TelaPrincipal {

	private JFrame frame;
	private JLabel labelSaldo;
	private JLabel labelConta;
	private JLabel labelNomeCliente;
	private JLabel labelCifrao;
	private JLabel labelNumeroConta;

	/**
	 * Launch the application.
	 */
	public void iniciaTela(TelaPrincipal tela) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//TelaPrincipal window = new TelaPrincipal(this.saldo, this.conta, this.nome);
					tela.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



	public TelaPrincipal(double labelSaldo, int labelConta, String labelNomeCliente) {
		
		initialize();		
		this.labelSaldo.setText(String.valueOf(labelSaldo));
		this.labelNumeroConta.setText(String.valueOf(labelConta));
		this.labelNomeCliente.setText(labelNomeCliente);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
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
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 170);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		labelSaldo = new JLabel("5,485.55");
		labelSaldo.setHorizontalAlignment(SwingConstants.RIGHT);
		labelSaldo.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelSaldo.setBounds(302, 11, 122, 14);
		panel.add(labelSaldo);
		
		labelConta = new JLabel("Conta:");
		labelConta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelConta.setBounds(10, 30, 46, 14);
		panel.add(labelConta);
		
		labelNomeCliente = new JLabel("Jos\u00E9 Francisco da Costa");
		labelNomeCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelNomeCliente.setBounds(10, 11, 288, 14);
		panel.add(labelNomeCliente);
		
		labelCifrao = new JLabel("R$");
		labelCifrao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelCifrao.setBounds(274, 11, 26, 14);
		panel.add(labelCifrao);
		
		labelNumeroConta = new JLabel("2154");
		labelNumeroConta.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelNumeroConta.setBounds(54, 31, 46, 14);
		panel.add(labelNumeroConta);
		
		JButton btnNewButton = new JButton("SACAR");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(10, 56, 414, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("DEPOSITAR");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(11, 90, 413, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("TRANSFERIR");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBounds(10, 124, 414, 23);
		panel.add(btnNewButton_2);
	}

}
