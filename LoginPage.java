import java.awt.*;
import java.sql.*;

import javax.swing.*;

public class LoginPage {
	PharmacyManagement pm = new PharmacyManagement();
	
	JFrame frame = new JFrame();
	JTextField tone = new JTextField();
	JTextField ttwo = new JTextField();
	int out = 0;
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	String email;
	String name;
	String phNo;
	String address;
	String gender;
	int age;
	
	public void decore(JTextField t, JLabel l, String s, JPanel p) {
		t.setPreferredSize(new Dimension(150, 45));
		t.setFont(new Font("Comic Sans", Font.BOLD, 17));
		l.setText(s);
		l.setFont(new Font("Comic Sans", Font.PLAIN, 25));
		p.setBackground(Color.WHITE);
		p.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
		p.add(l);
		p.add(t);
	}
	
	LoginPage(){
		
		JButton btn = new JButton();
		btn.setText("Next");
		btn.setFont(new Font("Comic Sans", Font.BOLD, 17));
		btn.setBounds(640, 685, 100, 50);
		btn.setFocusable(false);
		btn.setBackground(new Color(0x0B2447));
		btn.setForeground(Color.WHITE);
		
		btn.addActionListener(e -> {
			try {
				email = tone.getText();
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject", "root", "namMaha@123");
				String query = "select * from customer where Email=? ";
				pst = con.prepareStatement(query);
				pst.setString(1, email);
				rs = pst.executeQuery();
				if(rs.next() == false) {
					String[] responses = {"Go to main page", "Retry"};
					ImageIcon icon = new ImageIcon("icons8-card-payment-50.png");
					int collect = JOptionPane.showOptionDialog(
							null,
							"Incorrect Email and phone No.",
							"Wrong Entry",
							JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.INFORMATION_MESSAGE,
							icon,
							responses,
							0);
					
					if(collect == 0) {
						new Login();
					}else {
						new LoginPage();
					}
					System.out.println("Not found");
				}else {
//					
					new Menu(email, 2);
					Bill.deleteRows();
					PrescriptionMenu p = new PrescriptionMenu();
					p.getEmail(email);
					frame.dispose();
				}
				
			} catch (Exception e1) {
				
			}
			
			frame.dispose();
		});
		
		JLabel lone = new JLabel();
		JPanel pone = new JPanel();
		decore(tone, lone, "Email :  ", pone);
		
		JLabel ltwo = new JLabel();
		JPanel ptwo = new JPanel();
		decore(ttwo, ltwo, "Phone no. :  ", ptwo);
		
		JPanel p3 = new JPanel();
		p3.setBounds(100, 200, 500, 150);
		p3.setLayout(new GridLayout(2, 1, 20, 20));
		p3.setBackground(Color.WHITE);
		p3.add(pone);
		p3.add(ptwo);
		
		JPanel p2 = new JPanel();
		p2.setBounds(40, 100, 700, 560);
		p2.setBackground(new Color(0xDAF5FF));
		p2.setLayout(null);
		p2.add(p3);
		
		JLabel l1 = new JLabel();
		l1.setBounds(0,0,800, 100);
		l1.setText("Log In / Sign In");
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
