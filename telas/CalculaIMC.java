package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.TelaUsuario;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenu;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class CalculaIMC extends JFrame {

	private JPanel contentPane;
	private JTextField textPeso;
	private JTextField textAltura;
	private JTextField textImc;
	private JTextField textSituacao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculaIMC frame = new CalculaIMC();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void calcularIMC() {

		if ((textPeso.getText().isEmpty()) || (textAltura.getText().isEmpty())) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos");
		} else {

			Float peso = Float.parseFloat(textPeso.getText());
			Float altura = Float.parseFloat(textAltura.getText());

			Float imc = peso / (altura * altura);

			textImc.setText(String.format("%.2f", imc));

			if (imc < 18.5) {
				textSituacao.setText(("Abaixo do peso"));
			} else if (imc >= 18.5 && imc <= 24.9) {
				textSituacao.setText(("Peso Normal"));
			}
			if (imc >= 25 && imc <= 29.9) {
				textSituacao.setText(("Sobrepeso"));
			} else if (imc >= 30 && imc <= 34.9) {
				textSituacao.setText(("Obesidade Grau I"));
			}
			if (imc >= 35 && imc <= 39.9) {
				textSituacao.setText(("Obesidade Grau II"));
			} else if (imc >= 40) {
				textSituacao.setText(("Obesidade Grau III (Mórbida)"));
			}

		}
	}

	public void limpar() {

		if ((textPeso.getText().isEmpty()) || (textAltura.getText().isEmpty())) {
			JOptionPane.showMessageDialog(null, "Insira algo antes de limpar");
		} else {

			textSituacao.setText("");
			textImc.setText("");
			textPeso.setText("");
			textAltura.setText("");
		}
	}

	public CalculaIMC() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Desktop\\Programa5.0\\LOGO.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 756, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 0, 204));
		panel.setBounds(0, 28, 347, 472);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Calculo de IMC");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(104, 32, 138, 28);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(10, 116, 138, 309);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(
				"C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Desktop\\Programa2.0\\imagem-projeto-2.0\\calculadoraIMC\\picwish.png"));

		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(
				"C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Desktop\\Programa2.0\\imagem-projeto-2.0\\calculadoraIMC\\picwish (1).png"));
		lblNewLabel_1_1.setBounds(10, 88, 340, 309);
		panel.add(lblNewLabel_1_1);

		JLabel lblDigiteSeuPeso = new JLabel("Digite seu peso:");
		lblDigiteSeuPeso.setForeground(Color.DARK_GRAY);
		lblDigiteSeuPeso.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDigiteSeuPeso.setBounds(357, 60, 138, 28);
		contentPane.add(lblDigiteSeuPeso);

		textPeso = new JTextField();
		textPeso.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textPeso.setBounds(357, 103, 284, 28);
		contentPane.add(textPeso);
		textPeso.setColumns(10);

		JLabel lblDigiteSuaAltura = new JLabel("Digite sua Altura:");
		lblDigiteSuaAltura.setForeground(Color.DARK_GRAY);
		lblDigiteSuaAltura.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDigiteSuaAltura.setBounds(357, 159, 152, 28);
		contentPane.add(lblDigiteSuaAltura);

		textAltura = new JTextField();
		textAltura.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textAltura.setColumns(10);
		textAltura.setBounds(357, 202, 284, 28);
		contentPane.add(textAltura);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(346, 0, 396, 500);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setBounds(140, 252, 93, 28);
		panel_1.add(lblResultado);
		lblResultado.setForeground(Color.DARK_GRAY);
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 19));

		textImc = new JTextField();
		textImc.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textImc.setBounds(66, 322, 117, 28);
		panel_1.add(textImc);
		textImc.setColumns(10);

		JLabel lblImc = new JLabel("IMC:");
		lblImc.setForeground(Color.DARK_GRAY);
		lblImc.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblImc.setBounds(10, 317, 93, 28);
		panel_1.add(lblImc);

		JLabel lblSituao = new JLabel("Situação");
		lblSituao.setForeground(Color.DARK_GRAY);
		lblSituao.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblSituao.setBounds(10, 381, 93, 28);
		panel_1.add(lblSituao);

		textSituacao = new JTextField();
		textSituacao.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textSituacao.setColumns(10);
		textSituacao.setBounds(91, 381, 186, 28);
		panel_1.add(textSituacao);

		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularIMC();
			}
		});

		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.WHITE);
		menuBar.setBackground(Color.DARK_GRAY);
		menuBar.setBounds(0, 0, 347, 29);
		contentPane.add(menuBar);

		JMenu menMenu = new JMenu("Menu");
		menMenu.setForeground(Color.WHITE);
		menMenu.setIcon(new ImageIcon("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Downloads\\mais.png"));
		menuBar.add(menMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Voltar");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaUsuario tuser = new TelaUsuario();
				tuser.show();
				dispose();
				
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(
				"C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Desktop\\Programa2.0\\imagem-projeto-2.0\\calculadoraIMC\\de-volta.png"));
		menMenu.add(mntmNewMenuItem);

		JMenuItem menVoltar = new JMenuItem("Voltar");
		menVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaUsuario tpp = new TelaUsuario();
				tpp.show();
				dispose();
			}
		});

		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton.setBounds(257, 457, 117, 33);
		panel_1.add(btnNewButton);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnLimpar.setBackground(Color.BLUE);
		btnLimpar.setBounds(109, 457, 117, 33);
		panel_1.add(btnLimpar);
	}
}
