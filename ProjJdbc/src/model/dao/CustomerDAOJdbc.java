package model.dao;

import model.CustomerBean;
import model.CustomerDAO;

public class CustomerDAOJdbc implements CustomerDAO {
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=java";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "passw0rd";
	
	private static final String SELECT_BY_PK = "select * from customer where custid=?";
	@Override
	public CustomerBean findByPrimaryKey(String custid) {
		CustomerBean result = null;
		
		return result;
	}
	private static final String UPDATE = "update customer set password=?, email=?, birth=? where custid=?";
	@Override
	public boolean update(byte[] password, String email, java.util.Date birth, String custid) {

		return false;
	}
}
