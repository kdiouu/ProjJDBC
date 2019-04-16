package model;

import java.util.List;

public interface ProductDAO {

	ProductBean findByPrimaryKey(int id);

	List<ProductBean> findAll();

	ProductBean update(String name, double price, java.util.Date make, int expire, int id);

	ProductBean create(ProductBean bean);

	boolean remove(int id);

}