package model.dao;

import java.util.List;

import model.ProductBean;
import model.ProductDAO;

public class ProductDAOJdbc implements ProductDAO {
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=java";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "passw0rd";

	private static final String SELECT_BY_PK = "select * from product where id=?";
	@Override
	public ProductBean findByPrimaryKey(int id) {
		ProductBean result = null;
		
		return result;
	}
	
	private static final String SELECT_ALL = "select * from product";
	@Override
	public List<ProductBean> findAll() {
		List<ProductBean> result = null;
		
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
