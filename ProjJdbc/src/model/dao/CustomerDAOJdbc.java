package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import model.CustomerBean;
import model.CustomerDAO;

public class CustomerDAOJdbc implements CustomerDAO {
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=java";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "passw0rd";

	private static final String SELECT_BY_PK = "select * from customer where custid=?";

	@Override
	public CustomerBean findByPrimaryKey(String custid) throws Exception {
		CustomerBean result = null;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_PK);
		pstmt.setString(1, custid);
		ResultSet rs = pstmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();

		if (rs.next()) {
			result = new CustomerBean();
			result.setCustid(rs.getString(rsmd.getColumnName(1)));
			result.setPassword(rs.getBytes((rsmd.getColumnName(2))));
			result.setEmail(rs.getString((rsmd.getColumnName(3))));
			result.setBirth(rs.getDate((rsmd.getColumnName(4))));

		}
		rs.close();
		conn.close();
		return result;
	}

	private static final String UPDATE = "update customer set password=?, email=?, birth=? where custid=?";

	@Override
	public boolean update(byte[] password, String email, java.util.Date birth, String custid) throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		PreparedStatement pstmt = conn.prepareStatement(UPDATE);
		
		pstmt.setBytes(1, password);
		pstmt.setString(2, email);
		java.sql.Date sqldate = new java.sql.Date(birth.getTime());
		pstmt.setDate(3, sqldate);
		pstmt.setString(4, custid);
		System.out.println(password);
		int updatecheck = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		if (updatecheck != 1) {
			return false;
		} else {
			return true;
		}
	}
}
