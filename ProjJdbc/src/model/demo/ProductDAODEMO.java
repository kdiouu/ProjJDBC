package model.demo;

import java.sql.Date;
import java.util.List;

import model.ProductBean;
import model.ProductDAO;
import model.dao.ProductDAOJdbc;

public class ProductDAODEMO {
	public static void main(String[] args) throws Exception {
		ProductDAO dao = new ProductDAOJdbc();
		
		ProductBean result = dao.findByPrimaryKey(5);
		System.out.println(result);
		
		
//		List<ProductBean> findAllresult = dao.findAll();
//		for (ProductBean productresult : findAllresult) {
//			System.out.print(productresult.getId() + ", ");
//			System.out.print(productresult.getName() + ", ");
//			System.out.print(productresult.getPrice() + ", ");
//			System.out.print(productresult.getMake() + ", ");
//			System.out.print(productresult.getExpire() + "\n");
//		}
//		System.out.println("---------------------------------");
		
//		ProductBean updateresult = dao.update("apple", Double.valueOf(5), Date.valueOf("2015-05-25"), 3, 1);
//		System.out.println(updateresult);
		
//		ProductBean insertresult  = new ProductBean();
//		insertresult.setId(19);
//		insertresult.setName("bababa");
//		insertresult.setPrice(20);
//		insertresult.setMake(Date.valueOf("2015-02-22"));
//		insertresult.setExpire(5);
//		ProductBean insertresult2 = dao.create(insertresult);
//		System.out.println(insertresult2);
		
//		System.out.println(dao.remove(19));
	}
}
