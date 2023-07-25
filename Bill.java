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
import javax.swing.table.TableColumn;

public class Bill {
	
	static String db_url = "jdbc:mysql://localhost:3306/miniproject";
	static String user = "root";
	static String pass = "namMaha@123";
	
	public static void deleteRows() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(db_url, user, pass);
			
			String sql4 = "delete from bill";
			
			Statement stmt2 = con.createStatement();
			stmt2.executeUpdate(sql4);
			System.out.println("data Deleted");
			con.close();

		} catch (Exception ex) {
			
		}
		
	}
	
	public static void insert(int No, String Name, String qty, double price) throws SQLException {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(db_url, user, pass);
			Statement stmt1;
			stmt1 = con.createStatement();
			String sql2 = "insert into bill(Med_BatchNo, Name, Qty, Amount)" + "values(?,?,?,?)";
			PreparedStatement pst1 = con.prepareStatement(sql2);
			pst1.setInt(1, No);
			pst1.setString(2, Name);
			pst1.setString(3, qty);
			pst1.setDouble(4, price);
			pst1.executeUpdate();
			System.out.println("Executed");
			con.close();
			
		}catch(Exception ex){
			
		}
    }
	
	public static JTable displayInTable(JTable table, DefaultTableModel dm) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(db_url, user, pass);
			Statement st = con.createStatement();
			
			String query = "select * from bill";
			ResultSet rs = st.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			
			String[] colName = new String[4];

			colName[0] = "Med_BatchNo";
			colName[1] = "Name";
			colName[2] = "Qty";
			colName[3] = "Amount";

			dm.setColumnIdentifiers(colName);
			dm.setRowCount(0);
			int no;
			double amount;
			String name, qty;
			while(rs.next()) {
				no = rs.getInt(1);
				name = rs.getString(2);
				qty = rs.getString(3);
				amount = rs.getDouble(4);
				Object[] data = {no, name, qty, amount};
				dm.addRow(data);
			}
			
			con.close();
			
		} catch (ClassNotFoundException | SQLException ex) {

		}
		
		return table;
	}
	
}
