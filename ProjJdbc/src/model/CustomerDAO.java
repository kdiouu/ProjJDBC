package model;

public interface CustomerDAO {

	CustomerBean findByPrimaryKey(String custid) throws Exception;
	boolean update(byte[] password, String email, java.util.Date birth, String custid) throws Exception;

}