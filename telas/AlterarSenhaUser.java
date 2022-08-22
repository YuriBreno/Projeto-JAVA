package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AlterarSenhaUser extends JFrame {

	private JPanel contentPane;
	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	JLabel LabelStatus = new JLabel("Status");
	private JTextField textNome;
	private JTextField textUsuario;
	private JPasswordField pwSenha;
	private JPasswordField confirmapass;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarSenhaUser frame = new AlterarSenhaUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public void Alterar() {
		String sql = "update usuario set senha=? where nome_usuario=?";
		
		try {
			pst = conexao.prepareStatement(sql);
			String captura = new String(pwSenha.getPassword());
			pst.setString(1, captura);
			pst.setString(2, textUsuario.getText());
			
			
			if (((textUsuario.getText().isEmpty())||((captura.isEmpty())))) {
				JOptionPane.showMessageDialog(null, "PREENCHA TODOS OS CAMPOS ANTES DE ALTERAR");
			} else {

			
			
			
			
			//Começa a execução da Query
			int adicionado = pst.executeUpdate();
			if (adicionado >0) {
				
				if(new String(confirmapass.getPassword()).equals(new String(pwSenha.getPassword()))) {
					CadastraUseer cad = new CadastraUseer();
				    JOptionPane.showMessageDialog(null, "Senha alterada com sucesso");

					int logar = JOptionPane.showConfirmDialog(cad,"Deseja Logar?","Atenção",JOptionPane.YES_NO_OPTION);
					if(logar == JOptionPane.YES_OPTION) {
					LoginUseer l = new LoginUseer();
					l.show();
					dispose();
					}
				} else {
				    JOptionPane.showMessageDialog(null, "Senhas não conferem!");
				}
				
				
				
				
			} else {
				JOptionPane.showMessageDialog(null, "Usuario não encontrado");
			}
			}
			
			
		
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	public AlterarSenhaUser() {
		setTitle("CADASTRO USUARIO");
		conexao = model.Conexao.conector();
		if(conexao != null) {
			LabelStatus.setText("Conectado");
		}else {
			LabelStatus.setText("Desconectado");
		}

		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Desktop\\Programa5.0\\LOGO.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 897, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 0, 204));
		panel.setBounds(0, 0, 345, 436);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Downloads\\user (3).png"));
		lblNewLabel.setBounds(132, 106, 80, 122);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Bem-vindo(a)");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(104, 220, 137, 31);
		panel.add(lblNewLabel_1);
		
		LabelStatus.setForeground(Color.WHITE);
		LabelStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		LabelStatus.setBounds(20, 385, 137, 31);
		panel.add(LabelStatus);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(345, 0, 538, 446);
		contentPane.add(panel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Alterar Senha");
		lblNewLabel_1_1.setForeground(Color.GRAY);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1_1.setBounds(172, 10, 194, 48);
		panel_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Nome de Usuario");
		lblNewLabel_1_1_1_1.setForeground(Color.GRAY);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1_1_1_1.setBounds(31, 154, 147, 48);
		panel_1.add(lblNewLabel_1_1_1_1);

		JButton btnNewButton = new JButton("Alterar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Alterar();
			}
		});
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(350, 377, 163, 42);
		panel_1.add(btnNewButton);

		JLabel lblNewLabel_1_1_1_2 = new JLabel("Senha");
		lblNewLabel_1_1_1_2.setForeground(Color.GRAY);
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1_1_1_2.setBounds(30, 219, 88, 48);
		panel_1.add(lblNewLabel_1_1_1_2);

		JLabel lblNewLabel_1_1_1_2_2 = new JLabel("Confirme a senha");
		lblNewLabel_1_1_1_2_2.setForeground(Color.GRAY);
		lblNewLabel_1_1_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1_1_1_2_2.setBounds(31, 277, 150, 48);
		panel_1.add(lblNewLabel_1_1_1_2_2);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(204, 166, 309, 34);
		panel_1.add(textUsuario);
		textUsuario.setColumns(10);
		
		pwSenha = new JPasswordField();
		pwSenha.setBounds(204, 231, 309, 34);
		panel_1.add(pwSenha);
		
		confirmapass = new JPasswordField();
		confirmapass.setBounds(204, 289, 309, 34);
		panel_1.add(confirmapass);
	}
	}


