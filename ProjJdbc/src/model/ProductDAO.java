package model;

import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {

	ProductBean findByPrimaryKey(int id) throws SQLException, Exception;

	List<ProductBean> findAll() throws SQLException, Exception;

	ProductBean update(String name, double price, java.util.Date make, int expire, int id);

	ProductBean create(ProductBean bean);

	boolean remove(int id);

}