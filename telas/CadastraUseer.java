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

public class CadastraUseer extends JFrame {

	private JPanel contentPane;
	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JTextField textNome;
	private JTextField textUser;
	private JTextField textEmail;
	private JPasswordField textpass;
	private JPasswordField confirmapass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastraUseer frame = new CadastraUseer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void inserir() {
		String sql = "insert into usuario(nome,nome_usuario,senha,email) values (?,?,?,?)";
		try {

			// preparação a consulta ao que foi digitado nos texts
			// ? é substituido pelo conteudo das variaveis
			pst = conexao.prepareStatement(sql);
			pst.setString(1, textNome.getText());
			pst.setString(2, textUser.getText());
			String captura = new String(textpass.getPassword());
			pst.setString(3, captura);
			pst.setString(4, textEmail.getText());

			if ((textNome.getText().isEmpty()) || (textUser.getText().isEmpty()) || (captura.isEmpty())
					|| (textEmail.getText().isEmpty())) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos");
			} else {

				// Começa a execução da Query
				int adicionado = pst.executeUpdate();
				if (adicionado > 0) {

					if (new String(confirmapass.getPassword()).equals(new String(textpass.getPassword()))) {
						CadastraUseer cad = new CadastraUseer();

						JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso");

						textNome.setText(null);
						textUser.setText(null);
						textpass.setText(null);
						textEmail.setText(null);
						int logar = JOptionPane.showConfirmDialog(cad, "Deseja Logar?", "Atenção",
								JOptionPane.YES_NO_OPTION);
						if (logar == JOptionPane.YES_OPTION) {
							LoginUseer l = new LoginUseer();
							l.show();
							dispose();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Senhas não conferem!");
					}

				}
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public CadastraUseer() {
		setTitle("CADASTRO USUARIO");
		conexao = model.Conexao.conector();

		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Desktop\\Programa5.0\\LOGO.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 997, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 0, 204));
		panel.setBounds(0, 0, 345, 506);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Downloads\\user (3).png"));
		lblNewLabel.setBounds(132, 102, 80, 122);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Bem-vindo(a)");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(104, 220, 137, 31);
		panel.add(lblNewLabel_1);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(345, 0, 638, 506);
		contentPane.add(panel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Cadastro");
		lblNewLabel_1_1.setForeground(Color.GRAY);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1_1.setBounds(294, 10, 163, 48);
		panel_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Nome");
		lblNewLabel_1_1_1.setForeground(Color.GRAY);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1_1_1.setBounds(31, 112, 88, 48);
		panel_1.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Nome de Usuario");
		lblNewLabel_1_1_1_1.setForeground(Color.GRAY);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1_1_1_1.setBounds(31, 186, 147, 48);
		panel_1.add(lblNewLabel_1_1_1_1);

		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inserir();
			}
		});
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(317, 454, 163, 42);
		panel_1.add(btnNewButton);

		JLabel lblNewLabel_1_1_1_2 = new JLabel("Senha");
		lblNewLabel_1_1_1_2.setForeground(Color.GRAY);
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1_1_1_2.setBounds(31, 247, 88, 48);
		panel_1.add(lblNewLabel_1_1_1_2);

		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Email");
		lblNewLabel_1_1_1_2_1.setForeground(Color.GRAY);
		lblNewLabel_1_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1_1_1_2_1.setBounds(31, 357, 88, 48);
		panel_1.add(lblNewLabel_1_1_1_2_1);

		JLabel lblNewLabel_1_1_1_2_2 = new JLabel("Confirme a senha");
		lblNewLabel_1_1_1_2_2.setForeground(Color.GRAY);
		lblNewLabel_1_1_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1_1_1_2_2.setBounds(31, 305, 150, 48);
		panel_1.add(lblNewLabel_1_1_1_2_2);

		textNome = new JTextField();
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textNome.setBounds(209, 123, 358, 36);
		panel_1.add(textNome);
		textNome.setColumns(10);

		textUser = new JTextField();
		textUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textUser.setColumns(10);
		textUser.setBounds(209, 197, 358, 36);
		panel_1.add(textUser);

		textEmail = new JTextField();
		textEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textEmail.setColumns(10);
		textEmail.setBounds(209, 368, 358, 36);
		panel_1.add(textEmail);

		textpass = new JPasswordField();
		textpass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textpass.setBounds(209, 258, 358, 36);
		panel_1.add(textpass);

		confirmapass = new JPasswordField();
		confirmapass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		confirmapass.setBounds(209, 316, 358, 36);
		panel_1.add(confirmapass);
	}
}
