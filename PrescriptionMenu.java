import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrescriptionMenu {
	JFrame frame = new JFrame();
	private JTable table;
	private JTable table1;
	private JTable table2;
	double sum = 0;
	static String db_url = "jdbc:mysql://localhost:3306/miniproject";
	static String user = "root";
	static String pass = "namMaha@123";
	
	static Connection con;
	static PreparedStatement pst;
	static ResultSet rs;
	static String emailId;
	static Sales s;
	
	public void getEmail(String email) {
		System.out.println(email);
		emailId = email;
	}

	PrescriptionMenu(){
		
	}
	
	PrescriptionMenu(String email){

		JLabel l1 = new JLabel();
		l1.setBounds(0,0,800, 100);
		l1.setText("NEUTRON PHARMACY");
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
		frame.setTitle("NEUTRON PHARMACY");
		frame.setBackground(Color.white);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(p1);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.setBounds(690, 10, 85, 27);
		btnNewButton_1.setFocusable(false);
		p1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(e -> {
			String[] responses = {"Bye"};
			ImageIcon icon = new ImageIcon("icons8-smiling-48.png");
			int collect = JOptionPane.showOptionDialog(
					null,
					"Thank you, visit again",
					"Thank you",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE,
					icon,
					responses,
					0);
			
			if(collect == 0) {
				frame.dispose();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 740, 689, -598);
		frame.getContentPane().add(scrollPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(33, 110, 707, 620);
		frame.getContentPane().add(tabbedPane);
	
		//PANEL 1 : ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		JPanel panel = new JPanel();
		tabbedPane.addTab("PRESCRIPTION", null, panel, null);
		tabbedPane.setFocusable(false);
		panel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(35, 37, 630, 293);
		panel.add(scrollPane_1);
		
		
		
		// Model Creation
		DefaultTableModel dm = new DefaultTableModel() {
			public Class getColumnClass(int column) {
				if(column == 0 || column == 5) {
					return Integer.class;
				}else {
					return String.class;
				}
			}
		};

		// table
		table = new JTable(dm);
		table.setFont(new Font("Comic sans", Font.PLAIN, 14));

		Menu_Prescription_Table mp1 = new Menu_Prescription_Table();
		scrollPane_1.setViewportView(mp1.insert(table, dm, email));
		
		ArrayList<BillContent> billData = new ArrayList<>();
		
		int n = dm.getRowCount();
		
		JButton btn3 = new JButton("Go to Bill");
		
		
		btn3.setFocusable(false);
		btn3.setBounds(252, 431, 200, 50);
		btn3.setFont(new Font("Comic sans", Font.PLAIN, 25));
		panel.add(btn3);
		panel.setBackground(new Color(0xDAF5FF));
		panel.setBorder(null);
		
		Menu_Prescription_Table mp = new Menu_Prescription_Table();
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(35, 331, 130, 36);
		comboBox.addItem("Sort By PresId");
		comboBox.addItem("Sort By PhysicianName");
		comboBox.addItem("Sort By PatientEmail");
		comboBox.addItem("Sort By MedNames");
		comboBox.addItem("Sort By Price");
		comboBox.addActionListener(e -> {
			String collectComboItem = (String) comboBox.getSelectedItem();
			if(collectComboItem.equals("Sort By PresId")){
				String query = "select * from prescriptionnmedicine order by PresId;";
				mp.sort(table, dm, query);
			}else if(collectComboItem.equals("Sort By PhysicianName")){
				String query = "select * from prescriptionnmedicine order by PhysicianName;";
				mp.sort(table, dm, query);
			}else if(collectComboItem.equals("Sort By PatientEmail")) {
				String query = "select * from prescriptionnmedicine order by PatientEmail;";
				mp.sort(table, dm, query);
			}else if(collectComboItem.equals("Sort By MedNames")) {
				String query = "select * from prescriptionnmedicine order by MedNames;";
				mp.sort(table, dm, query);
			}else if(collectComboItem.equals("Sort By Price")) {
				String query = "select * from prescriptionnmedicine order by Price;";
				mp.sort(table, dm, query);
			}
		});
		panel.add(comboBox);
		
		//PANEL 2 : ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		JPanel panel1 = new JPanel();
		tabbedPane.addTab("BILL", null, panel1, null);
		tabbedPane.setFocusable(false);
		panel1.setLayout(null);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(39, 83, 630, 293);
		panel1.add(scrollPane2);
		
		
		// Model Creation
		DefaultTableModel dm1 = new DefaultTableModel() {
			public Class getColumnClass(int column) {
				if (column == 0) {
					return Integer.class;
				}else if(column == 1) {
					return String.class;
				}else if(column == 2){
					return String.class;
				}else {
					return Double.class;
				}
			}
		};

		// table
		table1 = new JTable(dm1);		
		panel1.setBackground(new Color(0xDAF5FF));
		panel1.setBorder(null);
		
		Bill b2 = new Bill();
		
		JButton btn2 = new JButton("Pay the Bill");
		btn2.setBounds(220, 450, 300, 50);
		
		btn2.setFocusable(false);
		btn2.setFont(new Font("Comic sans", Font.PLAIN, 25));
		panel1.add(btn2);
		panel1.setBackground(new Color(0xDAF5FF));
		panel1.setBorder(null);
		
		JLabel lblNewLabel = new JLabel("Total amount : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(426, 380, 107, 26);
		panel1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(255, 255, 255));
		panel_2.setBackground(new Color(128, 0, 0));
		panel_2.setBounds(39, 25, 630, 37);
		panel1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Customer Email : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(10, 10, 119, 17);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(email);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(120, 9, 500, 16);
		panel_2.add(lblNewLabel_2);
		
		btn2.addActionListener(e -> {
			String[] responses = {"Ok"};
			ImageIcon icon = new ImageIcon("icons8-card-payment-50.png");
			JOptionPane.showOptionDialog(
					null,
					"Payment Successful",
					"Payment Confirmation",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE,
					icon,
					responses,
					0);
		});
		
		
		//PANEL 2 END : ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		JPanel panel2 = new JPanel();
		tabbedPane.addTab("SALES", null, panel2, null);
		panel2.setLayout(null);
		
		JScrollPane scrollPane3 = new JScrollPane();
		scrollPane3.setBounds(35, 37, 630, 293);
		panel2.add(scrollPane3);
		
		JButton btn5 = new JButton("Go to Login Page");
		btn5.setBounds(200, 473, 300, 50);
		
		btn5.setFocusable(false);
		btn5.setFont(new Font("Comic sans", Font.PLAIN, 25));
		panel2.add(btn5);
		
		btn5.addActionListener(e -> {
			new Login();
			frame.dispose();
		});
		
		// Model Creation
		DefaultTableModel dm2 = new DefaultTableModel() {
			public Class getColumnClass(int column) {
				if(column == 5) {
					return Integer.class;
				}else if(column == 7) {
					return Double.class;
				}else {
					return String.class;
				}
			}
		};

		// table
		table2 = new JTable(dm2);
		table2.setFont(new Font("Comic sans", Font.PLAIN, 14));
		panel2.setBackground(new Color(0xDAF5FF));
		panel2.setBorder(null);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(35, 329, 130, 36);
		comboBox_1.addItem("Sort By Email");
		comboBox_1.addItem("Sort By Name");
		comboBox_1.addItem("Sort By Address");
		comboBox_1.addItem("Sort By Gender");
		comboBox_1.addItem("Sort By Age");
		comboBox_1.addItem("Sort By Amount");
		comboBox_1.addActionListener(e -> {
			String collectComboItem1 = (String) comboBox_1.getSelectedItem();
			if(collectComboItem1.equals("Sort By Email")){
				String query = "select * from sales order by Email;";
				s.sort(table2, dm2, query);
			}else if(collectComboItem1.equals("Sort By Name")){
				String query = "select * from sales order by Name;";
				s.sort(table2, dm2, query);
			}else if(collectComboItem1.equals("Sort By Address")) {
				String query = "select * from sales order by Address;";
				s.sort(table2, dm2, query);
			}else if(collectComboItem1.equals("Sort By Gender")) {
				String query = "select * from sales order by Gender;";
				s.sort(table2, dm2, query);
			}else if(collectComboItem1.equals("Sort By Age")) {
				String query = "select * from sales order by Age;";
				s.sort(table2, dm2, query);
			}else if(collectComboItem1.equals("Sort By Amount")) {
				String query = "select * from sales order by Amount;";
				s.sort(table2, dm2, query);
			}
		});
		panel2.add(comboBox_1);
		
		JButton btnNewButton = new JButton("View Analysis");
		btnNewButton.setBounds(200, 399, 300, 50);
		btnNewButton.setFont(new Font("Comic sans", Font.PLAIN, 25));
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(e -> {
			new DataAnalysis();
		});
		panel2.add(btnNewButton);
		
		btn3.addActionListener(e -> {
			try {
				System.out.println("Enter in go to bill");
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject", "root", "namMaha@123");
				String query = "select * from prescriptionnmedicine where PatientEmail=? ";
				pst = con.prepareStatement(query);
				pst.setString(1, emailId);
				rs = pst.executeQuery();
				if(rs.next() == false) {
					String[] responses = {"Go to Main Menu"};
					ImageIcon icon = new ImageIcon("icons8-card-payment-50.png");
					int collect = JOptionPane.showOptionDialog(
							null,
							"No prescription available",
							"You are prescriptionless",
							JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.INFORMATION_MESSAGE,
							icon,
							responses,
							0);
					if(collect == 0) {
						new Menu(emailId, 2);
						frame.dispose();
					}
				}else {
					Bill.deleteRows();
					Menu_Prescription_Table m = new Menu_Prescription_Table();
					
					String medNames = rs.getString(4);
					String medArr[] = medNames.split("[,]", 0);
					int medNoArr[] = new int[medArr.length];
					int count = 0;
				    for(String myStr: medArr){
				        medNoArr[count] = m.search(myStr);
				        count++;
				    }
				    
					String qty = rs.getString(5);
					String qtyArr[] = qty.split("[,]", 0);
					String price = rs.getString(6);
					String priceArr[] = price.split("[,]", 0);
					double sum = 0;
					
					for (int i =0; i<medArr.length; i++) {
						try {
							sum = sum + Integer.parseInt(qtyArr[i])*Double.parseDouble(priceArr[i]);
							Bill.insert(medNoArr[i], medArr[i], qtyArr[i], Double.parseDouble(priceArr[i]));
						} catch (SQLException e1) {
							
						}
					}
					
					ArrayList<BillContent> bi = new ArrayList<>();
					
					for (int i = 0; i < medArr.length; i++) {
						int no = medNoArr[i];
						String name = medArr[i];
						String qty1 = qtyArr[i];
						double price1 = Double.parseDouble(priceArr[i]);
						
						BillContent bc = new BillContent(no, name, qty1, price1);

						bi.add(bc);
					}
					
					s = new Sales(sum);
					s.MedicineAttri(new MedicineData(bi));
					
					s.insert(email);
					
					JPanel panel_1 = new JPanel();
					panel_1.setBounds(532, 373, 137, 37);
					panel1.add(panel_1);
					panel_1.setLayout(null);
					
					JLabel lblNewLabel_3 = new JLabel();
					System.out.println("++++++++++++++++++++++++++++++Sum : "+sum);
					lblNewLabel_3.setText(""+sum);
					lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
					lblNewLabel_3.setBounds(10, 7, 117, 27);
					panel_1.add(lblNewLabel_3);
					
					scrollPane2.setViewportView(b2.displayInTable(table1, dm1));
					scrollPane3.setViewportView(s.displayInTable(table2, dm2));
//					frame.dispose();
				}
				
			} catch (Exception e1) {
				
			}
		});	
		
		
		
		
		frame.setVisible(true);
		
	}
}
