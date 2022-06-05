package exe;

import com.factory.DAOFactory;
import com.vo.Issue;

public class TestIssueDAO {

	public static void main(String[] args) {
		Issue emp = null;
		try {
			emp = new Issue();
			emp.setIssueTitle("spencer-");
			emp.setIssueDescribe("testdoc");
			emp.setStatus(0);
			emp.setRecipient("eton");
			emp.setAssigness("spencer");
			emp.setStartDate("2022-06-07");
			emp.setDeadDate("2022-06-14");
			DAOFactory.getIssueInstance().doCreate(emp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
