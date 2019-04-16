package model.demo;

import java.util.List;

import model.ProductBean;
import model.ProductDAO;
import model.dao.ProductDAOJdbc;

public class ProductDAODEMO {
	public static void main(String[] args) throws Exception {
		ProductDAO dao = new ProductDAOJdbc();
		
//		ProductBean result = dao.findByPrimaryKey(5);
//		System.out.println(result);
		
		
		List<ProductBean> result = dao.findAll();
		for (ProductBean productresult : result) {
			System.out.print(productresult.getId() + ", ");
			System.out.print(productresult.getName() + ", ");
			System.out.print(productresult.getPrice() + ", ");
			System.out.print(productresult.getMake() + ", ");
			System.out.print(productresult.getExpire() + "\n");
		}
		System.out.println("---------------------------------");
	}
}
