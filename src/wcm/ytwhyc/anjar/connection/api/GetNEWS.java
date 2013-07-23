package wcm.ytwhyc.anjar.connection.api;

import org.apache.http.HttpResponse;
import org.json.JSONException;
import org.json.JSONObject;

import wcm.ytwhyc.anjar.connection.JSONRequest;

public class GetNEWS extends JSONRequest {

	public String getApiUrl() {
		
		return APIURL.getNEWS;
	}

	public Result parseJson() throws JSONException
	{
		Result res = new Result();
	
		res.status = json.getString("Status");
		res.content = json.getString("Content");
		
		
		return res;
	}
	
	public class Result
	{
		public String status;
		public String content;
	}
}


