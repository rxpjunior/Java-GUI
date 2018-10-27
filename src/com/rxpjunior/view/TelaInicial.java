package com.rxpjunior.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.rxpjunior.model.Contato;

public class TelaInicial {

	Contato contatos[] = new Contato[5];
	int cont = 0;

	private JFrame frmTelaPrincipal;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextArea textArea;
	private JButton btnMostrarTodos;
	private JTextField txtTelefone;
	private JLabel lblId;
	private JLabel lblNasc;
	private JTextField txtDataNasc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial window = new TelaInicial();
					window.frmTelaPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaInicial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaPrincipal = new JFrame();
		frmTelaPrincipal.setTitle("Tela Principal");
		frmTelaPrincipal.setBounds(100, 100, 564, 417);
		frmTelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaPrincipal.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setBounds(47, 11, 31, 14);
		frmTelaPrincipal.getContentPane().add(lblNewLabel);

		JLabel lblTelefone = new JLabel("Email");
		lblTelefone.setBounds(35, 66, 43, 14);
		frmTelaPrincipal.getContentPane().add(lblTelefone);

		JLabel lblEmail = new JLabel("Nome");
		lblEmail.setBounds(32, 38, 46, 14);
		frmTelaPrincipal.getContentPane().add(lblEmail);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(88, 11, 145, 20);
		frmTelaPrincipal.getContentPane().add(txtId);
		txtId.setColumns(10);

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(88, 39, 145, 20);
		frmTelaPrincipal.getContentPane().add(txtNome);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(88, 66, 145, 20);
		frmTelaPrincipal.getContentPane().add(txtEmail);

		//Botão Salvar
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Um contato é instanciado e os valores dos textBox são inseridos nele
				String contS = Integer.toString(cont);
				txtId.setText(contS);
				Contato contato = new Contato(Integer.parseInt(txtId.getText()),txtNome.getText(),txtEmail.getText(),txtTelefone.getText(),txtDataNasc.getText());
				JOptionPane.showMessageDialog(null, contato.toString() + "\n Salvo com sucesso");
				//O contato é inserido em um vetor e os textBox são limpos
				contatos[cont] = contato;
				cont++;
				txtNome.setText("");
				txtId.setText("");
				txtEmail.setText("");
				txtDataNasc.setText("");
				txtTelefone.setText("");
				if(cont==5){
					btnSalvar.setEnabled(false);
				}
			}
		});
		btnSalvar.setBounds(251, 60, 89, 23);
		frmTelaPrincipal.getContentPane().add(btnSalvar);
		
		textArea = new JTextArea();
		textArea.setBounds(32, 240, 482, 93);
		frmTelaPrincipal.getContentPane().add(textArea);
		textArea.setEditable(false); //Para que o textArea fique desabilitado para edição
		
		//Botão mostrar todos
		btnMostrarTodos = new JButton("Mostrar todos");
		btnMostrarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Loop para salvar os contatos do vetor no textArea
				int cont1;
				for(cont1=0;cont1<cont;cont1++){
					textArea.insert(contatos[cont1].toString()+"\n",textArea.getCaretPosition());
				}
			}
		});
		btnMostrarTodos.setBounds(168, 344, 106, 23);
		frmTelaPrincipal.getContentPane().add(btnMostrarTodos);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(88, 91, 145, 20);
		frmTelaPrincipal.getContentPane().add(txtTelefone);
		
		lblId = new JLabel("Telefone");
		lblId.setBounds(20, 91, 58, 14);
		frmTelaPrincipal.getContentPane().add(lblId);
		
		lblNasc = new JLabel("Nasc");
		lblNasc.setBounds(35, 119, 43, 14);
		frmTelaPrincipal.getContentPane().add(lblNasc);
		
		txtDataNasc = new JTextField();
		txtDataNasc.setColumns(10);
		txtDataNasc.setBounds(88, 119, 145, 20);
		frmTelaPrincipal.getContentPane().add(txtDataNasc);

	}
}
