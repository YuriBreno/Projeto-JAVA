package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Sobre extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobre frame = new Sobre();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Sobre() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Downloads\\ajuda (1).png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 402);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(10, 39, 503, 316);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sistema com menu de programs");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(21, 29, 416, 59);
		panel.add(lblNewLabel);
		
		JLabel lblComMenuDe = new JLabel("utilizando Java");
		lblComMenuDe.setForeground(Color.WHITE);
		lblComMenuDe.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblComMenuDe.setBounds(21, 74, 341, 59);
		panel.add(lblComMenuDe);
		
		JLabel lblDesenvolvidoPorJos = new JLabel("Desenvolvido por: José Yuri e Gabryel Rodrigues");
		lblDesenvolvidoPorJos.setForeground(Color.WHITE);
		lblDesenvolvidoPorJos.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDesenvolvidoPorJos.setBounds(21, 169, 483, 59);
		panel.add(lblDesenvolvidoPorJos);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(339, 29, 154, 128);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Downloads\\java (3).png"));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.WHITE);
		menuBar.setBackground(Color.BLUE);
		menuBar.setBounds(0, 0, 681, 29);
		contentPane.add(menuBar);
		
		JMenu menMenu = new JMenu("Menu");
		menMenu.setForeground(Color.WHITE);
		menMenu.setIcon(new ImageIcon("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Downloads\\mais.png"));
		menuBar.add(menMenu);
		
		JMenuItem menVoltar = new JMenuItem("Voltar");
		menVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaUsuario tpp = new TelaUsuario();
			tpp.show();
			dispose();
			} 
		});
		menVoltar.setIcon(new ImageIcon("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Downloads\\de-volta.png"));
		menMenu.add(menVoltar);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(25, 25, 112));
		panel_1.setBounds(521, 39, 160, 316);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Downloads\\eclipse (3).png"));
		lblNewLabel_1.setBounds(10, 46, 126, 197);
		panel_1.add(lblNewLabel_1);
	}
}
