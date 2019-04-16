package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ProductBean;
import model.ProductDAO;

public class ProductDAOJdbc implements ProductDAO {
	private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Java";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "passw0rd";

	private static final String SELECT_BY_PK = "select * from product where id=?";
	@Override
	public ProductBean findByPrimaryKey(int id) throws SQLException, Exception {
		ProductBean result = null;
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_PK);
		
		pstmt.setInt(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		while(rs.next()) {
			result = new ProductBean();
			result.setId(rs.getInt(rsmd.getColumnName(1)));
			result.setName(rs.getString(rsmd.getColumnName(2)));
			result.setPrice(rs.getInt(rsmd.getColumnName(3)));
			result.setMake(rs.getDate(rsmd.getColumnName(4)));
			result.setExpire(rs.getInt(rsmd.getColumnName(5)));
		}
		rs.close();
		conn.close();
		return result;
	}
	
	private static final String SELECT_ALL = "select * from product";
	@Override
	public List<ProductBean> findAll() throws SQLException, Exception {
		List<ProductBean> result = null;
		ProductBean productresult = null;
		result = new ArrayList<ProductBean>();
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL);
		ResultSet rs = pstmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		while (rs.next()) {
			productresult = new ProductBean();
			productresult.setId(rs.getInt(rsmd.getColumnName(1)));
			productresult.setName(rs.getString(rsmd.getColumnName(2)));
			productresult.setPrice(rs.getInt(rsmd.getColumnName(3)));
			productresult.setMake(rs.getDate(rsmd.getColumnName(4)));
			productresult.setExpire(rs.getInt(rsmd.getColumnName(5)));
			result.add(productresult);
		}
		return result;
	}
	
	private static final String UPDATE =
			"update product set name=?, price=?, make=?, expire=? where id=?";
	@Override
	public ProductBean update(String name, double price, java.util.Date make, int expire, int id) {
		ProductBean result = null;
		
		return result;
	}
	
	private static final String INSERT =
			"insert into product (id, name, price, make, expire) values (?, ?, ?, ?, ?)";
	@Override
	public ProductBean create(ProductBean bean) {
		ProductBean result = null;
		
		return result;
	}
	
	private static final String DELETE = "delete from product where id=?";
	@Override
	public boolean remove(int id) {
		
		return false;
	}
}
