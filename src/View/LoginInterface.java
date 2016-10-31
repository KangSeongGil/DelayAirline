package View;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

import Controller.Controller;

import java.awt.Font;

public class LoginInterface {

	private JFrame frame;
	private JTextField ID_textField;
	private JPasswordField PW_textField;
	private Controller controller;
	private ImageIcon img;
	
	public LoginInterface(Controller controller) {
		initialize();
		frame.setVisible(true);
		this.controller = controller;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(128, 128, 128));
		frame.setBounds(300, 40, 1024, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		img = new ImageIcon("BG.PNG");
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(224, 255, 255));
		panel.setBackground(new Color(105, 105, 105));
		panel.setBounds(0, 0, 1008, 730);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setForeground(new Color(248, 248, 255));
		lblId.setBounds(432, 301, 57, 15);
		panel.add(lblId);
		
		JLabel lblPw = new JLabel("PW :");
		lblPw.setForeground(new Color(248, 248, 255));
		lblPw.setBounds(432, 351, 57, 15);
		panel.add(lblPw);
		
		ID_textField = new JTextField();
		ID_textField.setBounds(501, 298, 116, 21);
		panel.add(ID_textField);
		ID_textField.setColumns(10);
		
		JButton LogIn_btn = new JButton("Log In");
		LogIn_btn.setForeground(new Color(255, 255, 255));
		LogIn_btn.setBackground(new Color(30, 144, 255));
		LogIn_btn.setFont(new Font("����", Font.PLAIN, 16));
		LogIn_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.loginAction();
			}
		});
		LogIn_btn.setBounds(432, 399, 185, 58);
		panel.add(LogIn_btn);
		
		PW_textField = new JPasswordField();
		PW_textField.setBounds(501, 348, 116, 21);
		panel.add(PW_textField);
		
		JLabel lblNewLabel = new JLabel(img);
		lblNewLabel.setBounds(0, 0, 1024, 768);
		panel.add(lblNewLabel);
	}
	
	public JFrame getFrame(){
		return this.frame;
	}
	
	public String getID(){
		String ID;
		ID = ID_textField.getText();
		return ID;
	}
	
	public char[] getPW(){
		char[] PW = new char[10];
		PW = PW_textField.getPassword();
		return PW;
	}
	
	public void errorMessage(){
		
		JOptionPane.showMessageDialog(null, "�ش��ϴ� ID / PW �� �����ϴ�.");
	}
}
