package model.demo;

import java.sql.Date;
import java.util.Arrays;

import model.CustomerDAO;
import model.dao.CustomerDAOJdbc;


public class CustomerDAODEMO {
	public static void main(String[] args) throws Exception {
		
		CustomerDAO dao = new CustomerDAOJdbc();
		
//		CustomerBean result = dao.findByPrimaryKey("Alex");
//		System.out.println(result);

		
//		byte[] x = "1101".getBytes(); //x = 49 49 48 49
//		String d = new String(x); //d = 1101
		
		Boolean result2 = dao.update("0x41".getBytes(), "kdiouu@gmail.com", Date.valueOf("2016-11-20"), "Alex");
		System.out.println(result2);
		
	}
}
