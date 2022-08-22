package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Suportee extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField textEmail;
	private JTextField textAssunto;
	private JPanel panel_2;
	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	JTextArea textProblemad = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Suportee frame = new Suportee();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void suportInsert() {
		String sql = "insert into suporte (nome, email, assunto, descricao_problema) values (?,?,?,?)";
		try {

			// preparação a consulta ao que foi digitado nos texts
			// ? é substituido pelo conteudo das variaveis
			pst = conexao.prepareStatement(sql);
			pst.setString(1, txtNome.getText());
			pst.setString(2, textEmail.getText());
			pst.setString(3, textAssunto.getText());
			pst.setString(4, textProblemad.getText());

			if ((txtNome.getText().isEmpty()) || (textEmail.getText().isEmpty()) || (textAssunto.getText().isEmpty())
					|| (textProblemad.getText().isEmpty())) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos");
			} else {

				// Começa a execução da Query
				int adicionado = pst.executeUpdate();
				if (adicionado > 0) {
					JOptionPane.showMessageDialog(null, "Sua mensagem foi enviada com sucesso\n retornaremos em breve");

					txtNome.setText(null);
					textEmail.setText(null);
					textAssunto.setText(null);
					textProblemad.setText(null);
				} else {

				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			;
		}

	}

	public Suportee() {
		setTitle("SUPORTE");

		conexao = model.Conexao.conector();

		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Desktop\\ProgramaJAVA\\imagens\\eclipse (1).png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 996, 728);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 0, 204));
		panel.setBounds(0, 0, 310, 691);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Downloads\\user (3).png"));
		lblNewLabel.setBounds(115, 89, 80, 122);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Bem-vindo(a)");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(86, 221, 137, 31);
		panel.add(lblNewLabel_1);

		panel_2 = new JPanel();
		panel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_2.setBounds(86, 288, 121, 36);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Voltar");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaUsuario tu = new TelaUsuario();
				tu.show();
				dispose();
			}
		});
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(34, 10, 60, 16);
		panel_2.add(lblNewLabel_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(309, 0, 681, 691);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("Formulario para Contato");
		lblNewLabel_1_1.setBounds(167, 10, 346, 48);
		lblNewLabel_1_1.setForeground(Color.GRAY);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Seu nome:");
		lblNewLabel_1_1_1.setBounds(10, 84, 153, 48);
		lblNewLabel_1_1_1.setForeground(Color.GRAY);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_1.add(lblNewLabel_1_1_1);

		txtNome = new JTextField();
		txtNome.setBounds(10, 142, 308, 48);
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Email para contato");
		lblNewLabel_1_1_1_1.setBounds(10, 188, 204, 48);
		lblNewLabel_1_1_1_1.setForeground(Color.GRAY);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_1.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Assunto");
		lblNewLabel_1_1_1_1_1.setBounds(385, 84, 95, 48);
		lblNewLabel_1_1_1_1_1.setForeground(Color.GRAY);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_1.add(lblNewLabel_1_1_1_1_1);

		textEmail = new JTextField();
		textEmail.setBounds(10, 241, 308, 48);
		textEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textEmail.setColumns(10);
		panel_1.add(textEmail);

		textAssunto = new JTextField();
		textAssunto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textAssunto.setColumns(10);
		textAssunto.setBounds(385, 142, 275, 48);
		panel_1.add(textAssunto);

		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Descrição do problema ou dúvida");
		lblNewLabel_1_1_1_2_1.setForeground(Color.GRAY);
		lblNewLabel_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1_1_1_2_1.setBounds(167, 299, 346, 23);
		panel_1.add(lblNewLabel_1_1_1_2_1);

		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suportInsert();
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(259, 645, 163, 36);
		panel_1.add(btnNewButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(51, 0, 204));
		panel_3.setBounds(20, 333, 640, 303);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		textProblemad.setBounds(10, 10, 620, 283);
		panel_3.add(textProblemad);
		textProblemad.setLineWrap(true);
		textProblemad.setCaretColor(Color.BLACK);
		textProblemad.setDisabledTextColor(Color.WHITE);
		textProblemad.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		
				textProblemad.setFont(new Font("Monospaced", Font.PLAIN, 19));
				textProblemad.setForeground(Color.BLACK);
				textProblemad.setBackground(Color.WHITE);
	}
}
