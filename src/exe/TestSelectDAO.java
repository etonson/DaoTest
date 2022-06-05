package exe;

import java.util.ArrayList;
import java.util.List;

import com.factory.DAOFactory;
import com.vo.Issue;

public class TestSelectDAO {
	public static void main(String[] args) {
		try {
			List<Issue> list = new ArrayList<Issue>();
			list = DAOFactory.getIssueInstance().findAllByRecipient("eton");
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).getDeadDate());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}