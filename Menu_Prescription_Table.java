import java.awt.Color;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.lang.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu_Prescription_Table extends JFrame {
	
	static String db_url = "jdbc:mysql://localhost:3306/miniproject";
	static String user = "root";
	static String pass = "namMaha@123";
	
	public static int search(String medName) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject", "root", "namMaha@123");
			String query = "select * from medicine where MedName=? ";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, medName);
			ResultSet rs = pst.executeQuery();
			if(rs.next() == false) {
				return 0;
			}else {
				return rs.getInt(1);
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
			ResultSetMetaData rsmd = rs.getMetaData();
			
			String[] colName = new String[6];

			colName[0] = rsmd.getColumnName(1);
			colName[1] = rsmd.getColumnName(2);
			colName[2] = rsmd.getColumnName(3);
			colName[3] = rsmd.getColumnName(4);
			colName[4] = rsmd.getColumnName(5);
			colName[5] = rsmd.getColumnName(6);

			dm.setColumnIdentifiers(colName);
			dm.setRowCount(0);
			int PresId;
			String PhysicianName, PatientEmail, MedNames, Qty, Price;
			while(rs.next()) {
				PresId = rs.getInt(1);
				PhysicianName = rs.getString(2);
				PatientEmail = rs.getString(3);
				MedNames = rs.getString(4);
				Qty = rs.getString(5);
				Price = rs.getString(6);
				
				Object[] data = {PresId,PhysicianName, PatientEmail, MedNames, Qty, Price};
				dm.addRow(data);
			}
			
		} catch (ClassNotFoundException | SQLException ex) {

		}
		
		return table;
	}
	
	public static JTable insert(JTable table, DefaultTableModel dm, String EmailId) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(db_url, user, pass);
			Statement st = con.createStatement();
			String query = "select * from prescriptionnmedicine;";
			ResultSet rs = st.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			
			String[] colName = new String[6];

			colName[0] = rsmd.getColumnName(1);
			colName[1] = rsmd.getColumnName(2);
			colName[2] = rsmd.getColumnName(3);
			colName[3] = rsmd.getColumnName(4);
			colName[4] = rsmd.getColumnName(5);
			colName[5] = rsmd.getColumnName(6);

			dm.setColumnIdentifiers(colName);
			dm.setRowCount(0);
			int PresId;
			String PhysicianName, PatientEmail, MedNames, Qty, Price;
			while(rs.next()) {
				PresId = rs.getInt(1);
				PhysicianName = rs.getString(2);
				PatientEmail = rs.getString(3);
				MedNames = rs.getString(4);
				Qty = rs.getString(5);
				Price = rs.getString(6);
				
				Object[] data = {PresId,PhysicianName, PatientEmail, MedNames, Qty, Price};
				dm.addRow(data);
			}
			
		} catch (ClassNotFoundException | SQLException ex) {

		}
		
		return table;
	}
}