package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Toolkit;

public class LoginAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField textUsuario;
	private JPasswordField pwSenha;
	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	JLabel LabelStatus = new JLabel("Status");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginAdmin frame = new LoginAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void logar() {
		String sql = "select *  from administrador where login=? and senha=?";
		try {
			//preparação a consulta ao que foi digitado nos texts
			//? é substituido pelo conteudo das variaveis
			pst = conexao.prepareStatement(sql);
			pst.setString(1, textUsuario.getText());
			String captura = new String(pwSenha.getPassword());
			pst.setString(2, captura);
			//Começa a execução da Query
			rs = pst.executeQuery();
			
			//se existir no BD usuario e senha corresponde
			
			if(rs.next()) {
				TelaAdministrativa telaAdm = new TelaAdministrativa();
				telaAdm.setVisible(true);
				telaAdm.lblAdm.setText(rs.getString(2));
				this.dispose();
				
			}else {
				JOptionPane.showMessageDialog(null, "Ops, Usuario e/ou Senha inválido");
			}
			
			
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	
	
	
	
	
	
	
	
	
	public LoginAdmin() {
		setTitle("LOGIN ADMINISTRADOR");
		conexao = model.Conexao.conector();
		//abaixo serve de apoio ao status da conexao
		//System.out.println(conexao);
		
		
		if(conexao != null) {
			LabelStatus.setText("Conectado");
		}else {
			LabelStatus.setText("Desconectado");
		}
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Desktop\\Programa5.0\\LOGO.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 0, 204));
		panel.setBounds(0, 0, 404, 454);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Downloads\\user (3).png"));
		lblNewLabel.setBounds(162, 106, 80, 122);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Bem-vindo(a)");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(133, 220, 137, 31);
		panel.add(lblNewLabel_1);
		
		
		LabelStatus.setForeground(Color.WHITE);
		LabelStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		LabelStatus.setBounds(10, 400, 144, 31);
		panel.add(LabelStatus);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(404, 0, 359, 515);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Login");
		lblNewLabel_1_1.setForeground(Color.GRAY);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1_1.setBounds(149, 10, 88, 48);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Usuario");
		lblNewLabel_1_1_1.setForeground(Color.GRAY);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1_1_1.setBounds(31, 116, 88, 48);
		panel_1.add(lblNewLabel_1_1_1);
		
		textUsuario = new JTextField();
		textUsuario.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textUsuario.setBounds(31, 174, 310, 36);
		panel_1.add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Senha");
		lblNewLabel_1_1_1_1.setForeground(Color.GRAY);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1_1_1_1.setBounds(31, 220, 88, 48);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		pwSenha = new JPasswordField();
		pwSenha.setFont(new Font("Tahoma", Font.PLAIN, 19));
		pwSenha.setBounds(31, 278, 310, 36);
		panel_1.add(pwSenha);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logar();
			}
		});
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(109, 342, 163, 42);
		panel_1.add(btnNewButton);
	}
}
