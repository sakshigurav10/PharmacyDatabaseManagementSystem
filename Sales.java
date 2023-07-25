import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Sales {
	
	static String db_url = "jdbc:mysql://localhost:3306/miniproject";
	static String user = "root";
	static String pass = "namMaha@123";
	
	static String email, name, phno, add, gender;
	static int age;
	static ArrayList<BillContent> arr;
	static String medNames = "";
	static double amount;
	
	static Connection con;	
	
	Sales(){
		
	}
	
	Sales(double amount){
		this.amount = amount;
	}
	
	public static void CustAttri(CollectCustomerData c) {
		email = c.email;
		name = c.name;
		phno = c.phno;
		add = c.add;
		gender = c.gender;
		age = c.age;
	}
	
	public static void MedicineAttri(MedicineData m) {
		arr = m.arr;
		for(BillContent b : arr) {
			medNames = medNames +", "+b.name;
			System.out.println(b.toString());
		}
		
		System.out.println("medNames : "+medNames);
	}
	
	public static void insert() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connecting to database");
			Connection con;
			con = DriverManager.getConnection(db_url, user, pass);
			Statement stmt;
			stmt = con.createStatement();
			Scanner sc = new Scanner(System.in);

			// Inserting data using SQL query
			String sql1 = "insert into sales(Email,Name,PhNo,Address,Gender,Age,MedNames,Amount)values(?,?,?,?,?,?,?,?)";
			System.out.println("Prepared");
			PreparedStatement pst = con.prepareStatement(sql1);
			pst.setString(1, email);
			pst.setString(2, name);
			pst.setString(3, phno);
			pst.setString(4, add);
			pst.setString(5, gender);
			pst.setInt(6, age);
			pst.setString(7, medNames);
			pst.setDouble(8, amount);
			pst.execute();
			System.out.println("Inserted into table");
			con.close();

			} catch (Exception ex) {
			System.out.println(ex);
			}
	}
	
	public static void insert(String emailId) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connecting to database");
			Connection con;
			con = DriverManager.getConnection(db_url, user, pass);
			Statement stmt;
			stmt = con.createStatement();
			Scanner sc = new Scanner(System.in);

			// Inserting data using SQL query
			
//			rs2 = pst.executeQuery();
			
			String query = "select * from customer where Email=? ";
			PreparedStatement pst1 = con.prepareStatement(query);
			pst1.setString(1, emailId);
			ResultSet rs = pst1.executeQuery();
			
			while(rs.next()) {
				email = rs.getString(1);
				name = rs.getString(2);
				phno = rs.getString(4);
				add = rs.getString(3);
				gender = rs.getString(6);
				age = rs.getInt(5);
			}
			
			
			String sql1 = "insert into sales(Email,Name,PhNo,Address,Gender,Age,MedNames,Amount)values(?,?,?,?,?,?,?,?)";
			System.out.println("Prepared");
			PreparedStatement pst = con.prepareStatement(sql1);
			
			pst.setString(1, email);
			pst.setString(2, name);
			pst.setString(3, phno);
			pst.setString(4, add);
			pst.setString(5, gender);
			pst.setInt(6, age);
			pst.setString(7, medNames);
			pst.setDouble(8, amount);
			pst.executeUpdate();
			System.out.println("Inserted into table");
			System.out.println(email+name+phno+add+gender+age+medNames+amount);
			con.close();

			} catch (Exception ex) {
			System.out.println(ex);
			}
	}
	
	public static void update(String emailId){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connecting to update");
			Connection con;
			con = DriverManager.getConnection(db_url, user, pass);
			Statement stmt;
			stmt = con.createStatement();
			
			String query = "update sales set MedNames=?, Amount=? where Email=?";
			
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1, medNames);
			pst.setDouble(2, amount);
			pst.setString(3, emailId);
			
			pst.executeUpdate();
			
			
			System.out.println("Updated");
			pst.close();
			con.close();
			
		} catch (Exception ex) {
		}
    }
	
	public static int search(String emailId) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject", "root", "namMaha@123");
			String query = "select * from sales where Email=? ";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, emailId);
			ResultSet rs = pst.executeQuery();
			if(rs.next() == false) {
				return 0;
			}else {
				return 1;
			}
			
		} catch (Exception e1) {
			
		}
		
		return 0;
	}
	
	public static JTable sort(JTable table, DefaultTableModel dm, String query) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(db_url, user, pass);
				PreparedStatement ps =con.prepareStatement(query);
				ResultSet rs =  ps.executeQuery(query);
				
				String[] colName = new String[8];

				colName[0] = "Email";
				colName[1] = "Name";
				colName[2] = "PhNo";
				colName[3] = "Address";
				colName[4] = "Gender";
				colName[5] = "Age";
				colName[6] = "MedNames";
				colName[7] = "Amount";

				dm.setColumnIdentifiers(colName);
				dm.setRowCount(0);
				int age;
				double amount;
				String email, name, add, phNo, gender, medNames;
				while(rs.next()) {
					email = rs.getString(1);
					name = rs.getString(2);
					phNo = rs.getString(3);
					add = rs.getString(4);
					gender = rs.getString(5);
					age = rs.getInt(6);
					medNames = rs.getString(7);
					amount = rs.getDouble(8);
					
					Object[] data = {email, name, phNo, add, gender, age, medNames, amount};
					dm.addRow(data);
				}
				
				con.close();
				
			} catch (ClassNotFoundException | SQLException ex) {

			}
			
			return table;
	}
	
	public static JTable displayInTable(JTable table, DefaultTableModel dm) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(db_url, user, pass);
			Statement st = con.createStatement();
			
			String query = "select Email, Name, PhNo, Address, Gender, Age, MedNames, Amount from sales";
			ResultSet rs = st.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			
			String[] colName = new String[8];

			colName[0] = "Email";
			colName[1] = "Name";
			colName[2] = "PhNo";
			colName[3] = "Address";
			colName[4] = "Gender";
			colName[5] = "Age";
			colName[6] = "MedNames";
			colName[7] = "Amount";

			dm.setColumnIdentifiers(colName);
			dm.setRowCount(0);
			int age;
			double amount;
			String email, name, add, phNo, gender, medNames;
			while(rs.next()) {
				email = rs.getString(1);
				name = rs.getString(2);
				phNo = rs.getString(3);
				add = rs.getString(4);
				gender = rs.getString(5);
				age = rs.getInt(6);
				medNames = rs.getString(7);
				amount = rs.getDouble(8);
				
				Object[] data = {email, name, phNo, add, gender, age, medNames, amount};
				dm.addRow(data);
			}
			
			con.close();
			
		} catch (ClassNotFoundException | SQLException ex) {

		}
		
		return table;
	}
	
	public int count(String query) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(db_url, user, pass);
			PreparedStatement ps =con.prepareStatement(query);
	        ResultSet rs = ps.executeQuery();  
	        while (rs.next()) {
	            return rs.getInt("count");              
	        }
		} catch (ClassNotFoundException | SQLException ex) {
			
		}
		
		return 0;
	}
	
}



