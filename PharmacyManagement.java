import java.sql.*;
import java.util.*;

class PharmacyManagement {
	
	static String db_url = "jdbc:mysql://localhost:3306/miniproject";
	static String user = "root";
	static String pass = "namMaha@123";
	
	public static void insert(String email, String name, String address, String phNo, int age, String gender) throws SQLException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connecting to database");
			Connection con = DriverManager.getConnection(db_url, user, pass);
			Statement stmt;
			stmt = con.createStatement();
			// Inserting data using SQL query
			String sql1 = "insert into customer(email, name, address, phNo, age, gender)" + "values(?,?,?,?,?,?)";
			System.out.println("Prepared");
			PreparedStatement pst = con.prepareStatement(sql1);
			pst.setString(1, email);
			pst.setString(2, name);
			pst.setString(3, address);
			pst.setString(4, phNo);
			pst.setInt(5,age);
			pst.setString(6, gender);
			
			pst.execute();
			
			System.out.println("Executed");
			con.close();
			
		}catch(Exception ex){
			
		}
    }

	public static void main(String args[]) throws Exception {
		try {
			
			new Login();
//			
//			insert("namita.mahamuni@cumminscollege.in", "Namita Mahamuni", "KV, Pune", "9970857677", 21, "F");
			
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}

