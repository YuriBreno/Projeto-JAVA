package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Conexao;
import view.TelaAdministrativa.hora;

import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.ScrollPane;
import java.awt.Scrollbar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Panel;
import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaUsuario extends JFrame {

	private JPanel contentPane;
	JLabel lblData = new JLabel("Data");
	JLabel lblUsuario = new JLabel("Usuario");
	JLabel lblHora = new JLabel("");

	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUseer logUs = new LoginUseer();
					logUs.setVisible(true);
					TelaUsuario frame = new TelaUsuario();
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaUsuario() {
		setResizable(false);
		
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				Date data = new Date();
				DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
				lblData.setText(formatador.format(data));

				Timer timer = new Timer(1000, new hora());
				timer.start();
				
				
			}
		});
		setAlwaysOnTop(true);
		setBackground(Color.DARK_GRAY);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Desktop\\Programa5.0\\LOGO.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 892, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 738, 35);
		menuBar.setBackground(Color.WHITE);
		contentPane.add(menuBar);
		
		JMenu menCadastro = new JMenu("Programas");
		menCadastro.setIcon(new ImageIcon("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Downloads\\cadastro (3).png"));
		menCadastro.setForeground(Color.DARK_GRAY);
		menCadastro.setFont(new Font("Arial", Font.BOLD, 14));
		menuBar.add(menCadastro);
		
		
		JMenuItem menCadUser = new JMenuItem("Calcular IMC");
		menCadUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculaIMC imc = new CalculaIMC();
				imc.show();
				dispose();
				
				
				
				
			}
		});
		menCadUser.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_DOWN_MASK));
		menCadUser.setHorizontalAlignment(SwingConstants.LEFT);
		menCadUser.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menCadastro.add(menCadUser);
		
		JMenuItem mntmCalculadora = new JMenuItem("Calculadora");
		mntmCalculadora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calculadora c = new Calculadora();
				c.frmCalculator.show();
				dispose();
			}
		});
		mntmCalculadora.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
		mntmCalculadora.setHorizontalAlignment(SwingConstants.LEFT);
		mntmCalculadora.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menCadastro.add(mntmCalculadora);
		
		JMenuItem mntmTabuada = new JMenuItem("Tabuada");
		mntmTabuada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tabuada t = new Tabuada();
				t.show();
				dispose();
			}
		});
		mntmTabuada.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_DOWN_MASK));
		mntmTabuada.setHorizontalAlignment(SwingConstants.LEFT);
		mntmTabuada.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menCadastro.add(mntmTabuada);
		
		JMenuItem mntmCalcularIdade = new JMenuItem("Calcular idade");
		mntmCalcularIdade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculaIdade ci = new CalculaIdade();
				ci.show();
				dispose();
			}
		});
		mntmCalcularIdade.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK));
		mntmCalcularIdade.setHorizontalAlignment(SwingConstants.LEFT);
		mntmCalcularIdade.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menCadastro.add(mntmCalcularIdade);
		
		JMenu menAjuda = new JMenu("Ajuda");
		menAjuda.setIcon(new ImageIcon("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Downloads\\apoio-suporte.png"));
		menAjuda.setForeground(Color.DARK_GRAY);
		menAjuda.setFont(new Font("Arial", Font.BOLD, 14));
		menuBar.add(menAjuda);
		
		JMenuItem menAjudaSobre = new JMenuItem("Sobre");
		menAjudaSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sobre = new Sobre();
				TelaUsuario tp = new TelaUsuario();
				sobre.show();
				
               			
				
				
			}
		});
		menAjudaSobre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		menAjuda.add(menAjudaSobre);
		
		JMenuItem mntmSuporte = new JMenuItem("Suporte");
		mntmSuporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Suportee sup = new Suportee();
				sup.show();
				dispose();
			}
		});
		mntmSuporte.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_DOWN_MASK));
		menAjuda.add(mntmSuporte);
		
		JMenu menOpcoes = new JMenu("Opções");
		menOpcoes.setHorizontalAlignment(SwingConstants.LEFT);
		menOpcoes.setIcon(new ImageIcon("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Downloads\\cardapio (1).png"));
		menOpcoes.setForeground(Color.DARK_GRAY);
		menOpcoes.setFont(new Font("Arial", Font.BOLD, 14));
		menuBar.add(menOpcoes);
		
		JMenuItem menOpcoesSair = new JMenuItem("Sair");
		menOpcoesSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaUsuario tp = new TelaUsuario();
				int sair = JOptionPane.showConfirmDialog(tp,"Tem certeza que deseja sair?","Atenção",JOptionPane.YES_NO_OPTION);
				if(sair == JOptionPane.YES_OPTION) {
				TelaEscolhaa ts = new TelaEscolhaa();
				ts.show();
				dispose();
				}
				
			}
		});
		menOpcoesSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_DOWN_MASK));
		menOpcoes.add(menOpcoesSair);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 30, 310, 507);
		panel_1.setBackground(Color.DARK_GRAY);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		
		lblUsuario.setBounds(59, 27, 227, 46);
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel_1.add(lblUsuario);
		lblData.setBounds(62, 434, 148, 41);
		
		
		lblData.setForeground(Color.WHITE);
		lblData.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel_1.add(lblData);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(10, 27, 55, 46);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Downloads\\user (2).png"));
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBounds(10, 434, 55, 46);
		lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Downloads\\data-limite.png"));
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 307, 507);
		panel_1.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Desktop\\Programa5.0\\fundo.jpg"));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(309, 38, 569, 499);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Desktop\\Programa5.0\\fundo3.jpg"));
		lblNewLabel_2.setBounds(10, -14, 621, 513);
		panel.add(lblNewLabel_2);
		
		lblHora.setHorizontalAlignment(SwingConstants.CENTER);
		lblHora.setForeground(Color.DARK_GRAY);
		lblHora.setBackground(Color.DARK_GRAY);
		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblHora.setBounds(740, 0, 138, 35);
		contentPane.add(lblHora);
	}
	
	class hora implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Calendar agora = Calendar.getInstance();
			
			lblHora.setText(String.format("%1$tH:%1$tM:%1$tS", agora));
		}
	}
}
