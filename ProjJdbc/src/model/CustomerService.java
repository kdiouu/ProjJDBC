package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import com.sun.org.apache.bcel.internal.util.ByteSequence;

import model.CustomerBean;
import model.CustomerDAO;
import model.CustomerService;
import model.dao.CustomerDAOJdbc;

public class CustomerService {
	public CustomerBean login(String username, String password) throws Exception {

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=java", "sa",
				"passw0rd");
		PreparedStatement pstmt = conn
				.prepareStatement("select convert(varchar,password) as password from customer where custid=?");
		pstmt.setString(1, username);
		ResultSet rs = pstmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();

		if (rs.next()) {
			if (rs.getString(rsmd.getColumnName(1)).equals(password)) {
				System.out.println("login in success");
			} else {
				System.out.println("wrong password");
			}
		} else {
			System.out.println("wrong username");
		}

		return null;
	}

	public boolean changePassword(String username, String oldPassword, String newPassword) throws Exception {

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=java", "sa",
				"passw0rd");
		PreparedStatement pstmt = conn
				.prepareStatement("select convert(varchar,password) as password from customer where custid=?");
		pstmt.setString(1, username);
		ResultSet rs = pstmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int i = 0;
		if (rs.next()) {
			if (rs.getString(rsmd.getColumnName(1)).equals(oldPassword)) {
				if (oldPassword.equals(newPassword) == false) {
					pstmt = conn.prepareStatement("update customer set password=? where custid=?");
					pstmt.setBytes(1, newPassword.getBytes());
					pstmt.setString(2, username);
					i = pstmt.executeUpdate();
				} else if (oldPassword.equals(newPassword) == true) {
					System.out.println("newpassword must different from oldpassword");
				}
			} else if (rs.getString(rsmd.getColumnName(1)).equals(oldPassword) == false) {
				System.out.println("wrong password!");
			}
		} else {
			System.out.println("wrong username; please re-login or sign up one");
		}

		rs.close();
		pstmt.close();
		conn.close();
		if (i == 1) {
			return true;
		} else {
			return false;
		}
	}
}
