package model.demo;

import java.sql.Date;
import java.util.Arrays;

import model.CustomerBean;
import model.CustomerDAO;
import model.dao.CustomerDAOJdbc;
import model.CustomerService;

public class CustomerDAODEMO   {
	public static void main(String[] args) throws Exception {
		CustomerService cs = new CustomerService();
		cs.login("Alex", "A");
		
		CustomerDAO dao = new CustomerDAOJdbc();



		
//		CustomerBean result = dao.findByPrimaryKey("Alex");
//		System.out.println(result);
		

		
//		Boolean result2 = dao.update("A".getBytes(), "kdiouu@gmjail.com", Date.valueOf("2016-11-20"), "Alex");
//		System.out.println(result2);
		
	}
}
