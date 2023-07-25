import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.*;
import javax.swing.*;
public class Login {
	
	public static void main(String[] args) {
		new Login();
	}
	
	JFrame frame = new JFrame();
	JButton btn = new JButton();
	JLabel label = new JLabel();
	JTextField field = new JTextField();

	Login(){
		
		JButton b1 = new JButton();
		b1.setBounds(160, 100, 200, 40);
		b1.setText("Create new Account");
		b1.setFocusable(false);
		b1.setFont(new Font("Arial", Font.BOLD, 15));
		b1.setForeground(Color.WHITE);
		b1.setBackground(new Color(0x1A5F7A));
		
		b1.addActionListener(e -> {
			b1.setEnabled(false);
			new CustomerData();
			frame.dispose();
			
		});
		
		JButton b2 = new JButton();
		b2.setBounds(170, 200, 180, 40);
		b2.setText("Log In/Sign In");
		b2.setFocusable(false);
		b2.setFont(new Font("Arial", Font.BOLD, 15));
		b2.setForeground(Color.WHITE);
		b2.setBackground(new Color(0x1A5F7A));
		b2.addActionListener(e -> {
			new LoginPage();
			frame.dispose();
		});
		
		JLabel l4 = new JLabel();
		l4.setBounds(0, 0, 500, 50);
		l4.setText("Welcome Please choose among below options.");
		l4.setFont(new Font("Comic Sans", Font.PLAIN, 20));
		l4.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel l3 = new JLabel();
		l3.setBounds(0, 100, 500, 500);
		l3.add(l4);
		l3.add(b1);
		l3.add(b2);
		l3.setHorizontalAlignment(JLabel.CENTER);
		l3.setVerticalAlignment(JLabel.CENTER);
		
		JPanel p3 = new JPanel();
		p3.setBounds(150, 200, 500, 500);
		p3.setBackground(new Color(0xDAF5FF));
		p3.setLayout(null);
		p3.add(l3);
		
		JLabel l2 = new JLabel();
		l2.setText("Where medicines makes sense...");
		l2.setFont(new Font("Comic Sans", Font.BOLD, 20));
		l2.setForeground(Color.BLACK);
		l2.setBounds(0, 5, 800, 50);
		l2.setHorizontalAlignment(JLabel.CENTER);
		l2.setVerticalAlignment(JLabel.CENTER);
		
		JPanel p2 = new JPanel();
		p2.setBounds(0, 120, 800, 50);
		p2.setBackground(new Color(0x579BB1));
		p2.setLayout(null);
		p2.add(l2);
		
		JLabel l1 = new JLabel();
		ImageIcon img = new ImageIcon("icons8-pills-48.png");
		l1.setIcon(img);
		l1.setIconTextGap(20); 
		l1.setText("NEUTRON PHARMACY");
		l1.setFont(new Font("Comic Sans", Font.BOLD, 35));
		l1.setForeground(Color.WHITE);
		l1.setBounds(0, 0, 800, 100);
		l1.setHorizontalAlignment(JLabel.CENTER);
		l1.setVerticalAlignment(JLabel.CENTER);
		
		JPanel p1 = new JPanel();
		p1.setBounds(0, 30, 790, 100);
		p1.setBackground(new Color(0x0B2447));
		
		
		p1.setLayout(null);
		p1.add(l1);
		
		frame.setSize(800, 800);
		frame.setBounds(350, 0, 800, 800);
		frame.setResizable(false);
		frame.setTitle("Neutron Pharmacy");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(p1);
		frame.getContentPane().add(p2);
		frame.getContentPane().add(p3);
		frame.setVisible(true);
		
	}
	
}
