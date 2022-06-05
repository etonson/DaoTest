package exe;

import com.factory.DAOFactory;
import com.vo.User;

public class TestDAO {
	public static void main(String args[]) throws Exception {
		User emp = null;
		try {
			emp = new User();
			emp.setAccount("spencer");
			emp.setEmail("spen@123");
			emp.setName("spencer");
			emp.setPwd("123456");

			DAOFactory.getInstance().doCreate(emp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			emp = new User();
			emp.setAccount("eton");
			emp.setEmail("spen@123");
			emp.setName("spencer");
			emp.setPwd("123456");

			DAOFactory.getInstance().doCreate(emp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}