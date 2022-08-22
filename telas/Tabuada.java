package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class Tabuada extends JFrame {

	private JPanel contentPane;
	private JTextField textNum;
	JTextArea textArea = new JTextArea();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tabuada frame = new Tabuada();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void tabuSoma() {
		int num = Integer.parseInt(textNum.getText());
		
		for(int i = 0; i<=10; i++) {
			textArea.append(num+" + "+i+" = "+(num + i)+"\n");
		}
		
	}
	
	public void tabuSub() {
	int num = Integer.parseInt(textNum.getText());
		
		for(int i = 0; i<=10; i++) {
			textArea.append(num+" - "+i+" = "+(num - i)+"\n");
		}
	}
	
	public void tabuDiv() {
	int num = Integer.parseInt(textNum.getText());
		
		for(int i = 0; i<=10; i++) {
			textArea.append(num+" ÷ "+i+" = "+(num / i)+"\n");
		}
	}
	
	public void tabuMult() {
	int num = Integer.parseInt(textNum.getText());
		
		for(int i = 0; i<=10; i++) {
			textArea.append(num+" x "+i+" = "+(num * i)+"\n");
		}
	}
	
	


	public Tabuada() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Desktop\\ProgramaJAVA\\imagens\\eclipse (1).png"));
		setTitle("Tabuada");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 836, 654);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.WHITE);
		panel.setBounds(299, 0, 523, 617);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(296, 254, 217, 232);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Downloads\\undraw_mathematics_4otb (1) (1).png"));
		panel.add(lblNewLabel_2);
		textArea.setBackground(Color.WHITE);
		textArea.setBounds(23, 254, 275, 336);
		

		textArea.setFont(new Font("Monospaced", Font.BOLD, 19));
		panel.add(textArea);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBackground(Color.BLUE);
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.setBounds(366, 188, 128, 25);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNum.setText("");
				textArea.setText("");
			}
		});
		panel.add(btnLimpar);
		
		JLabel lblNewLabel_1_1 = new JLabel("Operação:");
		lblNewLabel_1_1.setBounds(23, 180, 93, 33);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JComboBox comboSelect = new JComboBox();
		comboSelect.setBounds(142, 184, 140, 25);
		panel.add(comboSelect);
		comboSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		comboSelect.setFont(new Font("Tahoma", Font.PLAIN, 19));
		comboSelect.setModel(new DefaultComboBoxModel(new String[] {"+", "-", "÷", "x"}));
		
		JLabel lblNewLabel_1 = new JLabel("Número:");
		lblNewLabel_1.setBounds(23, 125, 93, 33);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textNum = new JTextField();
		textNum.setBounds(142, 133, 140, 25);
		panel.add(textNum);
		textNum.setFont(new Font("Tahoma", Font.PLAIN, 23));
		textNum.setColumns(10);
		
		JButton btnNewButton = new JButton("Gerar");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setBounds(366, 133, 128, 25);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Tabuada");
		lblNewLabel.setBounds(207, 10, 109, 72);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 245, 297, 351);
		panel.add(panel_2);
		panel_2.setBackground(Color.BLUE);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 297, 28);
		contentPane.add(menuBar);
		menuBar.setBackground(Color.DARK_GRAY);
		
		JMenu mnNewMenu = new JMenu("Menu");
		mnNewMenu.setIcon(new ImageIcon("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Downloads\\mais.png"));
		mnNewMenu.setForeground(Color.WHITE);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Voltar");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaUsuario tu = new TelaUsuario();
				tu.show();
				dispose();
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon("C:\\Users\\Breno.LAPTOP-5QL5UQB5\\Desktop\\ProgramaJAVA\\imagens\\de-volta.png"));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 0, 204));
		panel_1.setBounds(0, 32, 297, 585);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					if(textNum.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Digite um numero e escolha uma opção");
					}
					
					
					
					if(comboSelect.getSelectedItem().equals("+")) {
						tabuSoma();
					}else if(comboSelect.getSelectedItem().equals("-")) {
						tabuSub();
					}else if(comboSelect.getSelectedItem().equals("÷")) {
						tabuDiv();
					}else if(comboSelect.getSelectedItem().equals("x")){
						tabuMult();
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Tente Novamente");
				}
			}
		});
	}
}
