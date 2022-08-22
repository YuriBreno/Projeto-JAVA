package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Conexao;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Cursor;
import net.proteanit.sql.DbUtils;
import java.awt.Dimension;
import javax.swing.ListSelectionModel;
import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;


public class ControleUsuarioo extends JFrame {

	private JPanel contentPane;
	private Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	DefaultTableModel modelo = new DefaultTableModel();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControleUsuarioo frame = new ControleUsuarioo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	public ResultSet Consultar() {
		String sql = "select * from usuario ";
		try {
			pst = conexao.prepareStatement(sql);
			rs = pst.executeQuery();
			
	
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return rs;
		
	}
	
	
	
	
	
	public void load_table() {
		Conexao conn = new Conexao();
		table.setRowSelectionAllowed(false);
		table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		table.setModel(DbUtils.resultSetToTableModel(Consultar()));
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setResizable(false);
	}
	

	
	public ControleUsuarioo() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Desktop\\Programa5.0\\LOGO.png"));
		conexao = model.Conexao.conector();
		setTitle("Controle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 973, 660);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 0, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JLabel lblNewLabel = new JLabel("Tabela de Usuarios");
		lblNewLabel.setBounds(95, 39, 243, 66);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(75, 559, 196, 39);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblConsultar = new JLabel("Consultar");
		lblConsultar.setBounds(40, 0, 79, 39);
		panel.add(lblConsultar);
		lblConsultar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblConsultar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				load_table();
			}
		});
		lblConsultar.setForeground(Color.BLACK);
		lblConsultar.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Downloads\\procurando.png"));
		lblNewLabel_1.setBounds(141, 0, 55, 50);
		panel.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(363, 39, 586, 574);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 19));
		table.setForeground(Color.WHITE);
		table.setBackground(Color.DARK_GRAY);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Downloads\\do-utilizador (2).png"));
		lblNewLabel_1_1.setBounds(10, 39, 64, 76);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Desktop\\ProgramaJAVA\\imagens\\cadastro (1).png"));
		lblNewLabel_2.setBounds(153, 252, 70, 76);
		contentPane.add(lblNewLabel_2);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.WHITE);
		menuBar.setBackground(Color.DARK_GRAY);
		menuBar.setBounds(0, 0, 959, 29);
		contentPane.add(menuBar);
		
		JMenu menMenu = new JMenu("Menu");
		menMenu.setForeground(Color.WHITE);
		menMenu.setIcon(new ImageIcon("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Downloads\\mais.png"));
		menuBar.add(menMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Voltar");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdministrativa tadm = new TelaAdministrativa();
				tadm.show();
				dispose();
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Desktop\\Programa2.0\\imagem-projeto-2.0\\calculadoraIMC\\de-volta.png"));
		menMenu.add(mntmNewMenuItem);
	
		
	}
}
