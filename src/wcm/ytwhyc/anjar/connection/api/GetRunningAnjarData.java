package wcm.ytwhyc.anjar.connection.api;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

import wcm.ytwhyc.anjar.connection.JSONRequest;
import wcm.ytwhyc.anjar.datatype.Reply;

public class GetRunningAnjarData extends JSONRequest{

	@Override
	public String getApiUrl() {
		// TODO Auto-generated method stub
		return APIURL.getRunningAnjarData;
	}
	
	public GetRunningAnjarData(String anjarID)
	{
		this.addParamPair("anjar_id", anjarID);
	}

    public Result parseJson() throws JSONException
    {
    	Result ret = new Result();
    	ret.currentPageNumber = json.getString("CurrentPageNumber");
    	ret.targetFloor = json.getString("TargetFloor");
    	
    	ArrayList<Reply> replys = new ArrayList<Reply>();
    	JSONArray ja = json.getJSONArray("AllReplys");
    	for(int i = 0 ; i< ja.length();i++)
    	{
    		Reply reply = new Reply(ja.getJSONObject(i));
    		replys.add(reply);
    	}
    	ret.allReplys = replys;
    	return ret;
    }
	
	public class Result
	{
		public String currentPageNumber;
		public String targetFloor;
		public ArrayList<Reply> allReplys;
	}
}
