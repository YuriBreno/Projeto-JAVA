package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenu;

import java.awt.Font;
import javax.swing.JTable;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class CalculaIdade extends JFrame {

	private JPanel contentPane;
	private JTextField textAno;
	private JTextField textMeses;
	private JTextField textDias;
	JDateChooser DataNasc = new JDateChooser();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculaIdade frame = new CalculaIdade();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void CalcIdade() {
		LocalDate dataNasc = DataNasc.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate dataAtual = LocalDate.now();
		Period periodo = Period.between(dataNasc, dataAtual);
		
		textAno.setText(String.valueOf(periodo.getYears()));
		textMeses.setText(String.valueOf(periodo.getMonths()));
		textDias.setText(String.valueOf(periodo.getDays()));
		
		
	}
	
	public void limpa() {
		textAno.setText("");
		textMeses.setText("");
		textDias.setText("");
	}
	
	
	public CalculaIdade() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Desktop\\Programa5.0\\LOGO.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(317, 27, 598, 458);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_1_1_1_1_1.setBounds(19, 214, 95, 25);
		panel.add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Sua data de nascimento");
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1.setBounds(31, 24, 241, 25);
		panel.add(lblNewLabel_1);
		
		DataNasc.setBounds(31, 68, 262, 35);
		panel.add(DataNasc);
		
		JLabel lblVocTem = new JLabel("Você tem:");
		lblVocTem.setForeground(Color.DARK_GRAY);
		lblVocTem.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblVocTem.setBounds(31, 269, 140, 25);
		panel.add(lblVocTem);
		
		textAno = new JTextField();
		textAno.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textAno.setColumns(10);
		textAno.setBounds(40, 329, 80, 28);
		panel.add(textAno);
		
		JLabel lblAnos = new JLabel("Anos");
		lblAnos.setForeground(Color.DARK_GRAY);
		lblAnos.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAnos.setBounds(137, 332, 140, 25);
		panel.add(lblAnos);
		
		JLabel lblMses = new JLabel("Meses");
		lblMses.setForeground(Color.DARK_GRAY);
		lblMses.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblMses.setBounds(137, 368, 87, 25);
		panel.add(lblMses);
		
		textMeses = new JTextField();
		textMeses.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textMeses.setColumns(10);
		textMeses.setBounds(40, 367, 80, 28);
		panel.add(textMeses);
		
		textDias = new JTextField();
		textDias.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textDias.setColumns(10);
		textDias.setBounds(40, 408, 80, 28);
		panel.add(textDias);
		
		JLabel lblDias = new JLabel("Dias");
		lblDias.setForeground(Color.DARK_GRAY);
		lblDias.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblDias.setBounds(137, 409, 71, 25);
		panel.add(lblDias);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalcIdade();
			}
		});
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(414, 131, 155, 35);
		panel.add(btnNewButton);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpa();
			}
		});
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.setBackground(Color.BLUE);
		btnLimpar.setBounds(414, 199, 155, 35);
		panel.add(btnLimpar);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Desktop\\Programa2.0\\imagem-projeto-2.0\\CalculadoraIdade\\undraw_Calendar_re_ki49 (1) (3) (1).png"));
		lblNewLabel_2.setBounds(311, 30, 104, 204);
		panel.add(lblNewLabel_2);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 915, 28);
		contentPane.add(menuBar);
		menuBar.setBackground(Color.DARK_GRAY);
		
		JMenu mnNewMenu = new JMenu("Menu");
		mnNewMenu.setIcon(new ImageIcon("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Downloads\\mais.png"));
		mnNewMenu.setForeground(Color.WHITE);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Voltar");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaUsuario tUser = new TelaUsuario();
				tUser.show();
				dispose();
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Downloads\\de-volta.png"));
		mnNewMenu.add(mntmNewMenuItem);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 0, 204));
		panel_1.setBounds(0, 27, 333, 458);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Calcule sua idade");
		lblNewLabel.setBounds(50, 10, 183, 25);
		panel_1.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Downloads\\undraw_mathematics_4otb (1) (2).png"));
		lblNewLabel_2_1.setBounds(50, 132, 213, 222);
		panel_1.add(lblNewLabel_2_1);
	}
}
