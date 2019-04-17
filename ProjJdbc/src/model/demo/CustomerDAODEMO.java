package model.demo;

import java.sql.Date;
import java.util.Arrays;

import model.CustomerBean;
import model.CustomerDAO;
import model.dao.CustomerDAOJdbc;
import model.CustomerService;

public class CustomerDAODEMO {
	public static void main(String[] args) throws Exception {

		CustomerDAO dao = new CustomerDAOJdbc();

		CustomerService cs = new CustomerService();

		// Login
//		cs.login("Alex", "A");

		// ChangePSW
//		Boolean x = cs.changePassword("Alex", "A", "X");
//		if(x==true) {
//		System.out.println("change password success!");
//		}
		
		// Findbyprimarykey
//		CustomerBean result = dao.findByPrimaryKey("Alex");
//		System.out.println(result);

		// Update
//		Boolean result2 = dao.update("A".getBytes(), "kdiouu@gmjail.com", Date.valueOf("2016-11-20"), "Alex");
//		System.out.println(result2);

	}
}
