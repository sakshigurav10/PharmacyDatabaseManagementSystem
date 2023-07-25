import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.SystemColor;

public class DataAnalysis extends Sales {
	
	JFrame frame = new JFrame();
	JButton btn = new JButton();
	JLabel label = new JLabel();
	JTextField field = new JTextField();
	
	public void Font(JLabel l) {
		l.setFont(new Font("Tahoma", Font.BOLD, 15));
	}
	
	DataAnalysis(){
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
		
		JPanel panel = new JPanel();
		panel.setBounds(24, 180, 741, 506);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sales Count : ");
		lblNewLabel.setBounds(175, 51, 108, 27);
		Font(lblNewLabel);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Female count : ");
		lblNewLabel_1.setBounds(175, 119, 148, 27);
		Font(lblNewLabel_1);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Male count : ");
		lblNewLabel_1_1.setBounds(175, 186, 148, 27);
		Font(lblNewLabel_1_1);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Minimum Age : ");
		lblNewLabel_1_1_1.setBounds(175, 259, 148, 27);
		Font(lblNewLabel_1_1_1);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Maximum Age : ");
		lblNewLabel_1_1_1_1.setBounds(175, 330, 148, 27);
		Font(lblNewLabel_1_1_1_1);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Max amount : ");
		lblNewLabel_1_1_1_1_1.setBounds(175, 397, 148, 27);
		Font(lblNewLabel_1_1_1_1_1);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Average amount : ");
		lblNewLabel_1_1_1_1_1_1.setBounds(175, 462, 148, 27);
		Font(lblNewLabel_1_1_1_1_1_1);
		panel.add(lblNewLabel_1_1_1_1_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(358, 51, 273, 27);
		panel_1.setBackground(SystemColor.controlHighlight);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		String query = "select count(Email) as count from sales";
		JLabel lblNewLabel_2 = new JLabel(""+ count(query));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(40, 0, 194, 27);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(358, 119, 273, 27);
		panel_1_1.setBackground(SystemColor.controlHighlight);
		panel.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		String query1 = "select count(Email) as count from sales where Gender = 'F'";
		JLabel lblNewLabel_2_1 = new JLabel(""+count(query1));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(40, 0, 194, 27);
		panel_1_1.add(lblNewLabel_2_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBounds(358, 186, 273, 27);
		panel_1_2.setBackground(SystemColor.controlHighlight);
		panel.add(panel_1_2);
		panel_1_2.setLayout(null);
		
		String query2 = "select count(Email) as count from sales where Gender = 'M'";
		JLabel lblNewLabel_2_1_1 = new JLabel(""+count(query2));
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1_1.setBounds(41, 0, 194, 27);
		panel_1_2.add(lblNewLabel_2_1_1);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBounds(358, 259, 273, 27);
		panel_1_3.setBackground(SystemColor.controlHighlight);
		panel.add(panel_1_3);
		panel_1_3.setLayout(null);
		
		String query3 = "select min(Age) as count from sales";
		JLabel lblNewLabel_2_1_1_1 = new JLabel(""+count(query3));
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1_1_1.setBounds(43, 0, 194, 27);
		panel_1_3.add(lblNewLabel_2_1_1_1);
		
		JPanel panel_1_4 = new JPanel();
		panel_1_4.setBounds(358, 330, 273, 27);
		panel_1_4.setBackground(SystemColor.controlHighlight);
		panel.add(panel_1_4);
		panel_1_4.setLayout(null);
		
		String query4 = "select max(Age) as count from sales";
		JLabel lblNewLabel_2_1_1_2 = new JLabel(""+count(query4));
		lblNewLabel_2_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1_1_2.setBounds(43, 0, 194, 27);
		panel_1_4.add(lblNewLabel_2_1_1_2);
		
		JPanel panel_1_5 = new JPanel();
		panel_1_5.setBounds(358, 397, 273, 27);
		panel_1_5.setBackground(SystemColor.controlHighlight);
		panel.add(panel_1_5);
		panel_1_5.setLayout(null);
		
		String query5 = "select max(Amount) as count from sales";
		JLabel lblNewLabel_2_1_1_3 = new JLabel(""+count(query5));
		lblNewLabel_2_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1_1_3.setBounds(42, 0, 194, 27);
		panel_1_5.add(lblNewLabel_2_1_1_3);
		
		JPanel panel_1_6 = new JPanel();
		panel_1_6.setBounds(358, 462, 273, 27);
		panel_1_6.setBackground(SystemColor.controlHighlight);
		panel.add(panel_1_6);
		panel_1_6.setLayout(null);
		
		String query6 = "select avg(Amount) as count from sales";
		JLabel lblNewLabel_2_1_1_4 = new JLabel(""+count(query6));
		lblNewLabel_2_1_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1_1_4.setBounds(41, 0, 194, 27);
		panel_1_6.add(lblNewLabel_2_1_1_4);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setFocusable(false);
		btnNewButton.setBounds(328, 696, 123, 35);
		btnNewButton.addActionListener(e -> {
			frame.dispose();
		});
		frame.getContentPane().add(btnNewButton);
		
		
		frame.setVisible(true);
	}
}
