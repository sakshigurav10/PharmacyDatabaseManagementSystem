import java.awt.*;
import java.text.NumberFormat;

import javax.swing.*;

public class CustomerData{
	
	PharmacyManagement pm = new PharmacyManagement();
	Sales s;
	
	JFrame frame = new JFrame();
	JTextField tone = new JTextField();
	JTextField ttwo = new JTextField();
	JTextField tthree = new JTextField();
	JTextField tfour = new JTextField();
	JTextField tfive = new JTextField();
	JTextField tsix = new JTextField();
	
	public void decore(JTextField t, JLabel l, String s, JPanel p) {
		t.setPreferredSize(new Dimension(150, 45));
		t.setFont(new Font("Comic Sans", Font.BOLD, 17));
		l.setText(s);
		l.setFont(new Font("Comic Sans", Font.PLAIN, 25));
		p.setBackground(Color.white);
		p.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
		p.add(l);
		p.add(t);
	}
	
	CustomerData(){
		
		JButton btn = new JButton();
		btn.setText("Next");
		btn.setFont(new Font("Comic Sans", Font.BOLD, 17));
		btn.setBounds(640, 685, 100, 50);
		btn.setFocusable(false);
		btn.setBackground(new Color(0x0B2447));
		btn.setForeground(Color.WHITE);
		
		btn.addActionListener(e -> {
			String email = tone.getText();
			String name = ttwo.getText();
			int age = Integer.parseInt(tthree.getText());
			String gender = tfour.getText();
			String phNo = tfive.getText();
			String address = tsix.getText();
			
			s.CustAttri(new CollectCustomerData(email, name, phNo, address, gender, age));
			
			try {
				pm.insert(email, name, address, phNo, age, gender);
			} catch (Exception e1) {
				
			}
			
			Bill.deleteRows();
			new Menu(email, 1);
			frame.dispose();
		});
		
		
		JLabel lone = new JLabel();
		JPanel pone = new JPanel();
		decore(tone, lone, "Email :  ", pone);
		
		JLabel ltwo = new JLabel();
		JPanel ptwo = new JPanel();
		decore(ttwo, ltwo, "Name :  ", ptwo);
		
		JLabel lthree = new JLabel();
		JPanel pthree = new JPanel();
		decore(tthree, lthree, "Age :  ", pthree);
		
		JLabel lfour = new JLabel();
		JPanel pfour = new JPanel();
		decore(tfour, lfour, "Gender :  ", pfour);
		
		JLabel lfive = new JLabel();
		JPanel pfive = new JPanel();
		decore(tfive, lfive, "Phone no. :  ", pfive);
		
		JLabel lsix = new JLabel();
		JPanel psix = new JPanel();
		decore(tsix, lsix, "Address :  ", psix);
		
		JPanel p3 = new JPanel();
		p3.setBounds(150, 25, 400, 500);
		p3.setBackground(new Color(0xDAF5FF));
		p3.setLayout(new GridLayout(6, 1, 0, 20));
		p3.add(pone);
		p3.add(ptwo);
		p3.add(pthree);
		p3.add(pfour);
		p3.add(pfive);
		p3.add(psix);
		
		JPanel p2 = new JPanel();
		p2.setBounds(40, 100, 700, 560);
		p2.setBackground(new Color(0xDAF5FF));
		p2.setLayout(null);
		p2.add(p3);
		
		JLabel l1 = new JLabel();
		l1.setBounds(0,0,800, 100);
		l1.setText("Please enter your Details below.");
		l1.setFont(new Font("Comic Sans", Font.BOLD, 35));
		l1.setForeground(Color.WHITE);
		l1.setHorizontalAlignment(JLabel.CENTER);
		l1.setVerticalAlignment(JLabel.CENTER);
		
		JPanel p1 = new JPanel();
		p1.setBounds(0, 0, 800, 100);
		p1.setBackground(new Color(0x0B2447));
		p1.setLayout(null);
		p1.add(l1);
		
		frame.setBounds(350, 0, 800, 800);
		frame.setResizable(false);
		frame.setTitle("Neutron Pharmacy");
		frame.setLayout(null);
		frame.setBackground(Color.white);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(p1);
		frame.add(p2);
		frame.add(btn);
		
		frame.setVisible(true);
	}
	
}
