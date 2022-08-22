package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;

public class TelaEscolhaa extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEscolhaa frame = new TelaEscolhaa();
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
	public TelaEscolhaa() {
		setTitle("ESCOLHA");
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Desktop\\Programa5.0\\LOGO.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 0, 204));
		panel.setBounds(0, 0, 332, 310);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Downloads\\user (3).png"));
		lblNewLabel.setBounds(126, 34, 80, 122);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Bem-vindo(a)");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(97, 163, 137, 31);
		panel.add(lblNewLabel_1);
		
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(330, 0, 433, 310);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Escolha como quer entrar");
		lblNewLabel_1_1.setForeground(Color.GRAY);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1_1.setBounds(43, 10, 346, 48);
		panel_1.add(lblNewLabel_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLUE);
		panel_2.setBounds(43, 157, 140, 48);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblAdm = new JLabel("Administrador");
		lblAdm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginAdmin la = new LoginAdmin();
				la.show();
				dispose();
			}
		});
		lblAdm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
	
		lblAdm.setForeground(Color.WHITE);
		lblAdm.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblAdm.setBounds(10, 10, 120, 28);
		panel_2.add(lblAdm);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(Color.BLUE);
		panel_2_1.setBounds(249, 157, 140, 48);
		panel_1.add(panel_2_1);
		
		JLabel lblUser = new JLabel("Usuário");
		lblUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginUseer lu = new LoginUseer();
				lu.show();
				dispose();
			}
		});
		lblUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblUser.setForeground(Color.WHITE);
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblUser.setBounds(34, 10, 72, 28);
		panel_2_1.add(lblUser);
	}
}
