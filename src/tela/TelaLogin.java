package tela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaLogin {

	private JFrame frmNubranco;
	private JTextField numeroContaTextField;
	private JPasswordField senhaField;
	private TelaUtil telaUtil;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin window = new TelaLogin();
					window.frmNubranco.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaLogin() {
		
		telaUtil = new TelaUtil();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNubranco = new JFrame();
		frmNubranco.setTitle("Banco n\u00E3o o de sentar o que de dinheiro e pa");
		frmNubranco.setResizable(false);
		frmNubranco.setBounds(100, 100, 185,195);
		frmNubranco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNubranco.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 170, 160);
		frmNubranco.getContentPane().add(panel);
		panel.setLayout(null);
		
		numeroContaTextField = new JTextField();
		numeroContaTextField.setBounds(10, 36, 149, 20);
		panel.add(numeroContaTextField);
		numeroContaTextField.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				telaUtil.checaLogin(
						Integer.parseInt(numeroContaTextField.getText()), 
						Integer.parseInt(String.valueOf(senhaField.getPassword())));
				
			}
		});
		btnNewButton.setBounds(10, 123, 149, 23);
		panel.add(btnNewButton);
		
		senhaField = new JPasswordField();
		senhaField.setBounds(10, 92, 149, 20);
		panel.add(senhaField);
		
		JLabel lblNewLabel = new JLabel("Numero da Conta");
		lblNewLabel.setBounds(10, 11, 149, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setBounds(10, 67, 149, 14);
		panel.add(lblNewLabel_1);
	}
}
