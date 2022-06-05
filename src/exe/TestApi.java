package exe;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.vo.Issue;

import api.issue.ApiIssue;

public class TestApi {

	public static void main(String[] args) {

		try {
			JSONObject requestData = new JSONObject();
			requestData.put("recipient", "eton");
			ApiIssue testApi = new ApiIssue();
			JSONObject responseData = new JSONObject();
			responseData = testApi.showBriefIssue(requestData);
			JSONArray data = responseData.getJSONArray("data");
			List ist = new ArrayList<Issue>();
			for (int i = 0; i < data.length(); i++)
				ist.add(data.get(1));
			Issue t1 = (Issue) ist.get(0);
			System.out.println(t1.getRecipient());
		} catch (Exception e) {
			System.out.println(0);
			System.out.println(e.getMessage());
		}
	}

}
