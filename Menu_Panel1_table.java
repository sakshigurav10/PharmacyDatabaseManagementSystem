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

public class Menu_Panel1_table extends JFrame {
	
	static String db_url = "jdbc:mysql://localhost:3306/miniproject";
	static String user = "root";
	static String pass = "namMaha@123";
	
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
			colName[2] = "Mfg";
			colName[3] = "Exp";
			colName[4] = "Price";
			colName[5] = "Qty";

			dm.setColumnIdentifiers(colName);
			dm.setRowCount(0);
			int no;
			double price;
			String name;
			Date exp;
			Date mfg;
			while(rs.next()) {
				no = rs.getInt(1);
				name = rs.getString(2);
				mfg = rs.getDate(3);
				exp = rs.getDate(4);
				price = rs.getDouble(5);
				Object[] data = {no, name, mfg, exp, price};
				dm.addRow(data);
			}
			
			JComboBox combo = new JComboBox();
			for (int i = 1; i < 100; i++) {
				String item = Integer.toString(i);
				combo.addItem(item);
			}
			
			//Inserting dropdown at 3rd column having index 2
			TableColumn col = table.getColumnModel().getColumn(5);
			col.setCellEditor(new DefaultCellEditor(combo));
			
		} catch (ClassNotFoundException | SQLException ex) {

		}
		
		return table;
	}
	
	public static JTable insert(JTable table, DefaultTableModel dm) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(db_url, user, pass);
			Statement st = con.createStatement();
			
			String query = "select Med_BatchNo, MedName, Mfg, Exp, Price from medicine";
			ResultSet rs = st.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			
			String[] colName = new String[6];

			colName[0] = rsmd.getColumnName(1);
			colName[1] = rsmd.getColumnName(2);
			colName[2] = "Mfg";
			colName[3] = "Exp";
			colName[4] = "Price";
			colName[5] = "Qty";

			dm.setColumnIdentifiers(colName);
			dm.setRowCount(0);
			int no;
			double price;
			String name;
			Date exp;
			Date mfg;
			while(rs.next()) {
				no = rs.getInt(1);
				name = rs.getString(2);
				mfg = rs.getDate(3);
				exp = rs.getDate(4);
				price = rs.getDouble(5);
				Object[] data = {no, name, mfg, exp, price};
				dm.addRow(data);
			}
			
			JComboBox combo = new JComboBox();
			for (int i = 1; i < 100; i++) {
				String item = Integer.toString(i);
				combo.addItem(item);
			}
			
			//Inserting dropdown at 3rd column having index 2
			TableColumn col = table.getColumnModel().getColumn(5);
			col.setCellEditor(new DefaultCellEditor(combo));
			
		} catch (ClassNotFoundException | SQLException ex) {

		}
		
		return table;
	}
}