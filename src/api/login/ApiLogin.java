package api.login;

import org.json.JSONObject;

import com.factory.DAOFactory;
import com.vo.User;

public class ApiLogin {
	private JSONObject requestData = null;

	public ApiLogin(JSONObject requestData) {
		this.requestData = requestData;
	}

	// request(account,pwd)
	// 有此身份response為1 否則為0
	public int checkExit() {
		JSONObject requestData = this.requestData;
		try {
			String account = requestData.getString("account");
			String pwd = requestData.getString("pwd");
			User user = new User();
			user = DAOFactory.getInstance().checkExistById(account, pwd);
			System.out.println(user.getName());
			if (user.getName() != null) {
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}
}
