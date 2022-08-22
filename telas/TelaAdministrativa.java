package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Conexao;

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
import java.time.*;


public class TelaAdministrativa extends JFrame {

	private JPanel contentPane;
	JLabel lblData = new JLabel("Data");
	JLabel lblAdm = new JLabel("Administrador");
	JLabel lblHora = new JLabel();


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
					LoginAdmin ladm = new LoginAdmin();
					ladm.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	public TelaAdministrativa() {
		setResizable(false);
		setTitle("ADM");
		
		
		
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
		setBounds(100, 100, 862, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		menuBar.setBounds(0, 0, 713, 35);
		contentPane.add(menuBar);
		
		JMenu menCadastro = new JMenu("Controle");
		menCadastro.setIcon(new ImageIcon("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Downloads\\cadastro (3).png"));
		menCadastro.setForeground(Color.DARK_GRAY);
		menCadastro.setFont(new Font("Arial", Font.BOLD, 14));
		menuBar.add(menCadastro);
		
		
		JMenuItem menCadUser = new JMenuItem("Usuario");
		menCadUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControleUsuarioo c = new ControleUsuarioo();
				TelaUsuario tp = new TelaUsuario();
				c.show(true);
				dispose();
				
				
				
				
			}
		});
		menCadUser.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_DOWN_MASK));
		menCadUser.setHorizontalAlignment(SwingConstants.LEFT);
		menCadUser.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menCadastro.add(menCadUser);
		
		JMenuItem mntmTabelaDeUsuarios = new JMenuItem("Tabela de Usuarios");
		mntmTabelaDeUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControleUsuarioo Contr = new ControleUsuarioo();
				Contr.show();
				dispose();
			}
		});
		mntmTabelaDeUsuarios.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_DOWN_MASK));
		mntmTabelaDeUsuarios.setHorizontalAlignment(SwingConstants.LEFT);
		mntmTabelaDeUsuarios.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menCadastro.add(mntmTabelaDeUsuarios);
		
		JMenu menAjuda = new JMenu("Solicitações");
		menAjuda.setIcon(new ImageIcon("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Downloads\\apoio-suporte.png"));
		menAjuda.setForeground(Color.DARK_GRAY);
		menAjuda.setFont(new Font("Arial", Font.BOLD, 14));
		menuBar.add(menAjuda);
		
		JMenuItem menAjudaSobre = new JMenuItem("Problemas");
		menAjudaSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Suportee Prob = new Suportee();
				Prob.show();
				dispose();
				
				
			}
		});
		menAjudaSobre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK));
		menAjuda.add(menAjudaSobre);
		
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
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 35, 276, 502);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		
		lblAdm.setBounds(59, 10, 207, 46);
		lblAdm.setForeground(Color.WHITE);
		lblAdm.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel_1.add(lblAdm);
		lblData.setBounds(62, 431, 148, 41);
		
		
		lblData.setForeground(Color.WHITE);
		lblData.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel_1.add(lblData);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(10, 10, 55, 46);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Downloads\\user (2).png"));
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBounds(10, 431, 55, 46);
		lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Downloads\\data-limite.png"));
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Desktop\\Programa5.0\\fundo.jpg"));
		lblNewLabel.setBounds(0, 0, 283, 513);
		panel_1.add(lblNewLabel);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(0, 0, 0));
		panel_1_1.setBounds(275, 35, 573, 502);
		contentPane.add(panel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(73, 322, 128, 128);
		panel_1_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setBounds(10, 10, 55, 46);
		panel_1_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setBounds(10, 112, 55, 46);
		panel_1_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Desktop\\Programa5.0\\fundo3.jpg"));
		lblNewLabel_3.setBounds(0, 0, 573, 513);
		panel_1_1.add(lblNewLabel_3);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(712, 0, 136, 35);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblHora.setForeground(Color.WHITE);
		lblHora.setHorizontalAlignment(SwingConstants.CENTER);
		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblHora.setBounds(0, 0, 136, 35);
		panel.add(lblHora);
	}
	
	
	class hora implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Calendar agora = Calendar.getInstance();
			
			lblHora.setText(String.format("%1$tH:%1$tM:%1$tS", agora));
		}
	}
	
	
	
	
	
	
	
}
