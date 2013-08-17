package wcm.ytwhyc.anjar.connection.api;

import org.json.JSONException;

import wcm.ytwhyc.anjar.connection.JSONRequest;
import wcm.ytwhyc.anjar.connection.api.GetNEWS.Result;

public class NewReply extends JSONRequest{

	@Override
	public String getApiUrl() {
		// TODO Auto-generated method stub
		return APIURL.newReply;
	}

	public NewReply(String userID,String userName,String anjarID,String pageNumber,String content)
	{
		this.addParamPair("user_id", userID);
		this.addParamPair("user_name", userName);
		this.addParamPair("anjar_id", anjarID);
		this.addParamPair("page_num", pageNumber);
		this.addParamPair("content", content);
	}
	
	public Result parseJson() throws JSONException
	{
		Result res = new Result();
	
		res.status = json.getString("Status");
		
		return res;
	}
	
	public class Result
	{
		public String status;
	}
}
