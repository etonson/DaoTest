package api.issue;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.factory.DAOFactory;
import com.vo.Issue;

public class ApiIssue {
	public ApiIssue() {
	}

	public JSONObject showBriefIssue(JSONObject requsetData) {
		JSONObject objJSON = new JSONObject();
		try {
			List<Issue> array = new ArrayList<Issue>();
			String recipient = requsetData.getString("recipient");
			System.out.println("ApiIssue recient  " + recipient);
			array = DAOFactory.getIssueInstance().findAllByRecipient(recipient);
			JSONArray data = new JSONArray();
			if (array.size() > 1) {
				for (int i = 0; i < array.size(); i++) {
					data.put(array.get(i));
				}
				objJSON.put("recipient", recipient);
				objJSON.put("data", data);
			}
		} catch (Exception e) {

		}
		return objJSON;
	}
}
